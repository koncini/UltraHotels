package com.koncini.ultragroup.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.koncini.ultragroup.models.entities.Reservation;

public interface IReservationDao extends CrudRepository<Reservation, Long>{

}
