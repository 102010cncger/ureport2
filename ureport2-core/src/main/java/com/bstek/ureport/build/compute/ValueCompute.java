package com.bstek.ureport.build.compute;

import java.util.List;

import com.bstek.ureport.build.BindData;
import com.bstek.ureport.build.Context;
import com.bstek.ureport.definition.value.ValueType;
import com.bstek.ureport.model.Cell;

/**
 * @author Jacky.gao
 * @since 2016年12月21日
 */
public interface ValueCompute {
	List<BindData> compute(Cell cell,Context context);
	ValueType type();
}
