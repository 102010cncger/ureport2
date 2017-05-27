package com.bstek.ureport.console;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Jacky.gao
 * @since 2017年1月25日
 */
public interface ServletAction {
	public static final String PREVIEW_KEY="p";
	void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
	String url();
}
