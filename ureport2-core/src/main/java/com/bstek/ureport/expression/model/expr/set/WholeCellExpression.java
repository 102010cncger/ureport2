package com.bstek.ureport.expression.model.expr.set;

import java.util.ArrayList;
import java.util.List;

import com.bstek.ureport.build.Context;
import com.bstek.ureport.expression.model.Condition;
import com.bstek.ureport.expression.model.data.ExpressionData;
import com.bstek.ureport.expression.model.data.ObjectExpressionData;
import com.bstek.ureport.expression.model.data.ObjectListExpressionData;
import com.bstek.ureport.model.Cell;

/**
 * @author Jacky.gao
 * @since 2017年4月6日
 */
public class WholeCellExpression extends CellExpression{
	private Condition condition;
	public WholeCellExpression(String cellName) {
		super(cellName);
	}
	@Override
	public boolean supportPaging(){
		return false;
	}
	@Override
	protected ExpressionData<?> compute(Cell cell, Cell currentCell,Context context) {
		while(!context.isCellPocessed(cellName)){
			context.getReportBuilder().buildCell(context, null);
		}
		List<Cell> cells=context.getReport().getCellsMap().get(cellName);
		List<Object> list=new ArrayList<Object>();
		for(Cell c:cells){
			Object obj=c.getData();
			if(condition!=null){
				boolean result=condition.filter(cell, currentCell, obj, context);
				if(!result){
					continue;
				}
			}
			list.add(obj);
		}
		if(list.size()==1){
			return new ObjectExpressionData(list.get(0));
		}else{
			return new ObjectListExpressionData(list);
		}
	}
	public void setCondition(Condition condition) {
		this.condition = condition;
	}
}
