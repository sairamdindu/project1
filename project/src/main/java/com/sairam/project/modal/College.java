package com.sairam.project.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="College")
public class College {

	@Id
	@GeneratedValue
	private Long id;
	
	
	@Column(name="Collegename")
	private String Collegename;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCollegename() {
		return Collegename;
	}

	public void setCollegename(String collegename) {
		Collegename = collegename;
	}

	
}
