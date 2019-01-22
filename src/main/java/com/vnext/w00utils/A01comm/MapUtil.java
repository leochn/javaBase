package com.vnext.w00utils.A01comm;

import com.vnext.w00utils.A02entity.DeviceData;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Auther: LEO
 * @Date: 2018/11/7 10:06
 * @Description:
 */
public class MapUtil {

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    // map中的 key 和 value 互换,并过滤key为null或空的值.
    public static HashMap<String, String> reverseKeyValue(HashMap<String, String> oldMap) {
        HashMap<String, String> newMap = new HashMap<>();
        Set<String> keys = oldMap.keySet();
        for(String key : keys){
            String value = oldMap.get(key);
            newMap.put(value,key);
        }
        return filterMapByKey(newMap);
    }


    // 过滤MAP中,key为NULL或为""的值
    public static HashMap<String, String> filterMapByKey(HashMap<String, String> hashMap) {
        HashMap<String, String> collect = (HashMap) hashMap.entrySet().stream().filter(r -> !StringUtils.isEmpty(r.getKey())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return collect;
    }

    public static String getKeyOrNull(Map<String, DeviceData> map) {
        String obj = null;
        for (Map.Entry<String, DeviceData> entry : map.entrySet()) {
            obj = entry.getKey();
            if (obj != null) {
                break;
            }
        }
        return  obj;
    }

    public static DeviceData getFirstOrNull(Map<String, DeviceData> map) {
        DeviceData obj = null;
        for (Map.Entry<String, DeviceData> entry : map.entrySet()) {
            obj = entry.getValue();
            if (obj != null) {
                break;
            }
        }
        return  obj;
    }


}
