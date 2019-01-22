package com.vnext.w15jdk8.stream;

import com.vnext.w00utils.A01comm.TimeUtil;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;


/**
 * @author leo
 * @since 2018/2/28 8:34
 */
public class ListUtils {

    @Test
    public void test(){
        Map<String, List<HistoryData>> maps = mapHandler(list);
        Map<String, List<HistoryData>> newMaps = new HashMap<>();


        Set<Map.Entry<String, List<HistoryData>>> entries = maps.entrySet();
        for (Map.Entry<String, List<HistoryData>> entry : entries) {
            System.out.println(entry.getKey());
            //entry.getValue().stream().sorted((t1,t2)-> t1.getDateTime().compareTo(t2.getDateTime()));
            List<HistoryData> collect = entry.getValue().stream().sorted((t1, t2) -> t1.getDateTime().compareTo(t2.getDateTime())).collect(Collectors.toList());
            newMaps.put(entry.getKey(),collect);

        }
        System.out.println("-=-=-=-=-=-=-=-=-=-=-");
        for (Map.Entry<String, List<HistoryData>> entry : newMaps.entrySet()) {

            System.out.println(entry.getKey());
            entry.getValue().stream().forEach(System.out::println);

        }


    }

    public static Map<String,List<HistoryData>> mapHandler (List<HistoryData> list){
        //list.stream().forEach(System.out::println);
        //System.out.println("---------------------=====================");
        // 过滤，去重,排序，并分组
        Map<String, List<HistoryData>> map = list.stream().filter((item) -> {
            String deviceId = StringUtils.substringBeforeLast(item.getIdService(),"\\\\");
            String serviceCode = StringUtils.substringAfterLast(item.getIdService(),"\\\\");
            String mapKey = String.format("%s|%s",deviceId,serviceCode);
            item.setIdService(mapKey);
            return true;
        }).distinct().collect(Collectors.groupingBy(HistoryData::getIdService));
        //System.out.println(map);

        Set<Map.Entry<String, List<HistoryData>>> entries = map.entrySet();

        String startTimeStr = "2018020100";
        String endTimeStr = "2018020111";
        DateTimeFormatter dateTimeFormatter = TimeUtil.getDateType("day");

        for (Map.Entry<String, List<HistoryData>> entry : entries) {
            // 数字转换，补充完整的时间数据
            int i = 0;
            DateTime startDateTime = DateTime.parse(startTimeStr, dateTimeFormatter);
            DateTime endDateTime = DateTime.parse(endTimeStr, dateTimeFormatter);

            List<HistoryData> historyDataList = entry.getValue();
            int listSize = historyDataList.size();

            // 补充数据前，必须保证list中的数据是按时间排序的。
            for (; startDateTime.compareTo(endDateTime) <= 0; startDateTime = TimeUtil.plus("day", startDateTime)) {
                String timeStr = startDateTime.toString("yyyy-MM-dd HH:mm:ss");
                //判断数据是否需要补充
                if (listSize == i){
                    historyDataList.add(new HistoryData(null,null,timeStr));
                }else if (listSize > i && !timeStr.equals(historyDataList.get(i).getDateTime())){
                    historyDataList.add(new HistoryData(null,null,timeStr));
                }else {
                    // 数据转换代码，倍率
                    historyDataList.get(i).setIdService(null);
                    i++;
                }
            }
        }
        return map;
    }

    public static HashMap<String,List<HistoryData>> mapHandler2 (List<HistoryData> list){
        HashMap<String, List<HistoryData>> newMap = new HashMap<>();
        // 过滤，去重,排序，并分组
        Map<String, List<HistoryData>> map = list.stream().distinct().collect(Collectors.groupingBy(HistoryData::getIdService));

        String startTimeStr = "2018020100";
        String endTimeStr = "2018020109";
        DateTimeFormatter dateTimeFormatter = TimeUtil.getDateType("day");

        for (Map.Entry<String, List<HistoryData>> entry : map.entrySet()) {

            // 数字转换，补充完整的时间数据
            int i = 0;
            DateTime startDateTime = DateTime.parse(startTimeStr, dateTimeFormatter);
            DateTime endDateTime = DateTime.parse(endTimeStr, dateTimeFormatter);

            List<HistoryData> historyDataList = entry.getValue();
            int listSize = historyDataList.size();

            // 补充数据前，必须保证list中的数据是按时间排序的,并且没有时间相同的重复数据。
            for (; startDateTime.compareTo(endDateTime) <= 0; startDateTime = TimeUtil.plus("day", startDateTime)) {
                String timeStr = startDateTime.toString("yyyy-MM-dd HH:mm:ss");
                //判断数据是否需要补充
                if (listSize == i){
                    historyDataList.add(new HistoryData(null,null,timeStr));
                }else if (listSize > i && !timeStr.equals(historyDataList.get(i).getDateTime())){
                    historyDataList.add(new HistoryData(null,null,timeStr));
                }else {
                    // 数据转换代码，倍率
                    //historyDataList.get(i).setIdService(null);
                    i++;
                }
            }
            List<HistoryData> collect = historyDataList.stream().sorted((t1, t2) -> t1.getDateTime().compareTo(t2.getDateTime())).collect(Collectors.toList());

            String deviceId = StringUtils.substringBeforeLast(entry.getKey(),"\\\\");
            String serviceCode = StringUtils.substringAfterLast(entry.getKey(),"\\\\");
            String mapKey = String.format("%s|%s",deviceId,serviceCode);

            newMap.put(mapKey,collect);
        }
        return newMap;
    }



    @Test
    public void test2(){
        Map<String, List<HistoryData>> stringListMap = mapHandler2(list);

        for (Map.Entry<String, List<HistoryData>> stringListEntry : stringListMap.entrySet()) {
            System.out.println(stringListEntry.getKey());
            stringListEntry.getValue().stream().forEach(System.out::println);

        }
    }



    List<HistoryData> list = Arrays.asList(
            new HistoryData(0.21950527f,"17020173101\\\\InletPressure","2018-02-01 04:00:00"),
            new HistoryData(0.21950527f,"17020173101\\\\InletPressure","2018-02-01 05:00:00"),
            new HistoryData(0.24950527f,"17020173101\\\\InletPressure","2018-02-01 06:00:00"),
            new HistoryData(0.21950527f,"17020173101\\\\InletPressure","2018-02-01 06:00:00"),
            new HistoryData(0.21650527f,"17020173101\\\\InletPressure","2018-02-01 08:00:00"),
            new HistoryData(0.21970527f,"17020173101\\\\Pressure","2018-02-01 01:00:00"),
            new HistoryData(0.27950527f,"17020173101\\\\Pressure","2018-02-01 02:00:00"),
            new HistoryData(0.21958527f,"17020173101\\\\Pressure","2018-02-01 03:00:00"),
            new HistoryData(0.21990527f,"17020173101\\\\Pressure","2018-02-01 06:00:00"),
            new HistoryData(0.20950527f,"17020173101\\\\Pressure","2018-02-01 07:00:00"),
            new HistoryData(0.21350527f,"17020173101\\\\Pressure","2018-02-01 08:00:00")
    );

}
