package com.capstone.admin.bo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.capstone.admin.dao.AdminDAO;
import com.capstone.admin.model.Silver;
import com.capstone.map.Map;

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
			// JSONParser 객체 생성
			JSONParser parser = new JSONParser();

			// 빈 JSONObject 객체 생성
			JSONObject obj = new JSONObject();

			try {
			    // result 변수를 문자열로 파싱하고 obj에 저장
			    obj = (JSONObject) parser.parse(result.toString());
			} catch (ParseException e) {
			    e.printStackTrace(); // ParseException 발생 시 예외 처리
			}

			// 빈 JSONArray 객체 생성
			JSONArray arr = new JSONArray();

			// obj에서 "RecuperationHospital" 키에 해당하는 값을 가져와서 arr에 저장
			arr = (JSONArray) obj.get("RecuperationHospital");

			// 빈 JSONObject 객체 생성
			JSONObject tempJson = new JSONObject();

			// arr에서 인덱스 1에 해당하는 JSONObject를 tempJson에 저장

			// 이 부분에서 arr.get(1) 대신 arr.get(0)을 사용할 경우 첫 번째 요소를 가져옵니다.
			tempJson = (JSONObject) arr.get(1);

			// 빈 JSONArray 객체 생성
			JSONArray arr1 = new JSONArray();
			
			// tempJson에서 "row" 키에 해당하는 값을 가져와서 arr1에 저장
			arr1 = (JSONArray) tempJson.get("row");
			// arr1의 크기만큼 반복
			for (int i = 0; i < arr1.size(); i++) { 
			    // arr1에서 i번째 요소를 가져와서 tempJson에 저장
			    tempJson = (JSONObject) arr1.get(i);
			    
			    // tempJson에서 "BIZPLC_NM" 키에 해당하는 값을 가져와서 silver 객체의 이름으로 설정
			    silver.setName((String) tempJson.get("BIZPLC_NM"));
			    
			    // tempJson에서 "REFINE_LOTNO_ADDR" 키에 해당하는 값을 가져와서 silver 객체의 위치로 설정
			    silver.setLocation((String) tempJson.get("REFINE_LOTNO_ADDR"));
			    
			    if(silver.getLocation()==null)
			    {
			    	System.out.println(silver.getName());

			    }
			    
			    // tempJson에서 "TREAT_SBJECT_CONT" 키에 해당하는 값을 가져와서 silver 객체의 카테고리로 설정
			    silver.setCategory((String) tempJson.get("TREAT_SBJECT_CONT"));
			    
			    // tempJson에서 "REFINE_WGS84_LOGT" 키에 해당하는 값을 가져와서 문자열로 변환한 후 silver 객체의 xpos로 설정
			    silver.setXpos(String.valueOf(tempJson.get("REFINE_WGS84_LOGT")));
			    
			    // tempJson에서 "REFINE_WGS84_LAT" 키에 해당하는 값을 가져와서 문자열로 변환한 후 silver 객체의 ypos로 설정
			    silver.setYpos(String.valueOf(tempJson.get("REFINE_WGS84_LAT")));
			    
			    // silver 객체의 province를 "경기"로 설정
			    silver.setProvince("경기");
			    
			    // adminDAO를 사용하여 silver 객체를 데이터베이스에 삽입
			    adminDAO.insertSilver(silver);
			}

		}
		public void test(Silver silver) throws IOException,ParseException,NullPointerException {
			
			// Sarr 배열은 병원 진료 과목 코드를 포함하고, Sarr1 배열은 과목명을 포함합니다.
			String[] Sarr = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14","15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "61", "80", "81", "82", "83", "84", "85", "86", "87", "88"};
			String[] Sarr1 = {"내과", "신경과", "정신건강의학과", "외과", "정형외과", "신경외과", "흉부외과", "성형외과", "마취통증의학과", "산부인과", "소아청소년과", "안과", "이비인후과", "피부과","비뇨의학과", "영상의학과", "방사선종양학과", "병리과", "진단검사의학과", "결핵과", "재활의학과", "핵의학과", "가정의학과", "응급의학과", "직업환경의학과", "예방의학과", "구강악안면외과", "치과보철과", "치과교정과", "소아치과", "치주과", "치과보존과", "구강내과", "영상치의학과", "구강병리과", "예방치과", "통합치의학과", "한방내과", "한방소아과", "한방소아과", "한방안이비인후피부과", "한방신경정신과", "침구과", "한방재활의학과", "사상체질과", "한방응급"};

			// Sarr 배열의 길이만큼 반복
			for (int j = 0; j < Sarr.length; j++) {
			    StringBuilder result = new StringBuilder();
			    // API 요청을 위한 URL 생성
			    String urlStr = "http://apis.data.go.kr/B551182/hospInfoServicev2/getHospBasisList?serviceKey=jxwOJdF3W7dg4P7he9%2F2hwaPwgDszkbSReBLZF6tdG55G%2BcZQflK6SsRbR%2BioSWMeADf0A3vKKiSAm3JgWUU4A%3D%3D&numOfRows=3000&dgsbjtCd="+Sarr[j]+"&zipCd=2040&_type=json";
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
			    
			    // JSON 데이터 파싱을 위한 JSONParser 객체 생성
			    JSONParser parser = new JSONParser();

			    try {
			        // JSON 데이터 파싱
			        JSONObject obj  =  (JSONObject)parser.parse(result.toString());
			        obj = (JSONObject)obj.get("response");
			        obj = (JSONObject)obj.get("body");
			        obj = (JSONObject)obj.get("items");
			        
			        // "item" 키에 해당하는 JSONArray 추출
			        JSONArray arr = new JSONArray();
			        arr = (JSONArray) obj.get("item");
			        
			        // 빈 JSONObject 객체 생성
			        JSONObject tempJson = new JSONObject();

			        // JSONArray의 각 요소를 반복
			        for (int i = 0; i < arr.size(); i++) { 
			            tempJson = (JSONObject) arr.get(i);
			            
			            // JSON 데이터를 추출하여 Silver 객체에 설정
			            silver.setName((String) tempJson.get("yadmNm"));
			            silver.setLocation((String) tempJson.get("addr"));
			            
			            if(silver.getLocation().equals("")) {
			                System.out.println(silver.getName());
			            }
			            
			            silver.setCategory(Sarr1[j]);
			            silver.setProvince((String)tempJson.get("sidoCdNm"));
			            silver.setXpos(String.valueOf(tempJson.get("XPos")));
			            silver.setYpos(String.valueOf(tempJson.get("YPos")));
			            silver.setPhonenumber((String)tempJson.get("telno"));
			            
			            // "drTotCnt" 키에 해당하는 값을 Integer로 변환하여 설정
			            Integer doctorNo = ((Long) tempJson.get("drTotCnt")).intValue();
			            silver.setDoctorNo(doctorNo);
			            
			            silver.setUrl((String)tempJson.get("hospUrl"));
			            
			            // "estbDd" 키에 해당하는 값을 날짜로 변환하여 설정
			            Integer value = 11111111;
			            if (tempJson.get("estbDd")!= null) value = ((Long) tempJson.get("estbDd")).intValue();
			            SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMdd");
			            try {
			                Date date;
			                date = originalFormat.parse(value.toString());
			                silver.setOpendate(date);
			            } catch (java.text.ParseException e) {
			                e.printStackTrace();
			            }
			            
			            // 데이터베이스에 Silver 객체를 삽입
			            adminDAO.insertSilver(silver);
			        }
			    } 
			    catch (ParseException e) {
			        e.printStackTrace();
			    }
			}

	} 
}
