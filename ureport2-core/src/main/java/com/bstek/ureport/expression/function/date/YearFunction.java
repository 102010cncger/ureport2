package com.bstek.ureport.expression.function.date;

import java.util.Calendar;
import java.util.List;

import com.bstek.ureport.build.Context;
import com.bstek.ureport.expression.model.data.ExpressionData;
import com.bstek.ureport.model.Cell;

/**
 * @author Jacky.gao
 * @since 2017年1月22日
 */
public class YearFunction extends CalendarFunction {

	@Override
	public Object execute(List<ExpressionData<?>> dataList, Context context,Cell currentCell) {
		Calendar c = buildCalendar(dataList);
		int year=c.get(Calendar.YEAR);
		return year;
	}

	@Override
	public String name() {
		return "year";
	}
}
