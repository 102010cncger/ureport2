package com.bstek.ureport.expression.model.expr;

import java.util.ArrayList;
import java.util.List;

import com.bstek.ureport.Utils;
import com.bstek.ureport.build.Context;
import com.bstek.ureport.exception.ReportComputeException;
import com.bstek.ureport.expression.model.data.ExpressionData;
import com.bstek.ureport.expression.model.data.ObjectExpressionData;
import com.bstek.ureport.expression.model.data.ObjectListExpressionData;
import com.bstek.ureport.expression.model.expr.set.CellExpression;
import com.bstek.ureport.model.Cell;

/**
 * @author Jacky.gao
 * @since 2017年1月21日
 */
public class RelativeCellExpression extends CellExpression {
	public RelativeCellExpression(String cellName) {
		super(cellName);
	}
	@Override
	public boolean supportPaging(){
		return false;
	}
	@Override
	protected ExpressionData<?> compute(Cell cell,Cell currentCell, Context context) {
		List<Cell> targetCells=Utils.fetchTargetCells(currentCell, context, cellName);
		int size=targetCells.size();
		if(size==0){
			throw new ReportComputeException("Unknow cell "+cellName);
		}else if(size==1){
			return new ObjectExpressionData(targetCells.get(0).getData());
		}else{
			Cell targetCell=null;
			for(Cell c:targetCells){
				if(c.getRow()==currentCell.getRow() || c.getColumn()==currentCell.getColumn()){
					targetCell=c;
					break;
				}
			}
			if(targetCell!=null){
				return new ObjectExpressionData(targetCell.getData());
			}else{
				List<Object> list=new ArrayList<Object>();
				for(Cell c:targetCells){
					list.add(c.getData()); 
				}
				return new ObjectListExpressionData(list);							
			}
		}
	}
}
