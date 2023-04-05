package com.capstone.test;

import java.util.Arrays;
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
<<<<<<< HEAD
	@RequestMapping("/test")
=======
	@ResponseBody
	@RequestMapping("/react")
	public List<String> hello(){
		return Arrays.asList("react", "hello");
	}
	@RequestMapping(" /test")
>>>>>>> 6b76fd2afe88468818bbb336cb220695b8340d43
	public String test(Model model) {
		return "test";
	}

	@RequestMapping("/db")
	public List<Map<String, Object>> databaseTest() {
		return testdao.selectTestList();
	}
	
}
