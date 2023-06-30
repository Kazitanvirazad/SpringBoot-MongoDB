package com.mongospringboot.application.util;

import org.springframework.stereotype.Component;

import com.mongospringboot.application.dao.Cinema;
import com.mongospringboot.application.dto.CinemaDTO;

@Component
public class DtoToDaoConverter {

	public Cinema copyCinemaDTOToCinema(CinemaDTO cinemaDto) {
		Cinema cinema = new Cinema();
		if (cinemaDto != null) {
			cinema.set_id(cinemaDto.get_id());
			cinema.setIs3D(cinemaDto.isIs3D());
			cinema.setLeadActor(cinemaDto.getLeadActor());
			cinema.setMovieName(cinemaDto.getMovieName());
		}
		return cinema;
	}
}
