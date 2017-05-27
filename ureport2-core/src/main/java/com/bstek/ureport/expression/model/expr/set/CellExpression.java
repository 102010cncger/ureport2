package com.bstek.ureport.expression.model.expr.set;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bstek.ureport.Utils;
import com.bstek.ureport.build.Context;
import com.bstek.ureport.expression.model.data.ExpressionData;
import com.bstek.ureport.expression.model.data.NoneExpressionData;
import com.bstek.ureport.expression.model.data.ObjectExpressionData;
import com.bstek.ureport.expression.model.data.ObjectListExpressionData;
import com.bstek.ureport.expression.model.expr.BaseExpression;
import com.bstek.ureport.model.Cell;
import com.bstek.ureport.model.Column;
import com.bstek.ureport.model.Row;

/**
 * @author Jacky.gao
 * @since 2017年1月1日
 */
public class CellExpression extends BaseExpression {
	protected String cellName;
	public CellExpression(String cellName) {
		this.cellName=cellName;
	}
	public boolean supportPaging(){
		return true;
	}
	@Override
	protected ExpressionData<?> compute(Cell cell,Cell currentCell,Context context) {
		List<Cell> targetCells=Utils.fetchTargetCells(cell, context, cellName);
		if(targetCells.size()>1){
			List<Object> list=new ArrayList<Object>();
			for(Cell targetCell:targetCells){
				list.add(targetCell.getData()); 
			}
			return new ObjectListExpressionData(list);			
		}else if(targetCells.size()==1){
			return new ObjectExpressionData(targetCells.get(0).getData());
		}else{
			return new NoneExpressionData();
		}
	}
	
	public ExpressionData<?> computePageCells(Cell cell,Cell currentCell,Context context) {
		List<Row> pageRows=context.getCurrentPageRows();
		List<Object> list=new ArrayList<Object>();
		Map<Row, Map<Column, Cell>> cellMap=context.getReport().getRowColCellMap();
		List<Column> columns=context.getReport().getColumns();
		for(Row row:pageRows){
			Map<Column, Cell> map=cellMap.get(row);
			if(map==null){
				continue;
			}
			for(Column col:columns){
				Cell targetCell=map.get(col);
				if(targetCell==null || !targetCell.getName().equals(cellName)){
					continue;
				}
				list.add(targetCell.getData());
			}
		}
		return new ObjectListExpressionData(list);
	}
	
	protected List<Cell> fetchPageCells(Cell cell,Cell currentCell,Context context){
		List<Row> pageRows=context.getCurrentPageRows();
		Map<Row, Map<Column, Cell>> cellMap=context.getReport().getRowColCellMap();
		List<Column> columns=context.getReport().getColumns();
		List<Cell> list=new ArrayList<Cell>();
		for(Row row:pageRows){
			Map<Column, Cell> map=cellMap.get(row);
			if(map==null){
				continue;
			}
			for(Column col:columns){
				Cell targetCell=map.get(col);
				if(targetCell==null || !targetCell.getName().equals(cellName)){
					continue;
				}
				list.add(targetCell);
			}
		}
		return list;
	}
}
