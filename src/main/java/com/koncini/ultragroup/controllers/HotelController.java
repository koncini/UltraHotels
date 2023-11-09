package com.koncini.ultragroup.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koncini.ultragroup.models.entities.Hotel;
import com.koncini.ultragroup.models.services.IDataService;

@RestController
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private IDataService dataService;

	@GetMapping("/get-hotels")
	private List<Hotel> getUnits() {
		return dataService.getAllHotels();
	}

	@GetMapping("/get-hotel/{hotel_id}")
	private Hotel getHotel(@PathVariable(value = "hotel_id") Long id) {
		return dataService.getOneHotel(id);
	}

	@PostMapping("/create-hotel")
	private ResponseEntity<String> createHotel(@RequestBody Map<String, Object> requestBody) {
		Hotel hotel = new Hotel();
		String hotelName = (String) requestBody.get("name");
		Boolean hotelEnabledStatus = (Boolean) requestBody.get("enabled");
		hotel.setName(hotelName);
		hotel.setEnabled(hotelEnabledStatus);
		try {
			dataService.saveHotel(hotel);
			return ResponseEntity.ok("New Hotel Created Succesfully");
		} catch(Error e) {
			return ResponseEntity.ok("Request Error");

		}
	}

}
