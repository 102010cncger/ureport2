package com.bstek.ureport.definition.dataset;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.bstek.ureport.build.Dataset;
import com.bstek.ureport.definition.datasource.DataType;


/**
 * @author Jacky.gao
 * @since 2016年12月27日
 */
public class SqlDatasetDefinition implements DatasetDefinition {
	private String name;
	private String sql;
	private List<Parameter> parameters;
	private List<Field> fields;
	
	public Dataset buildDataset(Map<String,Object> parameterMap,Connection conn){
		Map<String, Object> pmap = buildParameters(parameterMap);
		SingleConnectionDataSource datasource=new SingleConnectionDataSource(conn,false);
		NamedParameterJdbcTemplate jdbcTemplate=new NamedParameterJdbcTemplate(datasource);
		List<Map<String,Object>> list= jdbcTemplate.queryForList(sql, pmap);
		return new Dataset(name,list);
	}
	
	private Map<String,Object> buildParameters(Map<String,Object> params){
		Map<String,Object> map=new HashMap<String,Object>();
		for(Parameter param:parameters){
			String name=param.getName();
			DataType datatype=param.getType();
			Object value=param.getDefaultValue();
			if(params!=null && params.containsKey(name)){
				value=params.get(name);
			}
			map.put(name, datatype.parse(value));
		}
		return map;
	}
	
	@Override
	public List<Field> getFields() {
		return fields;
	}
	
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
	
	public List<Parameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}
	public String getSql() {
		return sql;
	}
}
