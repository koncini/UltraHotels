package com.koncini.ultragroup.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koncini.ultragroup.models.dao.IHotelDao;
import com.koncini.ultragroup.models.dao.IReservationDao;
import com.koncini.ultragroup.models.dao.IRoomDao;
import com.koncini.ultragroup.models.dao.IUserDao;
import com.koncini.ultragroup.models.entities.Hotel;
import com.koncini.ultragroup.models.entities.Reservation;
import com.koncini.ultragroup.models.entities.Room;
import com.koncini.ultragroup.models.entities.User;

import jakarta.transaction.Transactional;

@Service
public class DataServiceImpl implements IDataService {

	@Autowired
	private IUserDao userDao;

	@Autowired
	private IHotelDao hotelDao;

	@Autowired
	private IRoomDao roomDao;

	@Autowired
	private IReservationDao reservationDao;

	@Override
	@Transactional
	public void saveHotel(Hotel hotel) {
		hotelDao.save(hotel);
	}

	@Override
	@Transactional
	public List<Hotel> getAllHotels() {
		return (List<Hotel>) hotelDao.findAll();
	}

	@Override
	@Transactional
	public void deleteHotel(Long id) {
		hotelDao.deleteById(id);
	}

	@Override
	@Transactional
	public Hotel getOneHotel(Long id) {
		return hotelDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void saveRoom(Room room) {
		roomDao.save(room);
	}

	@Override
	@Transactional
	public List<Room> getAllRooms() {
		return (List<Room>) roomDao.findAll();
	}

	@Override
	@Transactional
	public void deleteRoom(Long id) {
		roomDao.deleteById(id);
	}

	@Override
	@Transactional
	public Room getOneRoom(Long id) {
		return roomDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void saveReservation(Reservation reservation) {
		reservationDao.save(reservation);
	}

	@Override
	@Transactional
	public List<Reservation> getAllReservations() {
		return (List<Reservation>) reservationDao.findAll();
	}

	@Override
	@Transactional
	public void deleteReservation(Long id) {
		reservationDao.deleteById(id);
	}

	@Override
	@Transactional
	public Reservation getOneReservation(Long id) {
		return reservationDao.findById(id).orElse(null);
	}

	@Override
	public Integer getReservationDuration(Long id) {
		return reservationDao.getReservationDurationInDays(id);
	}
	
	@Override
	public List<Reservation> findAllReservationsByHotel(Long id) {
		return reservationDao.findAllReservationsByHotelId(id);
	}

	@Override
	public void saveUser(User user) {
		userDao.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return (List<User>) userDao.findAll();
	}

	@Override
	public void deleteUser(Long id) {
		userDao.deleteById(id);
	}

	@Override
	public User getOneUser(Long id) {
		return userDao.findById(id).orElse(null);
	}

}
