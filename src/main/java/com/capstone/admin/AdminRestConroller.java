package com.capstone.admin;

import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.admin.bo.AdminBO;
import com.capstone.admin.dao.AdminDAO;
import com.capstone.admin.model.Silver;
import com.capstone.map.Map;
@Component
@RestController
public class AdminRestConroller {
@Autowired
private AdminBO adminBO;
@Autowired
private AdminDAO adminDAO;

// 1000초마다 실행
@Scheduled(fixedDelay = 1000000)
	public void callApi() throws IOException, ParseException {
		Silver silver = new Silver();
		//api 호출
		adminBO.callApi(silver);
		//또 다른 api 호출하기
		adminBO.test(silver);
	}
}
	
//String urlStr ="http://apis.data.go.kr/B551182/hospInfoServicev2/getHospBasisList?serviceKey=jxwOJdF3W7dg4P7he9%2F2hwaPwgDszkbSReBLZF6tdG55G%2BcZQflK6SsRbR%2BioSWMeADf0A3vKKiSAm3JgWUU4A%3D%3D&numOfRows=1000&dgsbjtCd="+Sarr[j]+"&sidoCd=310000&_type=json&clCd=28";
