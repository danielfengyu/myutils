/**
 * @author    fengyu
 * @filename  2017年6月18日-ClassUtil.java
 * @time      下午10:19:04
 * @classname ClassUtil
 */
package com.daniel.study.stringutil;

/**
 * @author fengyu
 * @time 2017年6月18日::下午10:19:04
 *
 */
public class ClassUtil
{
	/**
	 * 获取类所在的包名称
	 * 
	 * @author fengyu
	 * @time 2017年6月18日::下午10:27:01
	 * @return String
	 * @param clazz
	 * @return
	 */
	public static String classPackageName(Class<?> clazz)
	{
		int index = clazz.getName().lastIndexOf( '.' );
		return clazz.getName().substring( 0, index + 1 );
	}

	/**
	 * 获取类在项目中的路径
	 * 
	 * @author fengyu
	 * @time 2017年6月18日::下午10:27:26
	 * @return String
	 * @param clazz
	 * @return
	 */
	public static String classPath(Class<?> clazz)
	{
		int index = clazz.getName().lastIndexOf( '.' );
		return clazz.getName().substring( 0, index + 1 ).replace( ".", "/" );
	}

	/**
	 * 获取类的名称，非全限定名
	 * 
	 * @author fengyu
	 * @time 2017年6月18日::下午10:27:52
	 * @return String
	 * @param clazz
	 * @return
	 */
	public static String className(Class<?> clazz)
	{
		int index = clazz.getName().lastIndexOf( '.' );
		return clazz.getName().substring( index + 1 );
	}
	
	public static String format(){
		return null;
	}
}
