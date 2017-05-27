package com.bstek.ureport.expression.function.date;

import java.util.Calendar;
import java.util.List;

import com.bstek.ureport.build.Context;
import com.bstek.ureport.expression.model.data.ExpressionData;
import com.bstek.ureport.model.Cell;

/**
 * @author Jacky.gao
 * @since 2017年1月21日
 */
public class DayFunction extends CalendarFunction {
	@Override
	public Object execute(List<ExpressionData<?>> dataList, Context context,Cell currentCell) {
		Calendar c = buildCalendar(dataList);
		int day=c.get(Calendar.DAY_OF_MONTH);
		return day;
	}
	
	@Override
	public String name() {
		return "day";
	}
}
