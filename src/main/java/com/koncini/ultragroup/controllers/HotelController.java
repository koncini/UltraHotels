package com.koncini.ultragroup.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koncini.ultragroup.models.entities.Hotel;
import com.koncini.ultragroup.models.entities.Room;
import com.koncini.ultragroup.models.services.IDataService;

@RestController
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private IDataService dataService;

	@GetMapping("/get-hotels")
	private List<Hotel> getHotels() {
		return dataService.getAllHotels();
	}

	@GetMapping("/get-hotel/{hotel-id}")
	private Hotel getHotel(@PathVariable(value = "hotel-id") Long id) {
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
		} catch (Error e) {
			return ResponseEntity.ok("Request Error");

		}
	}

	@PutMapping("/enable-disable/{hotel-id}")
	private ResponseEntity<String> enableDisable(@PathVariable(value = "hotel-id") Long id) {
		Hotel hotel = dataService.getOneHotel(id);
		if (hotel == null) {
			return ResponseEntity.ok("Requested Hotel Does not Exist");
		}
		Boolean hotelEnabledStatus = hotel.getEnabled();
		hotel.setEnabled(!hotelEnabledStatus);
		try {
			dataService.saveHotel(hotel);
			return ResponseEntity.ok("Hotel Status Updated Succesfully");
		} catch (Error e) {
			return ResponseEntity.ok("Request Error");
		}
	}

	@PostMapping("/{hotel-id}/create-room")
	private ResponseEntity<String> createRoom(@RequestBody Map<String, Object> requestBody,
			@PathVariable(value = "hotel-id") Long hotelId) {
		Hotel hotel = dataService.getOneHotel(hotelId);
		if (hotel == null) {
			return ResponseEntity.ok("Requested Hotel Does not Exist");
		}
		String roomDetails = (String) requestBody.get("details");
		Integer roomBasePrice = (Integer) requestBody.get("basePrice");
		Integer roomTax = (Integer) requestBody.get("tax");
		String roomType = (String) requestBody.get("roomType");
		Integer roomLocation = (Integer) requestBody.get("location");
		Boolean roomEnabledStatus = (Boolean) requestBody.get("enabled");
		Room room = new Room();
		room.setHotel(hotel);
		room.setDetails(roomDetails);
		room.setBasePrice(roomBasePrice);
		room.setTax(roomTax);
		room.setRoomType(roomType);
		room.setLocation(roomLocation);
		room.setEnabled(roomEnabledStatus);
		try {
			dataService.saveRoom(room);
			return ResponseEntity.ok("New Room Created Succesfully");
		} catch (Error e) {
			return ResponseEntity.ok("Request Error");

		}
	}

}
