package com.capstone.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capstone.admin.model.Silver;
import com.capstone.main.bo.MainBO;

@Controller
public class MainController {
@Autowired
private MainBO mainBO;
@ResponseBody
	@GetMapping("/main/test")
	public Map<String, Object> selectSilver(Silver silver, Model model) {
		Map<String, Object> result = new HashMap<>();
	    List<Silver> silverList = mainBO.getSilverList(silver);
	    result.put("silverList", silverList);
	    //System.out.println("#########");
	    //System.out.println("list" +silverList);
	    return result;
	}
}
