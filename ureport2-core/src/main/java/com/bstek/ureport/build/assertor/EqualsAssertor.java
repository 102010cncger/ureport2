package com.bstek.ureport.build.assertor;


/**
 * @author Jacky.gao
 * @since 2017年1月12日
 */
public class EqualsAssertor implements Assertor {
	
	@Override
	public boolean eval(Object left, Object right) {
		if(left == null && right==null){
			return true;
		}
		if(left==null || right==null){
			return false;
		}
		if(left instanceof Number && right instanceof Number){
			Number l=(Number)left;
			Number r=(Number)right;
			return l.doubleValue()==r.doubleValue();
		}
		return left.equals(right);
	}
}
