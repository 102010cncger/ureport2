package com.bstek.ureport.build.assertor;


/**
 * @author Jacky.gao
 * @since 2017年1月12日
 */
public class NotEqualsAssertor implements Assertor {

	@Override
	public boolean eval(Object left, Object right) {
		if(left == null && right==null){
			return false;
		}
		if(left==null || right==null){
			return true;
		}
		return !left.equals(right);
	}
}
