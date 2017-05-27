package com.bstek.ureport.console.cache;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bstek.ureport.cache.ReportCache;
import com.bstek.ureport.console.RequestHolder;
import com.bstek.ureport.model.Report;

/**
 * @author Jacky.gao
 * @since 2017年3月8日
 */
public class HttpSessionReportCache implements ReportCache {
	private final String KEY="__ureport_map";
	private final int MAX_ITEM=3;
	
	@Override
	public Report getReport(String file) {
		HttpServletRequest req=RequestHolder.getRequest();
		if(req==null){
			return null;
		}
		Map<String, Report> map = getReportMap(req);
		return map.get(file);
	}

	@Override
	public void storeReport(String file, Report report) {
		HttpServletRequest req=RequestHolder.getRequest();
		if(req==null){
			return;
		}
		Map<String, Report> map = getReportMap(req);
		if(map.containsKey(file)){
			map.remove(file);
		}else{
			if(map.size()>MAX_ITEM){
				String lastFile=null;
				for(Iterator<Entry<String,Report>> it=map.entrySet().iterator();it.hasNext();){
					Entry<String,Report> entry=it.next();
					lastFile=entry.getKey();
				}
				map.remove(lastFile);
			}
		}
		map.put(file, report);
	}
	

	@SuppressWarnings("unchecked")
	private Map<String, Report> getReportMap(HttpServletRequest req) {
		HttpSession session=req.getSession();
		Map<String,Report> map=(Map<String,Report>)session.getAttribute(KEY);
		if(map==null){
			map=new LinkedHashMap<String,Report>();
			session.setAttribute(KEY, map);
		}
		return map;
	}
}
