package com.example.demo.repository;

import com.example.demo.model.User;
import org.aspectj.bridge.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends CrudRepository<User, Integer> {

}