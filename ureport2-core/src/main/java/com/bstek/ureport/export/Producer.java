package com.bstek.ureport.export;

import java.io.OutputStream;

import com.bstek.ureport.model.Report;

/**
 * @author Jacky.gao
 * @since 2016年12月30日
 */
public interface Producer {
	void produce(Report report,OutputStream outputStream);
}
