package com.capstone.admin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.admin.dao.AdminDAO;
import com.capstone.admin.model.Silver;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

@RestController
public class AdminRestConroller {
@Autowired
private AdminDAO adminDAO;
	@GetMapping("/test")
	public void callApi(Silver silver) throws IOException {
		StringBuilder result = new StringBuilder();
		String urlStr = "https://openapi.gg.go.kr/RecuperationHospital?KEY=e773163cf73d429b81008f1c8b081444&Type=json";
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
		 System.out.println(result);
		//Gson gson = new Gson();
		JSONParser parser = new JSONParser();
		JSONObject obj = new JSONObject();
		//JsonElement jsonElement = parser.parse(result.toString());
		try {

			obj = (JSONObject) parser.parse(result.toString());
			//JSONObject obj1 = (JSONObject) obj.get("RecuperationHospital");
			//System.out.println(obj.get("RecuperationHospital"));
			
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		JSONArray arr = new JSONArray();
		arr = (JSONArray) obj.get("RecuperationHospital");
		JSONObject tempJson = new JSONObject();
		tempJson = (JSONObject) arr.get(1);
		//System.out.println(tempJson);
		JSONArray arr1 = new JSONArray();
		
		arr1 = (JSONArray) tempJson.get("row");
		for (int i = 0; i < arr1.size(); i++) { 
			tempJson = (JSONObject) arr1.get(i);
			silver.setName((String) tempJson.get("BIZPLC_NM"));
			silver.setLocation((String) tempJson.get("REFINE_LOTNO_ADDR"));
			silver.setCategory((String) tempJson.get("TREAT_SBJECT_CONT"));
			adminDAO.insertSilver(silver);

			//System.out.println("arr" + i + "번째"+tempJson.toJSONString());
		}
		//JsonArray arr = obj.get("RecuperationHospital").getAsJsonObject().get("row").getAsJsonArray();
//		JSONArray arr = obj.get
//		for (JsonElement ele : arr) {
//			JsonObject object = ele.getAsJsonObject();
//			System.out.println(object.get("BIZPLC_NM").getAsString());
//			silver.setName(object.get("BIZPLC_NM").getAsString());
//			silver.setLocation(object.get("REFINE_LOTNO_ADDR").getAsString());
//			silver.setCategory(object.get("TREAT_SBJECT_CONT").getAsString());
//			adminDAO.insertSilver(silver);
//		}
	}
	@GetMapping("/test1")
public void testjson () {
		
		//2 depth 위치에 제이슨 형태의 배열 존재하는 경우
		String request = "{\r\n" + 
				"    \"resultData\": {\r\n" + 
				"        \"jsonList\": [\r\n" + 
				"            {\r\n" + 
				"                \"test1\": \"test\",\r\n" + 
				"                \"test2\": \"test\"\r\n" + 
				"            },\r\n" + 
				"		{\r\n" + 
				"                \"test1\": \"test\",\r\n" + 
				"                \"test2\": \"test\"\r\n" + 
				"            }\r\n" + 
				"        ],\r\n" + 
				"        \"listCount\": 2\r\n" + 
				"    },\r\n" + 
				"    \"resultCode\": \"200\",\r\n" + 
				"    \"resultContent\": \"정상응답\"\r\n" + 
				"}";
		
		//최상위 json
		JSONParser jsonParser = new JSONParser();
		JSONObject resultJsonObj = new JSONObject(); //최초 깊이 1의 제이슨 객체
		try {
			resultJsonObj = (JSONObject) jsonParser.parse(request);
			System.out.println(resultJsonObj.toJSONString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		JSONObject resultJsonObj2 = (JSONObject) resultJsonObj.get("resultData"); //깊이 2의 제이슨 객체
		JSONArray resultJsonArray = new JSONArray(); //깊이 2에 존재하는 제이슨 배열을 가져올 객체
		resultJsonArray = (JSONArray) resultJsonObj2.get("jsonList"); 	
		
		//배열에 있는 제이슨 객체를 받을 임시 제이슨 객체
		JSONObject tempJson = new JSONObject();
		for (int i = 0; i < resultJsonArray.size(); i++) { //배열에 있는 제이슨 수많큼 반복한다.
			tempJson = (JSONObject) resultJsonArray.get(i);	
			System.out.println(tempJson.toJSONString());
		}
	}
}
