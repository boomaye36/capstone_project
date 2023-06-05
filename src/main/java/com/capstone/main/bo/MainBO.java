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

	@Autowired
	private MainDAO mainDAO;
	public List<SilverCountView> getSilverList(Silver silver, String sort, int userId){
		List<SilverCountView> silverCountList = new ArrayList<>();
		List<Silver> silverList =  mainDAO.selectSilverList(silver, sort);
		for (Silver x : silverList) {
			SilverCountView silvercount = new SilverCountView();
			silvercount.setSilver(x);
			silvercount.setSilverCount(mainDAO.selectSilverCount(userId, silver.getId()));
			silverCountList.add(silvercount);
		}
		if (sort == "access") Collections.sort(silverCountList);
		return silverCountList;
	}
}