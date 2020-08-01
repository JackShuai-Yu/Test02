package com.yc.thread.d0729;

import java.util.HashMap;
import java.util.Map;

public class HttpServletRequest {
	private String method;
	private String requestUri;
	private String protocol;
	
	private Map<String, String> headerMap = new HashMap<>();
	HttpServletRequest(String requestText) {
		String[] lines = requestText.split("\\n");
		String[] items = lines[0].split("\\s");
		method = items[0];
		requestUri = items[1];
		protocol = items[2];
		for(int i=1;i<lines.length;i++) {
			lines[i] = lines[i].trim();
			if(lines[i].isEmpty()) {
				break;
			}
			items = lines[i].split(":");
			headerMap.put(items[0], items[1].trim());
		}
	}
	
	
}
