package com.bstek.ureport.expression.function.date;

import java.util.Calendar;
import java.util.List;

import com.bstek.ureport.build.Context;
import com.bstek.ureport.exception.ReportComputeException;
import com.bstek.ureport.expression.model.data.ExpressionData;
import com.bstek.ureport.model.Cell;

/**
 * @author Jacky.gao
 * @since 2017年1月22日
 */
public class WeekFunction extends CalendarFunction {

	@Override
	public Object execute(List<ExpressionData<?>> dataList, Context context,Cell currentCell) {
		Calendar c = buildCalendar(dataList);
		int weekDay=c.get(Calendar.DAY_OF_WEEK);
		boolean isFirstSunday = (c.getFirstDayOfWeek() == Calendar.SUNDAY);
		if(isFirstSunday){
			weekDay = weekDay - 1;
			if(weekDay == 0){
				weekDay = 7;
			}
		}
		switch(weekDay){
		case 1:
			return "星期一";
		case 2:
			return "星期二";
		case 3:
			return "星期三";
		case 4:
			return "星期四";
		case 5:
			return "星期五";
		case 6:
			return "星期六";
		case 7:
			return "星期日";
		}
		throw new ReportComputeException("Unknow week day :"+weekDay);
	}

	@Override
	public String name() {
		return "week";
	}
}
