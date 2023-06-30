package com.mongospringboot.application.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("cinema")
public class Cinema {
	@Id
	private String _id;
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

	public Cinema(String _id, String movieName, String leadActor, boolean is3d) {
		this();
		this._id = _id;
		this.movieName = movieName;
		this.leadActor = leadActor;
		is3D = is3d;
	}

	public Cinema() {
		super();
		// TODO Auto-generated constructor stub
	}

}
