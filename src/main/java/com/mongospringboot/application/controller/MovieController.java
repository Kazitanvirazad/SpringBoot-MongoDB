package com.mongospringboot.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongospringboot.application.dto.CinemaDTO;
import com.mongospringboot.application.service.CinemaService;
import com.mongospringboot.application.util.ResponseObject;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/movie")
@CrossOrigin
public class MovieController {

	@Autowired
	private CinemaService cinemaService;

	@GetMapping(path = "movies", produces = { "application/json" })
	public ResponseEntity<ResponseObject> getMovieNames() {
		ResponseObject responseObject = cinemaService.getCinemaList();
		if (!responseObject.isError())
			return new ResponseEntity<ResponseObject>(responseObject, new HttpHeaders(), HttpStatus.OK);
		return new ResponseEntity<>(responseObject, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}

	@PostMapping(path = "addmovie", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<ResponseObject> addMovie(@RequestBody @Valid CinemaDTO cinemaDTO) {
		ResponseObject responseObject = cinemaService.addCinema(cinemaDTO);

		if (responseObject.isError())
			return new ResponseEntity<>(responseObject, new HttpHeaders(), HttpStatus.CONFLICT);
		return new ResponseEntity<>(responseObject, new HttpHeaders(), HttpStatus.CREATED);
	}

	@DeleteMapping(path = "deletemovie", produces = { "application/json" })
	public ResponseEntity<ResponseObject> deleteMovie(@RequestParam(name = "cinamename") String name) {
		ResponseObject responseObject = cinemaService.deleteCinema(name);

		if (responseObject.isError())
			return new ResponseEntity<>(responseObject, new HttpHeaders(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(responseObject, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping(path = "updatemoviebyname", produces = { "application/json" })
	public ResponseEntity<ResponseObject> updateMovie(@RequestParam(name = "originalname") String originaName,
			@RequestParam(name = "newname") String newName) {
		ResponseObject responseObject = cinemaService.updateCinemaByName(originaName, newName);

		if (responseObject.isError())
			return new ResponseEntity<>(responseObject, new HttpHeaders(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(responseObject, new HttpHeaders(), HttpStatus.CREATED);
	}
}
