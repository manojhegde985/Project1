package com.example.project1.entity;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cid;
	
	@Column
	@NotEmpty(message = "Customer Name is Required")
	private String cname;
	
	@Column
	@NotEmpty(message = "City is Required")
	private String city;
	
	@Column
	@NotEmpty(message = "Email is Required")
	@JsonProperty("email")
	private String email;

	public Customer(Integer cid, @NotEmpty(message = "Customer Name is Required") String cname,
			@NotEmpty(message = "City is Required") String city,
			@NotEmpty(message = "Email is Required") String email) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.city = city;
		this.email = email;
	}

	public Customer() {
		super();
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
