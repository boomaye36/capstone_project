/*package com.capstone.main.bo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.admin.model.Silver;
import com.capstone.admin.model.SilverCountView;
import com.capstone.main.dao.MainDAO;

@Service
public class MainBO {

	@Autowired
	private MainDAO mainDAO;

	/**
	 * 병원 목록을 조회하고, 각 은행의 정보와 현재 사용자의 관심 목록에서 해당 병원의 카운트를 가져옵니다.
	 * @param silver   Silver 객체를 통해 병원 정보를 필터링합니다.
	 * @param sort     정렬 방식을 지정합니다.
	 * @param userId   현재 사용자의 고유 식별자입니다.
	 * @return         SilverCountView 객체의 리스트를 반환합니다.
	 */ /*
	public List<SilverCountView> getSilverList(Silver silver, String sort, int userId){
	    List<SilverCountView> silverCountList = new ArrayList<>();
	    
	    // MainDAO를 통해 병원 정보를 조회합니다.
	    List<Silver> silverList =  mainDAO.selectSilverList(silver, sort);
	    
	    // 조회된 각 병원에 대한 정보와 현재 사용자의 관심 목록에서 해당 병원의 카운트를 가져와서 SilverCountView 객체를 생성하고 리스트에 추가합니다.
	    for (Silver x : silverList) {
	        SilverCountView silvercount = new SilverCountView();
	        silvercount.setSilver(x);
	        silvercount.setSilverCount(mainDAO.selectSilverCount(userId, silver.getId()));
	        silverCountList.add(silvercount);
	    }
	    
	    // 정렬 방식이 "access"인 경우, 병원 목록을 카운트에 따라 정렬합니다.
	    if (sort.equals("access")) {
	        Collections.sort(silverCountList);
	    }
	    
	    // SilverCountView 객체의 리스트를 반환합니다.
	    return silverCountList;
	}
	

}
*/

package com.capstone.main.bo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.admin.model.Silver;
import com.capstone.admin.model.SilverCountView;
import com.capstone.main.dao.MainDAO;

@Service
public class MainBO {

//	@Autowired
//	private MainDAO mainDAO;
//	public List<SilverCountView> getSilverList(Silver silver){
//		List<SilverCountView> silverCountList = new ArrayList<>();
//		List<Silver> silverList =  mainDAO.selectSilverList(silver);
//		for (Silver x : silverList) {
//			SilverCountView silvercount = new SilverCountView();
//			silvercount.setSilver(x);
//			silvercount.setSilverCount(mainDAO.selectSilverCount( silver.getId()));
//			silverCountList.add(silvercount);
//		}
////		if (sort == "access") Collections.sort(silverCountList);
//		return silverCountList;
//	}
	
	@Autowired
	private MainDAO mainDAO;
	public List<Silver> getSilverList(Silver silver){
		List<Silver> silverList =  mainDAO.selectSilverList(silver);
//		for (Silver x : silverList) {
//			SilverCountView silvercount = new SilverCountView();
//			silvercount.setSilver(x);
//			silvercount.setSilverCount(mainDAO.selectSilverCount( silver.getId()));
//		}
		return silverList;
	}
}




