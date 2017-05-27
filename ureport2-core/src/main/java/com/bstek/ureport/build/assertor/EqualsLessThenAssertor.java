package com.bstek.ureport.build.assertor;

import java.math.BigDecimal;

import com.bstek.ureport.Utils;

/**
 * @author Jacky.gao
 * @since 2017年1月12日
 */
public class EqualsLessThenAssertor implements Assertor {

	@Override
	public boolean eval(Object left, Object right) {
		if(left==null || right==null){
			return false;
		}
		BigDecimal leftObj=Utils.toBigDecimal(left);
		BigDecimal rightObj=Utils.toBigDecimal(right);
		return leftObj.compareTo(rightObj) < 1;
	}
}
