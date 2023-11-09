package com.koncini.ultragroup.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.koncini.ultragroup.models.entities.Reservation;

public interface IReservationDao extends CrudRepository<Reservation, Long>{
	
    @Query("SELECT DATEDIFF(r.finishDate, r.startDate) FROM Reservation r WHERE r.id = :reservationId")
    public Integer getReservationDurationInDays(@Param("reservationId") Long reservationId);
    
    @Query("SELECT r FROM Reservation r " +
            "JOIN r.room rm " +
            "JOIN rm.hotel h " +
            "WHERE h.id = :hotelId")
    public List<Reservation> findAllReservationsByHotelId(@Param("hotelId") Long hotelId);

}
