package com.koncini.ultragroup.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.koncini.ultragroup.models.entities.Hotel;

public interface IHotelDao extends CrudRepository<Hotel, Long>{

}
