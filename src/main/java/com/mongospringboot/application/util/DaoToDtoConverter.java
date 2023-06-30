package com.mongospringboot.application.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.mongospringboot.application.dao.Cinema;
import com.mongospringboot.application.dto.CinemaDTO;

@Component
public class DaoToDtoConverter {

	public List<CinemaDTO> copyCinemaListToCinemaDTOList(List<Cinema> cinemas) {
		List<CinemaDTO> cinemaDTOs = new ArrayList<>();

		if (!CollectionUtils.isEmpty(cinemas)) {
			for (Cinema cinema : cinemas) {
				if (cinema != null) {
					CinemaDTO cinemaDTO = copyCinemaToCinemaDTO(cinema);
					cinemaDTOs.add(cinemaDTO);
				}
			}
		}

		return cinemaDTOs;
	}

	public CinemaDTO copyCinemaToCinemaDTO(Cinema cinema) {
		CinemaDTO cinemaDTO = new CinemaDTO();
		if (cinema != null) {
			cinemaDTO.set_id(cinema.get_id());
			cinemaDTO.setIs3D(cinema.isIs3D());
			cinemaDTO.setLeadActor(cinema.getLeadActor());
			cinemaDTO.setMovieName(cinema.getMovieName());
		}
		return cinemaDTO;
	}

}
