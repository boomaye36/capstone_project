package com.capstone.admin.bo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.capstone.admin.dao.AdminDAO;
import com.capstone.admin.model.Silver;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j     // 로그를 위해서
@Component // 빈 등록 
public class AdminBO {
	@Autowired
	private AdminDAO adminDAO;
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
			 //System.out.println(result);
			JSONParser parser = new JSONParser();
			JSONObject obj = new JSONObject();
			try {

				obj = (JSONObject) parser.parse(result.toString());
				
			
			} catch (ParseException e) {
				e.printStackTrace();
			}
			JSONArray arr = new JSONArray();
			arr = (JSONArray) obj.get("RecuperationHospital");
			JSONObject tempJson = new JSONObject();
			tempJson = (JSONObject) arr.get(1);
			JSONArray arr1 = new JSONArray();
			
			arr1 = (JSONArray) tempJson.get("row");
			for (int i = 0; i < arr1.size(); i++) { 
				tempJson = (JSONObject) arr1.get(i);
				silver.setName((String) tempJson.get("BIZPLC_NM"));
				silver.setLocation((String) tempJson.get("REFINE_LOTNO_ADDR"));
				silver.setCategory((String) tempJson.get("TREAT_SBJECT_CONT"));
				silver.setProvince("경기");
				adminDAO.insertSilver(silver);

			}
		}
}
