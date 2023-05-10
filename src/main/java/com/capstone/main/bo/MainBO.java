package com.capstone.main.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.admin.model.Silver;
import com.capstone.main.dao.MainDAO;

@Service
public class MainBO {

	@Autowired
	private MainDAO mainDAO;
	public List<Silver> getSilverList(Silver silver){
		return mainDAO.selectSilverList(silver);
	}
}
