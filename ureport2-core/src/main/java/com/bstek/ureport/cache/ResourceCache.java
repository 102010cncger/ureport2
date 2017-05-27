package com.bstek.ureport.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jacky.gao
 * @since 2017年3月17日
 */
public class ResourceCache {
	private static Map<String,Object> map=new HashMap<String,Object>();
	public static void putObject(String key,Object obj){
		if(map.containsKey(key)){
			map.remove(key);
		}
		map.put(key, obj);
	}
	public static Object getObject(String key){
		return map.get(key);
	}
}
