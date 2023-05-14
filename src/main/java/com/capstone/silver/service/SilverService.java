package com.capstone.silver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.silver.dao.SilverDAO;
import com.capstone.silver.dto.SilverDTO;


@Service
public class SilverService {

	@Autowired
	SilverDAO silverDAO;
	public List<SilverDTO> getSilverList()
	{
		List<SilverDTO> silverList = silverDAO.getSilverList();
		return silverList;
	}
}
