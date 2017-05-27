package com.bstek.ureport.console.designer;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.bstek.ureport.console.exception.ReportDesignException;

/**
 * @author Jacky.gao
 * @since 2017年1月26日
 */
public class ReportUtils {
	public static String decodeFileName(String fileName){
		if(fileName==null){
			return fileName;
		}
		try {
			fileName=URLDecoder.decode(fileName, "utf-8");
			fileName=URLDecoder.decode(fileName, "utf-8");
			return fileName;
		} catch (UnsupportedEncodingException e) {
			throw new ReportDesignException(e);
		}
	}
}
