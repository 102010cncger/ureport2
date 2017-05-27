package com.bstek.ureport.console;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jacky.gao
 * @since 2017年3月8日
 */
public class RequestHolder {
	private static final ThreadLocal<HttpServletRequest> requestThreadLocal=new ThreadLocal<HttpServletRequest>();
	public static void setRequest(HttpServletRequest request){
		requestThreadLocal.set(request);
	}
	public static HttpServletRequest getRequest(){
		return requestThreadLocal.get();
	}
	public static void clean(){
		requestThreadLocal.remove();
	}
}
