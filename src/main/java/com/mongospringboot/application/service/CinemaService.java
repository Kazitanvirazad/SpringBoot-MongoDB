package com.mongospringboot.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongospringboot.application.dao.Cinema;
import com.mongospringboot.application.dto.CinemaDTO;
import com.mongospringboot.application.mongodbrepo.CinemaRepo;
import com.mongospringboot.application.util.DaoToDtoConverter;
import com.mongospringboot.application.util.DtoToDaoConverter;
import com.mongospringboot.application.util.ResponseObject;

@Service
public class CinemaService {

	@Autowired
	private CinemaRepo cinemaRepo;

	@Autowired
	private DaoToDtoConverter daoToDtoConverter;

	@Autowired
	private DtoToDaoConverter dtoToDaoConverter;

	public ResponseObject getCinemaList() {
		List<Cinema> cinemas = cinemaRepo.findAll();
		List<CinemaDTO> cinemaDTOs = daoToDtoConverter.copyCinemaListToCinemaDTOList(cinemas);
		if (cinemaDTOs.size() > 0)
			return new ResponseObject(false, cinemaDTOs);
		return new ResponseObject(true, "Oops, No Movies available!");
	}

	public ResponseObject addCinema(CinemaDTO cinemaDTO) {
		if (!cinemaRepo.existsById(cinemaDTO.get_id())) {
			Cinema cinema = dtoToDaoConverter.copyCinemaDTOToCinema(cinemaDTO);
			Cinema insertedCinema = cinemaRepo.insert(cinema);
			if (insertedCinema != null)
				return new ResponseObject(false, daoToDtoConverter.copyCinemaToCinemaDTO(insertedCinema));
			return new ResponseObject(true, "Movie insertion failed!");
		} else {
			return new ResponseObject(true, "Movie already exists!");
		}

	}

	public ResponseObject deleteCinema(String name) {
		if (cinemaRepo.existsByMovieName(name)) {
			cinemaRepo.deleteByMovieName(name);
			return new ResponseObject(false, "Movie deleted successfully!");
		} else {
			return new ResponseObject(true, "Movie not found with name " + name);
		}
	}

	public ResponseObject updateCinemaByName(String originalName, String newName) {
		if (cinemaRepo.existsByMovieName(originalName)) {
			Cinema cinema = cinemaRepo.findByMovieName(originalName);
			if (cinema != null) {
				cinema.setMovieName(newName);
				Cinema updatedCinema = cinemaRepo.save(cinema);
				if (updatedCinema != null)
					return new ResponseObject(false, daoToDtoConverter.copyCinemaToCinemaDTO(updatedCinema));
				return new ResponseObject(true, "Movie update failed!");
			} else {
				return new ResponseObject(true, "Movie not found with name " + originalName);
			}
		} else {
			return new ResponseObject(true, "Movie not found with name " + originalName);
		}
	}

	public ResponseObject getCinemaByName(String name) {
		Cinema[] cinema = cinemaRepo.findByMovieNameRegex(name);
		if (cinema.length > 0 && cinema[0] != null) {
			CinemaDTO cinemaDTO = daoToDtoConverter.copyCinemaToCinemaDTO(cinema[0]);
			return new ResponseObject(false, cinemaDTO);
		} else {
			return new ResponseObject(true, "Movie not found with name " + name);
		}
	}
}
