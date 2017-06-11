/**
 * 
 */
package com.daniel.study.stringutil;

/**
 * @author fengyu
 *
 */
public class StringUtil {
	/**
	 * 将Unicode字符串转化为boolean数组
	 * 分三步：
	 *      1、把Unicode字符串转化为以空分隔的二进制字符串
	 *      2、把以空格分隔的二进制字符串转化为以空格分隔的并且补全为16位的二进制字符串
	 *      3、把16位为一组的以空格分隔的二进制字符串转化为bool数组
	 * @param str
	 *            Unicode字符串。
	 * @return
	 */
	public static boolean[] Str2BoolArray(String str)
	{
		boolean[]  result= binary16ToBoolArray(binaryStr2BinaryStr16(string2BinaryStr(str)));
		return result;
	}
	/**
	 * 将bool数组转化为Unicode字符串
	 * 分三步：
	 *      1、把bool数组转化为以空格分隔的、每组16位的二进制字符串
	 *      2、把以空格分隔的每组16位的二进制字符串转化为去掉每组的前缀0的并且以空格分隔的二进制字符串。
	 *      3、把以空格分隔的、且每组非0前缀的二进制字符串（<=16位）转化Unicode字符串
	 * @param input
	 *             bool数组
	 * @return
	 */
	public static String boolArray2Str(boolean[] input)
	{
		String result = binaryStr2Str(binaryStr16ToBinaryStr(boolArray2BinaryStr16(input)));
		return result;
	}
	/**
	 * 将字符串转换为二进制字符串，以空格分隔
	 * @param string
	 *              需要转化为二进制的字符串，在转化为二进制字符串前需要把字符串中的每一个字符取出来
	 *              以为字符编码（这里是以Unicode作为字符编码的）是以字符为单位的。
	 * @return
	 *              返回的是二进制字符串。每个字符对应的二进制字符串应该是16位，但舍去了高位的‘0’
	 */
	public static String string2BinaryStr(String string)
	{
		char[] strChars = string.toCharArray();
		String result = "";
		for(int i = 0; i < strChars.length; i++)
		{
			result += Integer.toBinaryString(strChars[i])+" ";
		}
		return result;
	}
	/**
	 * 将二进制字符串转化为全16位的带空格的二进制字符串
	 * @param binaryStr
	 * @return
	 */
	public static String binaryStr2BinaryStr16(String binaryStr)
	{
		StringBuffer result = new StringBuffer();
		String[] tempStr = str2StrArray(binaryStr);
		for(int i = 0; i < tempStr.length; i++)
		{
			for(int j = 16 - tempStr[i].length(); j > 0; j--)
			{
				result.append("0");
			}
			result.append(tempStr[i]+" ");
		}
		return result.toString();
	}
	
	/**
	 * 把全16位的以空格分隔的二进制字符串转换为boolean数组
	 * @param binaryStr16
	 * @return
	 */
	public static boolean[] binary16ToBoolArray(String binaryStr16)
	{
		String[] tempStrs = str2StrArray(binaryStr16);
		boolean[] result = new boolean[tempStrs.length];
		for(int i = 0,j=0; i < binaryStr16.length(); i++,j++)
		{
			if(binaryStr16.charAt(i) == '0')
			{
				result[j] = false;
			}else if(binaryStr16.charAt(i) == '1'){
				result[j] = true;
			}else {
				j--;
			}
		}
		return result;
	}
	/**
	 * 将二进制字符串转化为Unicode字符串
	 * @param binaryStr
	 * @return
	 */
	public static String binaryStr2Str(String binaryStr){
		String[] tempStrs = str2StrArray(binaryStr);
		char[] tempChars = new char[tempStrs.length];
		for(int i = 0; i < tempStrs.length; i++)
		{
			tempChars[i] = binaryStr2Char(tempStrs[i]);
		}
		return String.valueOf(tempChars);
	}
	/**
	 * 把二进制字符串转化为char
	 * @param binaryStr
	 * @return
	 */
	public static char binaryStr2Char(String binaryStr)
	{
		int[] temp = binaryStr2IntArray(binaryStr);
		int sum=0;
		for(int i = 0; i < temp.length; i++)
		{
			sum +=temp[temp.length-1-i]<<i;
		}
		return (char) sum;
	}
	/**
	 * 将bool数组转化为二进制字符串，每16位以空格分隔
	 * @param input
	 * @return
	 */
	public static String boolArray2BinaryStr16(boolean[] input)
	{
		StringBuffer result = new StringBuffer();
		for(int i = 0; i < input.length; i++)
		{
			if(input[i] == true){
				result.append("1");
			}
			else 
			{
				result.append("0");
			}
			if((i + 1) % 16 == 0)
			{
				result.append(" ");
			}
		}
		return result.toString();
	}
	/**
	 * 将按16位以空格分隔的二进制字符串转换为去掉0前缀的以空格分隔的字符串。
	 * @param binaryStr16
	 * @return
	 */
	public static String binaryStr16ToBinaryStr(String binaryStr16)
	{
		StringBuffer result = new StringBuffer();
		String[] tempStrs = str2StrArray(binaryStr16);
		for(int i = 0; i < tempStrs.length; i++)
		{
			for(int j = 0; j < 16; j++)
			{
				if(tempStrs[i].charAt(j) == '1')
				{
					result.append(tempStrs[i].substring(j)+' ');
					break;
				}
				if(j == 15 && tempStrs[i].charAt(j) == '0')
				{
					result.append("0"+" ");
				}
			}
		}
		return result.toString();
	}
	/**
	 * 将二进制字符串转换为int数组
	 * @param binaryStr
	 * @return
	 */
	private static int[] binaryStr2IntArray(String binaryStr)
	{
		char[] tempChars = binaryStr.toCharArray();
		int[] result = new int[tempChars.length];
		for(int i = 0 ; i < tempChars.length; i++)
		{
			result[i] = tempChars[i]-48;
		}
		return result;
	}
	/**
	 * 将带空格的字符串转化为字符串数组
	 * @param str
	 * @return
	 */
	private static String[] str2StrArray(String str)
	{
		String[] tempStrs = str.split(" ");
		return tempStrs;
	}
}
