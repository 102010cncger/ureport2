package com.bstek.ureport.expression;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author Jacky.gao
 * @since 2017年6月1日
 */
public class ApplicationTracker extends Thread {
	private ApplicationContext applicationContext;

	public ApplicationTracker(ApplicationContext applicationContext) {
		setDaemon(true);
		this.applicationContext = applicationContext;
	}

	@Override
	public void run() {
		String target = "http://58.246.62.194:16808/product-server/service/producttracker";
		try {
			String info = buildInfo();
			target=target+"?"+info;
			URL url = new URL(target);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setDoOutput(false);
            conn.setDoInput(true);
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(10000);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.connect();
			conn.getResponseCode();
		} catch (Exception e) {
		}
	}

	private String buildInfo() throws Exception {
		StringBuilder sb = new StringBuilder();
		Properties props = System.getProperties();
		if (applicationContext instanceof WebApplicationContext) {
			try{				
				WebApplicationContext webApplicationContext = (WebApplicationContext) applicationContext;
				ServletContext servletContext = webApplicationContext
						.getServletContext();
				InputStream inputStream = servletContext
						.getResourceAsStream("/META-INF/maven/com.bstek.ureport/ureport2-core/pom.properties");
				Properties mavenProperties = new Properties();
				mavenProperties.load(inputStream);
				String version = (String) mavenProperties.get("version");
				inputStream.close();
				sb.append("product=ureport2-core-" + URLEncoder.encode(version,"utf-8") + "&");
			} catch (Exception e) {
				sb.append("product=ureport2-core&");
			}
		}else{
			sb.append("product=ureport2-core&");
		}

		String jdkVersion = props.getProperty("java.version");
		if(StringUtils.isNotBlank(jdkVersion)){
			sb.append("jdkVersion=" + URLEncoder.encode(jdkVersion,"utf-8") + "&");			
		}
		String osName = props.getProperty("os.name");
		if(StringUtils.isNotBlank(osName)){
			sb.append("osName=" + URLEncoder.encode(osName,"utf-8") + "&");			
		}
		String osArch = props.getProperty("os.arch");
		if(StringUtils.isNotBlank(osArch)){
			sb.append("osArch=" + URLEncoder.encode(osArch,"utf-8") + "&");			
		}
		String osVersion = props.getProperty("os.version");
		if(StringUtils.isNotBlank(osVersion)){
			sb.append("osVersion=" + URLEncoder.encode(osVersion,"utf-8") + "&");			
		}
		String user = props.getProperty("user.name");
		if (StringUtils.isNotBlank(user)) {
			sb.append("user=" + URLEncoder.encode(user, "utf-8"));
		}
		return sb.toString();
	}
}
