package com.bstek.ureport;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * @author Jacky.gao
 * @since 2016年5月25日
 */
public class UReportPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	public UReportPropertyPlaceholderConfigurer() {
		setIgnoreUnresolvablePlaceholders(true);
		setOrder(100);
	}
}
