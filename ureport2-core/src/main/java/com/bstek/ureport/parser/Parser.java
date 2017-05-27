package com.bstek.ureport.parser;

import org.dom4j.Element;

/**
 * @author Jacky.gao
 * @since 2016年12月2日
 */
public interface Parser<T>{
	T parse(Element element);
}
