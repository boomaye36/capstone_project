package com.capstone.admin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.admin.bo.AdminBO;
import com.capstone.admin.dao.AdminDAO;
import com.capstone.admin.model.Silver;
@Component
@RestController
public class AdminRestConroller {
@Autowired
private AdminBO adminBO;
@Autowired
private AdminDAO adminDAO;
@Scheduled(fixedDelay = 1000000)
	public void callApi() throws IOException {
		Silver silver = new Silver();
		adminBO.callApi(silver);
	}
	@GetMapping("/admin/test")
	public void test(Silver silver) throws IOException {
		
		String[] Sarr = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14","15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "61", "80", "81", "82", "83", "84", "85", "86", "87", "88"};
		String[] Sarr1 = {"내과", "신경과", "정신건강의학과", "외과", "정형외과", "신경외과", "흉부외과", "성형외과", "마취통증의학과", "산부인과", "소아청소년과", "안과", "이비인후과", "피부과","비뇨의학과", "영상의학과", "방사선종양학과", "병리과", "진단검사의학과", "결핵과", "재활의학과", "핵의학과", "가정의학과", "응급의학과", "직업환경의학과", "예방의학과", "구강악안면외과", "치과보철과", "치과교정과", "소아치과", "치주과", "치과보존과", "구강내과", "영상치의학과", "구강병리과", "예방치과", "통합치의학과", "한방내과", "한방소아과", "한방소아과", "한방안이비인후피부과", "한방신경정신과", "침구과", "한방재활의학과", "사상체질과", "한방응급"};
		for (int j = 0; j < Sarr.length; j++) {
		StringBuilder result = new StringBuilder();
		String urlStr = "http://apis.data.go.kr/B551182/hospInfoServicev2/getHospBasisList?serviceKey=jxwOJdF3W7dg4P7he9%2F2hwaPwgDszkbSReBLZF6tdG55G%2BcZQflK6SsRbR%2BioSWMeADf0A3vKKiSAm3JgWUU4A%3D%3D&numOfRows=100&dgsbjtCd="+Sarr[j]+"&sidoCd=310000&_type=json";
		URL url = new URL(urlStr);
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		urlConnection.setRequestMethod("GET");
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
		String returnLine;
		while ((returnLine = br.readLine()) != null) {
			result.append(returnLine + "\n\r");
		}
		urlConnection.disconnect();
		 //System.out.println(result);
		
		JSONParser parser = new JSONParser();
		JSONObject obj = new JSONObject();
		try {

			obj = (JSONObject) parser.parse(result.toString());
			//System.out.println(obj);
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		obj = (JSONObject)obj.get("response");
		obj = (JSONObject)obj.get("body");
		obj = (JSONObject)obj.get("items");
		//System.out.println(obj);
		JSONArray arr = new JSONArray();
		arr = (JSONArray) obj.get("item");
		//System.out.println(arr);
		JSONObject tempJson = new JSONObject();

		for (int i = 0; i < arr.size(); i++) { 
			tempJson = (JSONObject) arr.get(i);
			silver.setName((String) tempJson.get("yadmNm"));
			silver.setLocation((String) tempJson.get("addr"));
			silver.setCategory(Sarr1[j]);
			String add = (String) tempJson.get("addr");
			silver.setProvince(add.substring(0,2));
			adminDAO.insertSilver(silver);

}
		}
	} 
}
	