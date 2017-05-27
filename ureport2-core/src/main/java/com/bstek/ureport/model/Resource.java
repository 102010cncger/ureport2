package com.bstek.ureport.model;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.bstek.ureport.cache.ResourceCache;

/**
 * @author Jacky.gao
 * @since 2017年3月17日
 */
public class Resource {
	private String key;
	
	public Resource(String path) {
		this.key = path;
	}
	
	public InputStream getResourceData(){
		byte[] imageBytes = (byte[])ResourceCache.getObject(key);
		InputStream inputStream=new ByteArrayInputStream(imageBytes);
		return inputStream;
	}

	public String getKey() {
		return key;
	}
}
