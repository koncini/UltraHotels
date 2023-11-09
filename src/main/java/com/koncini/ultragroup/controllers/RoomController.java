package com.koncini.ultragroup.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koncini.ultragroup.models.entities.Room;
import com.koncini.ultragroup.models.services.IDataService;

@RestController
@RequestMapping("/room")
public class RoomController {

	@Autowired
	private IDataService dataService;

	@GetMapping("/get-rooms")
	private List<Room> getRooms() {
		return dataService.getAllRooms();
	}

	@GetMapping("/get-room/{room-id}")
	private Room getRoom(@PathVariable(value = "room-id") Long id) {
		return dataService.getOneRoom(id);
	}

	@PutMapping("/enable-disable/{room-id}")
	private ResponseEntity<String> enableDisable(@PathVariable(value = "room-id") Long id) {
		Room room = dataService.getOneRoom(id);
		if (room == null) {
			return ResponseEntity.ok("Requested Room Does not Exist");
		}
		Boolean roomEnabledStatus = room.getEnabled();
		room.setEnabled(!roomEnabledStatus);
		try {
			dataService.saveRoom(room);
			return ResponseEntity.ok("Room Status Updated Succesfully");
		} catch (Error e) {
			return ResponseEntity.ok("Request Error");
		}
	}

}
