package com.vnext.atest;

import com.vnext.w00utils.callback.Li;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.alibaba.fastjson.JSON.parseObject;

/**
 * @author leo
 * @version 2018/5/6 7:06
 * @since 1.0.0
 */
public class Test01 {

    public static void main(String[] args) {
        String inletPos = "{x:12,y:22};{x:52,y:252};{x:112,y:122}";
        List<String> strings = Arrays.asList(inletPos.split(";"));
        List<Poi> inletPosList = new ArrayList<>();
        for (String item : strings) {
            Poi poi = parseObject(item, Poi.class);
            inletPosList.add(poi);
            //System.out.println(poi);
        }

        String pumpPos = "{x:12,y:22};{x:52,y:252};{x:112,y:122}/" +
                    "{x:32,y:32};{x:532,y:232};{x:132,y:3122}/" +
                    "{x:42,y:42};{x:552,y:552};{x:55,y:125}";
        List<String> strings1 = Arrays.asList(pumpPos.split("/"));
        List<List<Poi>> pumpPosList = new ArrayList<>();
        for (String item : strings1) {
            //Poi poi = parseObject(item, Poi.class);
            System.out.println(item);
            List<String> temp = Arrays.asList(item.split(";"));
            List<Poi> tmp = new ArrayList<>();
            for (String s : temp) {
                Poi poi = parseObject(s, Poi.class);
                tmp.add(poi);
            }
            pumpPosList.add(tmp);
        }


    }

}

@Data
class Poi {
    private int x;
    private int y;
}

class CurDevicePos{

    /**
     * 	"touchName":"地图名字",
     *     	"touchUrl":"http://www.baidu.com/12123.jpg",
     *     	"remoteCtrlPos":[{"x":122,"y":2323},{"x":122,"y":2323}],
     *     	"inletPos":[{"x":122,"y":2323},{"x":122,"y":2323}],
     *     	"outletPos":[{"x":122,"y":2323},{"x":122,"y":2323}],
     *     	"deviceNamePos":[{"x":122,"y":2323},{"x":122,"y":2323}],
     *     	"pumpPos"
     */

    private List<Poi> inletPos;
    private List<List<Poi>> pumpPos;

}