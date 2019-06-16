
package com.kgc.utils;

import javax.servlet.http.HttpServletRequest;

public class UrlUtil {


	public static String getBaseUrl(HttpServletRequest request){
		String path = request.getContextPath();  
		return request.getScheme()+"://"+request.getServerName()+ ":" + request.getServerPort() +path+"/";
		
	}

}
