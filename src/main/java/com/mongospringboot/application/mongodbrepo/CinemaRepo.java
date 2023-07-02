package com.mongospringboot.application.mongodbrepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mongospringboot.application.dao.Cinema;

public interface CinemaRepo extends MongoRepository<Cinema, String> {

	boolean existsByMovieName(String regexname);

	void deleteByMovieName(String name);

	Cinema findByMovieName(String name);

	@Query("{ 'movieName' : { '$regex': '?0', '$options': 'i' }}")
	Cinema[] findByMovieNameRegex(String regexname);

}
