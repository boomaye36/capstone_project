/*package com.capstone.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.admin.model.Silver;
import com.capstone.admin.model.SilverCountView;
import com.capstone.main.bo.MainBO;
import com.capstone.user.model.User;

import jakarta.servlet.http.HttpSession;

@RestController
public class MainController {
@Autowired
private MainBO mainBO;

@GetMapping("/")
public Map<String, Object> selectSilver(HttpSession session, Silver silver, Model model, @RequestParam("sort") String sort) {
    // 현재 로그인한 사용자 정보를 세션에서 가져옵니다.
    User user = (User)session.getAttribute("loginUser");
    
    // 사용자의 고유 식별자를 추출합니다.
    Integer userId = (Integer)user.getId();
    
    // 결과 데이터를 담을 Map 객체를 생성합니다.
    Map<String, Object> result = new HashMap<>();
    
    // MainBO 클래스의 메서드를 호출하여 은행 목록 데이터를 조회합니다.
    // 매개변수로는 Silver 객체(병원 정보 필터링을 위한 조건), 정렬 방식(sort), 사용자 ID가 전달됩니다.
    List<SilverCountView> silverList = mainBO.getSilverList(silver, sort, userId);
    
    // 조회된 은행 목록을 결과 Map에 저장합니다.
    result.put("silverList", silverList);
    
    // 결과 Map을 반환합니다.
    return result;
}

}
*/



package com.capstone.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capstone.admin.model.Hospital;
import com.capstone.admin.model.Silver;
import com.capstone.main.bo.MainBO;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
@Autowired
private MainBO mainBO;
//@ResponseBody
//	@GetMapping("/main/test")
//	public Map<String, Object> selectSilver(HttpSession session, Silver silver, Model model, @RequestParam("sort") String sort) {
//	User user = (User)session.getAttribute("loginUser");
//	Integer userId = (Integer)user.getId();
//	Map<String, Object> result = new HashMap<>();
//	    List<SilverCountView> silverList = mainBO.getSilverList(silver, sort, userId);
//	    result.put("silverList", silverList);
//	    return result;
//	}

@ResponseBody
//@CrossOrigin(origins="*")
@GetMapping("/")
public Map<String, Object> selectSilver(HttpSession session, Silver silver, Model model) {
Map<String, Object> result = new HashMap<>();
    List<Silver> silverList = mainBO.getSilverList(silver);
   
    result.put("silverList", silverList);
    return result;
}
@ResponseBody
@GetMapping(value="/relate")
public Map<String, Object> getRelateHospital(Silver silver){
	Map<String, Object> result = new HashMap<>();
	List<Hospital> relateSilverList = mainBO.getAllSilverList(silver);
	result.put("relateSilverList", relateSilverList);
	for(Hospital s : relateSilverList)
	{
		List<Silver> list = s.getRecommendedList();
		for (Silver si : list) System.out.println(si.getName());
	}
	return result;
}
@GetMapping("/search")
@ResponseBody
public Map<String, Object> searchSilver(@RequestParam("name") String name, 
										@RequestParam("start") int start, Model model){
	Map<String, Object> result = new HashMap<>();
	List<Silver> silverSearchList = mainBO.getSearchList(name, start, 5); // start 페이지 부터 5개씩 정렬 
	
	result.put("silverSearchList", silverSearchList);
	return result;
}
//@GetMapping("/relate")
//@ResponseBody
//public Map<String, Object> getRelateHospital(@RequestParam("name") String name){
//	Map<String, Object> result = new HashMap<>();
//	List<Silver> relateSilverList = mainBO.getRelateSilverList(name);
//	result.put("relateSilverList", relateSilverList);
//	for (Silver s : relateSilverList) {
//		System.out.println(s.getName());
//	}
//	return result;
//}

}