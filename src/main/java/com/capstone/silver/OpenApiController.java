package com.capstone.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OpenApiController {
	@GetMapping("/test")
	public String test() throws Exception
	{	
		//은주 api 사이트 주소
		String base = "https://apis.data.go.kr/B551182/hospInfoServicev2/getHospBasisList";
		String key = "?serviceKey=jxwOJdF3W7dg4P7he9%2F2hwaPwgDszkbSReBLZF6tdG55G%2BcZQflK6SsRbR%2BioSWMeADf0A3vKKiSAm3JgWUU4A%3D%3D";
		String page = "&pageNo=1";
		String rows = "&numOfRows=10";
		String sideCd = "&sidoCd=310000";
		String zipCd = "&zipCd=2040";
		String clcd = "&clCd=28";
		String type = "&_type=json";

//은주 오픈api사이트
		StringBuilder urlBuilder = new StringBuilder(base);
		urlBuilder.append(key);
		urlBuilder.append(page);
		urlBuilder.append(rows);
		urlBuilder.append(type);

		
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode()); /* 연결 자체에 대한 확인이 필요하므로 추가합니다.*/
		BufferedReader rd;

		// 서비스코드가 정상이면 200~300사이의 숫자가 나옴
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
				sb.append(line);
		}
		rd.close();
		conn.disconnect();
		StringToJson(sb.toString());
		return sb.toString();
	}
	@GetMapping("/test2")
	public String test2() throws Exception
	{
		//상억 api 사이트
		StringBuilder urlBuilder = new StringBuilder("https://openapi.gg.go.kr/RecuperationHospital"); /*URL*/
		urlBuilder.append("?" +  URLEncoder.encode("Key=e773163cf73d429b81008f1c8b081444","UTF-8") ); /*인증키 (sample사용시에는 호출시 제한됩니다.)*/
		urlBuilder.append("&" +  URLEncoder.encode("Type=json","UTF-8") ); /*요청파일타입 (xml,xmlf,xls,json) */
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode()); /* 연결 자체에 대한 확인이 필요하므로 추가합니다.*/
		BufferedReader rd;

		// 서비스코드가 정상이면 200~300사이의 숫자가 나옴
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
				sb.append(line);
		}
		rd.close();
		conn.disconnect();
		StringToJson1(sb.toString());
		return sb.toString();
	}
		
	private void StringToJson1(String result) {
		JsonObject jsonObject = new Gson().fromJson(result, JsonObject.class);
		JsonArray rhArr = jsonObject.get("RecuperationHospital").getAsJsonArray();
		JsonArray rowArr = rhArr.get(1).getAsJsonObject().get("row").getAsJsonArray();
		for(int i=0;i<rowArr.size();i++)
		{
			JsonObject item = rowArr.get(i).getAsJsonObject();
			String sigunNm = item.get("SIGUN_NM").getAsString();
			System.out.println("sigunNm: " + sigunNm);
		}
		
	}
	public void StringToJson(String result) throws Exception
	{
		JsonObject jsonObject = new Gson().fromJson(result, JsonObject.class);

        JsonArray itemArray = jsonObject.getAsJsonObject("response").getAsJsonObject("body").getAsJsonObject("items").getAsJsonArray("item");

        for (int i = 0; i < itemArray.size(); i++) {
            JsonObject item = itemArray.get(i).getAsJsonObject();
            String addr = item.get("addr").getAsString();
            String yadmNm = item.get("yadmNm").getAsString();
            String clCdNm = item.get("clCdNm").getAsString();
            String hospUrl = item.get("hospUrl").getAsString();
            System.out.println("addr: " + addr);
            System.out.println("yadmNm: " +yadmNm);
            System.out.println("clCdNm: "+clCdNm);
            System.out.println("hospUrl: "+hospUrl);
        }
	}
}
