package com.tongbanjie.baymax.support;

/**
 * 自定义函数的抽象
 * @author dawei
 *
 */
public interface Function<I,O> {
	
	/**
	 * 执行自定义函数
	 * @param
	 * @return
	 */
    O apply(I input);
	
	/**
	 * 获取自定义函数在EL表达式中被使用的关键字
	 * @return
	 */
	String getFunctionName();
	
}
