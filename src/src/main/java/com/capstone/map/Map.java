package com.capstone.map;

import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.PlacesSearchResult;

public class Map {
	public static void sqlmap()
	{
		 String apiKey = "AIzaSyC6sgj9sT1BTjRzc718-pykqhbSpmpvB3I";
		 String placeName = "동두천제일요양병원";
		 try {
	            // Google Maps 클라이언트 초기화
	            GeoApiContext context = new GeoApiContext.Builder()
	                    .apiKey(apiKey)
	                    .build();

	            // 텍스트 기반 검색
	            PlacesSearchResponse placesSearchResponse = PlacesApi.textSearchQuery(context, placeName)
	                    .await(); // API 호출 대기

	            // 검색 결과 출력
	            for (PlacesSearchResult result : placesSearchResponse.results) {
	                System.out.println(result.name);
	                System.out.println(result.formattedAddress);
	                System.out.println("-------------------");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
}
