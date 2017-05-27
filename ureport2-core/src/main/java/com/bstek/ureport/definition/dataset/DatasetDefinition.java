package com.bstek.ureport.definition.dataset;

import java.util.List;


/**
 * @author Jacky.gao
 * @since 2016年12月27日
 */
public interface DatasetDefinition {
	String getName();
	List<Field> getFields();
}
