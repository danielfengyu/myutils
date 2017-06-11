/**
 * 
 */
package com.daniel.study.test;

import org.junit.Test;

import com.daniel.study.stringutil.StringUtil;

/**
 * @author fengyu
 *
 */
public class StringTest {

	@Test
	public void test() {
		System.out.println(StringUtil.string2BinaryStr("冯玉"));
	}
	@Test
	public void strToBinaryStr()
	{
		System.out.println(StringUtil.string2BinaryStr("我爱你！"));
		System.out.println(StringUtil.binaryStr2Str(StringUtil.string2BinaryStr("我爱你！")));
	}
}
