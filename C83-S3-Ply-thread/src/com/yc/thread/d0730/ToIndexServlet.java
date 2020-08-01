package com.yc.thread.d0730;

import java.io.IOException;

import com.yc.thread.d0729.HttpServlet;
import com.yc.thread.d0729.HttpServletRequest;
import com.yc.thread.d0729.HttpServletResponse;

public class ToIndexServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("/photo/index.html");
	}

}
