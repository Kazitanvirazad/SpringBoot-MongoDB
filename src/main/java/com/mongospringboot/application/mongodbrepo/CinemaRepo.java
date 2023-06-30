package com.mongospringboot.application.mongodbrepo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongospringboot.application.dao.Cinema;

public interface CinemaRepo extends MongoRepository<Cinema, String> {

	boolean existsByMovieName(String name);

	void deleteByMovieName(String name);

	Optional<Cinema> findByMovieName(String name);

}
