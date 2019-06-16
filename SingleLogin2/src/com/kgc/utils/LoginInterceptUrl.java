/**
 * 
 */
package com.kgc.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

public class LoginInterceptUrl {

	
	private final static Set<String> url = new HashSet<String>(); 
	
	static {
		url.add("/success.jsp");
		
	}
	
	public static boolean isLoginIntercept(HttpServletRequest request) {
		
		String servletPath = request.getServletPath();

		System.out.println("servletPath:"+servletPath);
		for(String loginUrl : url) {
			if(StringUtil.isEqual(loginUrl, servletPath)) {
				return true;
			}
		}
		
		return false;
	}
	
}
