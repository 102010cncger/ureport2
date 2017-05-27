package com.bstek.ureport.expression.model.expr;

import java.util.ArrayList;
import java.util.List;

import com.bstek.ureport.build.Context;
import com.bstek.ureport.expression.model.Operator;
import com.bstek.ureport.expression.model.data.ExpressionData;
import com.bstek.ureport.expression.model.data.ObjectExpressionData;
import com.bstek.ureport.expression.model.data.ObjectListExpressionData;
import com.bstek.ureport.model.Cell;
import com.bstek.ureport.utils.ElUtils;

/**
 * @author Jacky.gao
 * @since 2017年1月15日
 */
public class JoinExpression extends BaseExpression {
	private List<Operator> operators;
	private List<BaseExpression> expressions;
	
	public JoinExpression(List<Operator> operators, List<BaseExpression> expressions) {
		this.operators = operators;
		this.expressions = expressions;
	}
	@Override
	protected ExpressionData<?> compute(Cell cell,Cell currentCell,Context context) {
		if(expressions.size()==1){
			return expressions.get(0).compute(cell, currentCell,context);
		}
		List<Object> list=new ArrayList<Object>();
		for(int i=0;i<expressions.size();i++){
			BaseExpression expression=expressions.get(i);
			ExpressionData<?> data=expression.execute(cell, currentCell,context);
			Object obj=null;
			if(data instanceof ObjectExpressionData){
				ObjectExpressionData d=(ObjectExpressionData)data;
				obj=d.getData();
			}else if(data instanceof ObjectListExpressionData){
				ObjectListExpressionData d=(ObjectListExpressionData)data;
				obj=d.getData();
			}
			if(obj==null){
				obj="";
			}
			list.add(obj);
		}
		String str=null;
		for(int i=0;i<list.size();i++){
			Object data=list.get(i);
			if(str==null){
				if(data instanceof String){
					str="\""+data+"\"";
					//str=""+data+"";
				}else{
					str=""+data+"";					
				}
			}else{
				Operator op=operators.get(i-1);
				if(data instanceof String){
					str+=""+op+"\""+data+"\"";
					//str+=""+op+""+data+"";
				}else{
					str+=""+op+""+data+"";					
				}
			}
		}
		Object obj=ElUtils.eval(str);
		return new ObjectExpressionData(obj);
	}
	public List<BaseExpression> getExpressions() {
		return expressions;
	}
}
