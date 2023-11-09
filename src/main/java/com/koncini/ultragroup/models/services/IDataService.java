package com.koncini.ultragroup.models.services;

import java.util.List;

import com.koncini.ultragroup.models.entities.Hotel;
import com.koncini.ultragroup.models.entities.Reservation;
import com.koncini.ultragroup.models.entities.Room;
import com.koncini.ultragroup.models.entities.User;

public interface IDataService {
	
	//Hotels Declarations
	
	public void saveHotel(Hotel hotel);

	public List<Hotel> getAllHotels();

	public void deleteHotel(Long id);

	public Hotel getOneHotel(Long id);
	
	//Rooms Declarations
	
	public void saveRoom(Room room);

	public List<Room> getAllRooms();

	public void deleteRoom(Long id);

	public Room getOneRoom(Long id);
	
	//Reservations Declarations
	
	public void saveReservation(Reservation reservation);

	public List<Reservation> getAllReservations();

	public void deleteReservation(Long id);

	public Reservation getOneReservation(Long id);
	
	public Integer getReservationDuration(Long id);
	
	public List<Reservation> findAllReservationsByHotel(Long id);
	
	//User Declarations
	
	public void saveUser(User user);

	public List<User> getAllUsers();

	public void deleteUser(Long id);

	public User getOneUser(Long id);

}
