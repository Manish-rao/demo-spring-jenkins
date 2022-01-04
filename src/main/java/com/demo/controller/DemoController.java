package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.DemoService;
import com.demo.util.TestUtil;

@RestController
@RequestMapping("/api")
public class DemoController {
	
	private TestUtil testUtil = new TestUtil();
	
	@GetMapping("/demo")
	public String getDemo() {
		return testUtil.test();
	}
	
	@Autowired
	DemoService demoService;

	@GetMapping("/demo1")
	public String getDemo1() {
		return demoService.test();
	}

	
}
