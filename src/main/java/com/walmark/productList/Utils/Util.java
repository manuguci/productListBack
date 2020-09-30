package com.walmark.productList.Utils;

public class Util {
	
	
	
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	    	Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public static boolean isPalindrome(String s) {
		  int n = s.length();
		  for (int i = 0; i < (n/2); ++i) {
		     if (s.charAt(i) != s.charAt(n - i - 1)) {
		         return false;
		     }
		  }

		  return true;
		}
}
