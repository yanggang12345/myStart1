package com.bdqn.util;

import java.util.Arrays;

public class Utils {
	public static String join(String[] arr,String spliter){
		StringBuilder sb=new StringBuilder();
		if(arr==null){
			return null;
		}
		if(arr.length==0) return "";
		if(spliter==null) return Arrays.toString(arr);
		for (String str : arr) {
			sb.append(str).append(spliter);
		}
		sb.delete(sb.length()-spliter.length(), sb.length());
		return sb.toString();
	}
}
