package com.bstek.ureport.expression.model.expr.dataset;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.bstek.ureport.build.BindData;
import com.bstek.ureport.build.Context;
import com.bstek.ureport.build.DatasetUtils;
import com.bstek.ureport.definition.Order;
import com.bstek.ureport.definition.value.AggregateType;
import com.bstek.ureport.definition.value.GroupItem;
import com.bstek.ureport.expression.model.Condition;
import com.bstek.ureport.expression.model.data.BindDataListExpressionData;
import com.bstek.ureport.expression.model.data.ExpressionData;
import com.bstek.ureport.expression.model.expr.BaseExpression;
import com.bstek.ureport.model.Cell;
import com.bstek.ureport.parser.impl.value.MappingItem;

/**
 * @author Jacky.gao
 * @since 2016年11月18日
 */
public class DatasetExpression extends BaseExpression {
	private String datasetName;
	private AggregateType aggregate;
	private String property;
	/**
	 * 当aggregate类型为自定义分组时，采用此属性来存储自定义分组各个项目
	 */
	private List<GroupItem> groupItems;
	
	private List<MappingItem> mappingItems;
	
	@JsonIgnore 
	private Condition condition;
	
	@JsonIgnore 
	private Map<String,String> mapping=null;
	
	/**
	 * 此属性给设计器使用，引擎不使用该属性
	 */
	private List<Condition> conditions;
	private Order order;
	
	@Override
	public ExpressionData<?> compute(Cell cell,Cell currentCell,Context context) {
		List<BindData> bindDataList=DatasetUtils.computeDatasetExpression(this, cell, context);
		return new BindDataListExpressionData(bindDataList);
	}
	
	public String getDatasetName() {
		return datasetName;
	}

	public void setDatasetName(String datasetName) {
		this.datasetName = datasetName;
	}

	public AggregateType getAggregate() {
		return aggregate;
	}

	public void setAggregate(AggregateType aggregate) {
		this.aggregate = aggregate;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public List<GroupItem> getGroupItems() {
		return groupItems;
	}

	public void setGroupItems(List<GroupItem> groupItems) {
		this.groupItems = groupItems;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public List<Condition> getConditions() {
		return conditions;
	}

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<MappingItem> getMappingItems() {
		return mappingItems;
	}

	public void setMappingItems(List<MappingItem> mappingItems) {
		this.mappingItems = mappingItems;
		if(mappingItems!=null && mappingItems.size()>0){
			mapping=new HashMap<String,String>();
			for(MappingItem item:mappingItems){
				mapping.put(item.getValue(),item.getLabel());
			}
		}
	}
	public Map<String, String> getMapping() {
		return mapping;
	}
}
