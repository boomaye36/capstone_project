package com.capstone.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capstone.admin.model.Silver;
import com.capstone.admin.model.SilverCountView;
import com.capstone.main.bo.MainBO;
import com.capstone.user.model.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
@Autowired
private MainBO mainBO;
@ResponseBody
	@GetMapping("/main/test")
	public Map<String, Object> selectSilver(HttpSession session, Silver silver, Model model, @RequestParam("sort") String sort) {
	User user = (User)session.getAttribute("loginUser");
	Integer userId = (Integer)user.getId();
	Map<String, Object> result = new HashMap<>();
	    List<SilverCountView> silverList = mainBO.getSilverList(silver, sort, userId);
	    result.put("silverList", silverList);
	    return result;
	}
}