package com.capstone.admin;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.admin.bo.AdminBO;
import com.capstone.admin.model.Silver;
@Component
@RestController
public class AdminRestConroller {
@Autowired
private AdminBO adminBO;
@Scheduled(fixedDelay = 1000000)
	public void callApi() throws IOException {
		Silver silver = new Silver();
		adminBO.callApi(silver);
	}
}
	