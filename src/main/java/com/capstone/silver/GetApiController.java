package com.capstone.silver;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.silver.service.SilverService;



@RestController
@RequestMapping("/db-api")
public class GetApiController {

	@Autowired
	SilverService silverService;
	
	@GetMapping(value = "/silver")
	 public ResponseEntity<?> getCompanyList(){
        HashMap<String, Object> result = new HashMap<>();

        result.put("data", silverService.getSilverList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
