package com.bstek.ureport.definition.datasource;

import java.util.List;

import com.bstek.ureport.definition.dataset.DatasetDefinition;

/**
 * @author Jacky.gao
 * @since 2016年12月27日
 */
public interface DatasourceDefinition {
	String getName();
	List<DatasetDefinition> getDatasets();
	DatasourceType getType();
}
