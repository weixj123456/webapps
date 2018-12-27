package org.format.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class XmlorJson {

	
	
	@RequestMapping("/xmlOrJson")
	@ResponseBody
	public Map<String, Object> xmlOrJson() {
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("list", employeeService.list());
	    return map;
	}
}
