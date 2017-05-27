
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
public class MonthFunction extends CalendarFunction {

	@Override
	public Object execute(List<ExpressionData<?>> dataList, Context context,Cell currentCell) {
		Calendar c = buildCalendar(dataList);
		int month=c.get(Calendar.MONTH)+1;
		return month+1;
	}

	@Override
	public String name() {
		return "month";
	}
}
