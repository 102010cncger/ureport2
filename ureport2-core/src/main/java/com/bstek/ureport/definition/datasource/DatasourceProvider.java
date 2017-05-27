package com.bstek.ureport.definition.datasource;

import java.sql.Connection;

/**
 * @author Jacky.gao
 * @since 2016年12月27日
 */
public interface DatasourceProvider {
	Connection getConnection();
	String getName();
}
