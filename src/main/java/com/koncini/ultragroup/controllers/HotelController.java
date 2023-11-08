package com.koncini.ultragroup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koncini.ultragroup.models.services.IDataService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	private IDataService dataService;

}
