package com.bstek.ureport.definition;

/**
 * @author Jacky.gao
 * @since 2017年2月26日
 */
public class BlankCellInfo {
	private int offset;
	private int span;
	private boolean parent;
	public BlankCellInfo() {
	}
	public BlankCellInfo(int offset, int span,boolean parent) {
		this.offset=offset;
		this.span = span;
		this.parent=parent;
	}
	public int getOffset() {
		return offset;
	}

	public int getSpan() {
		return span;
	}
	public boolean isParent() {
		return parent;
	}
}
