package com.koncini.ultragroup.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.koncini.ultragroup.models.entities.User;

public interface IUserDao extends CrudRepository<User, Long>{

}
