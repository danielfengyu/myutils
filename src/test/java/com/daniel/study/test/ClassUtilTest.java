/**
 * @author    fengyu
 * @filename  2017年8月26日-ClassUtilTest.java
 * @time      下午11:11:05
 * @classname ClassUtilTest
 */
package com.daniel.study.test;

import org.junit.Assert;
import org.junit.Test;

import com.daniel.study.stringutil.ClassUtil;

/**
 * @author fengyu
 * @time 2017年8月26日::下午11:11:05
 *
 */
public class ClassUtilTest
{

	@Test
	public void testClassPackageName()
	{
		String result = ClassUtil.classPackageName( Object.class );
		Assert.assertEquals( "java.lang.", result );
	}

	@Test
	public void testClassPath()
	{
		String result = ClassUtil.classPath( Object.class );
		Assert.assertEquals( "java/lang/", result );
	}

	@Test
	public void testClassName()
	{
		String result = ClassUtil.className( Object.class );
		Assert.assertEquals( "Object", result );
	}

}
