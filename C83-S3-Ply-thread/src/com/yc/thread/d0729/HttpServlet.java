package com.yc.thread.d0729;

import java.io.IOException;

public class HttpServlet {
	public void service(HttpServletRequest requset,HttpServletResponse response) 
		throws IOException{
		if("GET".equals(request.getMethod())) {
			doGet(request,response);
		}else if("POST".equals(request.getMethod())){
			doPost(request,response);
		}else if("PUT".equals(request.getMethod())) {
			
		}else if("DELETE".equals(request.getMethod())) {
			doDelete(request,response);
		}else {
			
		}
		response.setStatus(200, ok);
		response.flushBuffer();
	}
	
	public void doGet(HttpServletRequest requset,HttpServletResponse response) {
		
	}
	public void doPut(HttpServletRequest requset,HttpServletResponse response) {
		
	}
	public void doPost(HttpServletRequest requset,HttpServletResponse response) {
		
	}
	public void doDelete(HttpServletRequest requset,HttpServletResponse response) {
		
	}


}
