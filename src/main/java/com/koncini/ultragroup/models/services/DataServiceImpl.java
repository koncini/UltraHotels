package com.koncini.ultragroup.models.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.koncini.ultragroup.models.dao.IHotelDao;
import com.koncini.ultragroup.models.dao.IReservationDao;
import com.koncini.ultragroup.models.dao.IRoomDao;
import com.koncini.ultragroup.models.dao.IUserDao;

public class DataServiceImpl implements IDataService{
	
	@Autowired
	private IUserDao userdao;
	
	@Autowired
	private IHotelDao hotelDao;
	
	@Autowired
	private IRoomDao roomDao;
	
	@Autowired
	private IReservationDao reservationDao;

}
