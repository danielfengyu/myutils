/**
 * @author    fengyu
 * @filename  2017年8月26日-StringUtilTest.java
 * @time      下午11:02:01
 * @classname StringUtilTest
 */
package com.daniel.study.test;



import org.junit.Assert;
import org.junit.Test;

import com.daniel.study.stringutil.StringUtil;

/**
 * @author fengyu
 * @time 2017年8月26日::下午11:02:01
 *
 */
public class StringUtilTest
{

	@Test
	public void testConnectStrs()
	{
		String result = StringUtil.connectStrs( "fengyu", "is", "a", " ", "good", "student" );
		Assert.assertEquals( "fengyuisa goodstudent", result );
	}

}
