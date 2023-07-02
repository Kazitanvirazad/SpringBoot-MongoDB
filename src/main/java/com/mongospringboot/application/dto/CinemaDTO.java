package com.mongospringboot.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CinemaDTO {

	@NotBlank(message = "Movie id is mandatory")
	@NotNull(message = "Movie id should not be NULL")
	private String _id;

	@NotBlank(message = "Movie name is mandatory")
	@NotNull(message = "Movie name should not be NULL")
	private String movieName;
	private String leadActor;
	private boolean is3D;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getLeadActor() {
		return leadActor;
	}

	public void setLeadActor(String leadActor) {
		this.leadActor = leadActor;
	}

	public boolean isIs3D() {
		return is3D;
	}

	public void setIs3D(boolean is3d) {
		is3D = is3d;
	}

	public CinemaDTO(String _id, String movieName, String leadActor, boolean is3d) {
		this();
		this._id = _id;
		this.movieName = movieName;
		this.leadActor = leadActor;
		is3D = is3d;
	}

	public CinemaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
