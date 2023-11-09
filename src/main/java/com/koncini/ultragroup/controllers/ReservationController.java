package com.koncini.ultragroup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koncini.ultragroup.models.entities.Reservation;
import com.koncini.ultragroup.models.services.IDataService;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
	
	@Autowired
	private IDataService dataService;

	@GetMapping("/get-reservation/{reservation-id}")
	private Reservation getReservation(@PathVariable(value = "reservation-id") Long id) {
		return dataService.getOneReservation(id);
	}
}
