package com.capstone.test;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capstone.test.dao.TestDAO;

@Controller
 class TestController {
	@Autowired
	private TestDAO testdao;
	@RequestMapping("/test")
	public String test(Model model) {
		return "test";
	}
	@ResponseBody

	@RequestMapping("/db")
	public List<Map<String, Object>> databaseTest() {
		return testdao.selectTestList();
	}
}
