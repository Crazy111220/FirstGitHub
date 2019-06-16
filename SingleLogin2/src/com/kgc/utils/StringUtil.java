package com.kgc.utils;


public class StringUtil {


	public static boolean isEqual(String str,String str2) {
		if(str == null ||str2 == null) {
			return false;
		}
		
		return str.equals(str2);
	}
	
	
	public static boolean isEmpty(String str) {
		if(str == null) {
			return true;
		}
		
		if(str.trim().equals("")) {
			return true;
		}
		
		return false;
	}
}
