package com.bstek.ureport.definition;
/**
 * @author Jacky.gao
 * @since 2014年4月29日
 */
public class Paper {
	private int leftMargin=90;
	private int rightMargin=90;
	private int topMargin=72;
	private int bottomMargin=72;
	private PaperType paperType;
	private PagingMode pagingMode;
	private int fixRows;
	private int width;
	private int height;
	private Orientation orientation;
	
	private boolean columnEnabled;
	private int columnCount=2;
	private int columnMargin=5;
	
	public int getLeftMargin() {
		return leftMargin;
	}

	public void setLeftMargin(int leftMargin) {
		this.leftMargin = leftMargin;
	}

	public int getRightMargin() {
		return rightMargin;
	}

	public void setRightMargin(int rightMargin) {
		this.rightMargin = rightMargin;
	}

	public int getTopMargin() {
		return topMargin;
	}

	public void setTopMargin(int topMargin) {
		this.topMargin = topMargin;
	}

	public int getBottomMargin() {
		return bottomMargin;
	}

	public void setBottomMargin(int bottomMargin) {
		this.bottomMargin = bottomMargin;
	}
	
	public PaperType getPaperType() {
		return paperType;
	}
	public void setPaperType(PaperType paperType) {
		this.paperType = paperType;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public PagingMode getPagingMode() {
		return pagingMode;
	}
	public void setPagingMode(PagingMode pagingMode) {
		this.pagingMode = pagingMode;
	}
	public int getFixRows() {
		return fixRows;
	}
	public void setFixRows(int fixRows) {
		this.fixRows = fixRows;
	}

	public boolean isColumnEnabled() {
		return columnEnabled;
	}

	public void setColumnEnabled(boolean columnEnabled) {
		this.columnEnabled = columnEnabled;
	}

	public int getColumnCount() {
		return columnCount;
	}

	public void setColumnCount(int columnCount) {
		this.columnCount = columnCount;
	}

	public int getColumnMargin() {
		return columnMargin;
	}

	public void setColumnMargin(int columnMargin) {
		this.columnMargin = columnMargin;
	}
}
