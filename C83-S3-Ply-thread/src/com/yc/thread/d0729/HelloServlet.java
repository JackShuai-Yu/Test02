package com.yc.thread.d0729;

import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		PrintWriter out = response.getWriter();
		System.out.println("hello world");
		
	}
}
