package com.capstone.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capstone.test.dao.TestDAO;

import ch.qos.logback.core.model.Model;
@SpringBootApplication

@Controller
 class TestController {
	@Autowired
	private TestDAO testdao;
	@RequestMapping("/test")
	public String test(Model model) {
		return "test";
	}
	@ResponseBody
	//@ResponseBody
	@RequestMapping("/react")
	public List<String> hello(){
		return Arrays.asList("react", "hello");
	}
	
	@RequestMapping("/db")
	@GetMapping("/api")
	public String test() {
		return "frontend/public/index.html";
	}
	@ResponseBody
	@GetMapping("/db")
	public List<Map<String, Object>> databaseTest() {
		return testdao.selectTestList();
	}
	
}
