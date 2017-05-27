package com.bstek.ureport.console;

import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.bstek.ureport.exception.ReportComputeException;


/**
 * @author Jacky.gao
 * @since 2016年6月3日
 */
public abstract class BaseServletAction implements ServletAction {
	
	protected String decode(String value){
		try{
			value=URLDecoder.decode(value, "utf-8");
			value=URLDecoder.decode(value, "utf-8");
			return value;
		}catch(Exception ex){
			throw new ReportComputeException(ex);
		}
	}
	
	@SuppressWarnings("unchecked")
	protected Map<String, Object> buildParameters(HttpServletRequest req) {
		Map<String,Object> parameters=new HashMap<String,Object>();
		Enumeration<String> names=req.getParameterNames();
		while(names.hasMoreElements()){
			String name=names.nextElement();
			String value=req.getParameter(name);
			if(StringUtils.isNotBlank(value)){
				parameters.put(name, value);				
			}
		}
		names=req.getAttributeNames();
		while(names.hasMoreElements()){
			String name=names.nextElement();
			Object value=req.getAttribute(name);
			if(value!=null){
				parameters.put(name, value);				
			}
		}
		return parameters;
	}
	
	protected void invokeMethod(String methodName,HttpServletRequest req,HttpServletResponse resp) throws ServletException{
		try{
			Method method=this.getClass().getMethod(methodName, new Class<?>[]{HttpServletRequest.class,HttpServletResponse.class});			
			method.invoke(this, new Object[]{req,resp});
		}catch(Exception ex){
			throw new ServletException(ex);
		}
	}
	
	protected String retriveMethod(HttpServletRequest req) throws ServletException{
		String path=req.getContextPath()+UReportServlet.URL;
		String uri=req.getRequestURI();
		String targetUrl=uri.substring(path.length());
		int slashPos=targetUrl.indexOf("/",1);
		if(slashPos>-1){
			String methodName=targetUrl.substring(slashPos+1).trim();
			return methodName.length()>0 ? methodName : null;
		}
		return null;
	}
}
