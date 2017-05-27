package com.bstek.ureport;

/**
 * @author Jacky.gao
 * @since 2017年2月24日
 */
public class Range {
	private int start=-1;
	private int end;
	public Range() {
	}
	public Range(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public void setEnd(int end) {
		this.end = end;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getStart() {
		return start;
	}
	public int getEnd() {
		return end;
	}
}
