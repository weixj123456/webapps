package org.com.tools.common;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Arrarymethod {
	
	//检查数组是否包含某个值的方法   使用List
	public static boolean containStr(String[] arr, String targetValue) {
	    return Arrays.asList(arr).contains(targetValue);
      }
	//使用Set
	public static boolean useSet(String[] arr, String targetValue) {
	    Set<String> set = new HashSet<String>(Arrays.asList(arr));
	    return set.contains(targetValue);
	}
      
	//使用循环判断
	public static boolean useLoop(String[] arr, String targetValue) {
	    for(String s: arr){
	        if(s.equals(targetValue))
	            return true;
	    }
	    return false;
	}
	
}