package com.koncini.ultragroup.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.koncini.ultragroup.models.entities.Room;

public interface IRoomDao extends CrudRepository<Room, Long>{
	
}
