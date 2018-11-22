package com.mk.util;

public class StringUtils
{
	public static boolean isEmpty(String str)
	{
		if( null==str || "".equals(str) )
			return true;
		return false;
	}
}
