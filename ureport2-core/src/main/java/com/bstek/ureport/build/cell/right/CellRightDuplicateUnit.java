package com.bstek.ureport.build.cell.right;

import java.util.List;

import com.bstek.ureport.build.Context;
import com.bstek.ureport.model.Cell;
import com.bstek.ureport.model.Column;

/**
 * @author Jacky.gao
 * @since 2016年11月7日
 */
public class CellRightDuplicateUnit {
	private Cell mainCell;
	private int mainCellColNumber;
	private Context context;
	private RightDuplicate rightDuplicate;
	private RightDuplocatorWrapper rightDuplocatorWrapper;
	public CellRightDuplicateUnit(Context context,RightDuplocatorWrapper rightDuplocatorWrapper,Cell mainCell,int mainCellColNumber,int colSize) {
		this.context=context;
		this.rightDuplocatorWrapper=rightDuplocatorWrapper;
		this.mainCell=mainCell;
		this.mainCellColNumber=mainCellColNumber;
		this.rightDuplicate=new RightDuplicate(mainCell,colSize,context);
	}
	public void duplicate(Cell cell,int index){
		rightDuplicate.setIndex(index);
		for(CellRightDuplicator childDuplicator:rightDuplocatorWrapper.getMainCellChildren()){
			Cell newCell=childDuplicator.duplicateChildrenCell(rightDuplicate,cell,mainCell,false);
			processChildrenCells(newCell,childDuplicator.getCell(),rightDuplicate,context,childDuplicator.isNonChild());
			childDuplicator.setNonChild(false);
		}
		for(CellRightDuplicator cellRightDuplicator:rightDuplocatorWrapper.getCellDuplicators()){
			cellRightDuplicator.duplicate(rightDuplicate,cell);
		}
		Column newCol=rightDuplicate.newColumn(cell.getColumn(),mainCellColNumber);
		cell.setColumn(newCol);
		newCol.getCells().add(cell);
		cell.getRow().getCells().add(cell);
		context.addReportCell(cell);
		rightDuplicate.reset();
	}
	
	public void complete(){
		rightDuplicate.complete();
	}
	
	private void processChildrenCells(Cell cell,Cell originalCell,RightDuplicate rightDuplicate,Context context,boolean parentNonChild){
		List<CellRightDuplicator> childCellRightDuplicators=rightDuplocatorWrapper.fetchChildrenDuplicator(originalCell);
		if(childCellRightDuplicators==null){
			return;
		}
		for(CellRightDuplicator duplicator:childCellRightDuplicators){				
			Cell newCell=duplicator.duplicateChildrenCell(rightDuplicate,cell,originalCell,parentNonChild);
			processChildrenCells(newCell,duplicator.getCell(),rightDuplicate,context,duplicator.isNonChild());
			duplicator.setNonChild(false);
		}
	}
}
