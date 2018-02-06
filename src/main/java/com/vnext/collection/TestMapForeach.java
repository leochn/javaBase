/**
 * 
 */
package com.vnext.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author leo
 * @since 2018-02-06 18:38:40
 */
public class TestMapForeach {

	public static void main(String[] args) {
		
		HashMap<String, String> map = new HashMap<>();
		int mapNum = 10000;// 设置map数据量
		int forNum = 1000;// 设置for循环调用次数，模拟用户访问次数
		// 模拟map已经存储了数据
		for (int i = 0; i < mapNum; i++) {
			map.put("key" + i, "value" + i);
		}

		// 用for循环调用getMap来模拟多次访问
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < forNum; i++) {
			getMap1(map);
		}

		System.out.println("getMap1:" + (System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for (int i = 0; i < forNum; i++) {
			getMap2(map);
		}

		System.out.println("getMap2:" + (System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for (int i = 0; i < forNum; i++) {
			getMap3(map);
		}

		System.out.println("getMap3:" + (System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for (int i = 0; i < forNum; i++) {
			getMap4(map);
		}

		System.out.println("getMap4:" + (System.currentTimeMillis() - startTime) + "ms");
	}
	
	/**
	 * 方法1：while循环 map.entrySet().iterator()获取map的value
	 * @param map
	 */
	public static void getMap1(Map<String, String> map) {
		Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, String> entry = iter.next();
			entry.getKey();
			entry.getValue();
		}
	}
	
	
    /**
     * 方法2：while循环 map.keySet().iterator()获取map的value
     * @param map
     */
	public static void getMap2(Map<String, String> map) {
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			map.get(key);
		}
	}

    /**
     * 方法3
     * foreach循环map.entrySet()获取map的value
     * getMap1的另一种写法，采用foreach循环.foreach循环的底层实现原理就是迭代器Iterator
     * @param map
     */
	public static void getMap3(Map<String, String> map) {
		Set<Map.Entry<String, String>> set = map.entrySet();
		for (Map.Entry<String, String> entry : set) {
			entry.getValue();
		}
	}


    /**
     * 方法4：foreach循环map.keySet()获取map的value
     * @param map
     */
	public static void getMap4(Map<String, String> map) {
		Set<String> set = map.keySet();
		for (String entry : set) {
			map.get(entry);
		}
	}
	
	//getMap1:10687ms
	//getMap2:18345ms
	//getMap3:10313ms
	//getMap4:18329ms
	//基本上方法一的效率和四差不多，比方法二高一倍，方法三比方法一效率高一些，建议采用方法三

}
