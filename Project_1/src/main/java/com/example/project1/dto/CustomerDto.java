package com.example.project1.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.project1.Project1Application;
import com.fasterxml.jackson.annotation.JsonProperty;
@Table(name="customer_table")
@Entity
public class CustomerDto {
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
	
	private static final Logger logger = LoggerFactory.getLogger(Project1Application.class);
	String EntityLog() {
	logger.info("this is a customer management entity file ");
	return "EntityLog";
	}
	public CustomerDto(Integer cid, @NotEmpty(message = "Customer Name is Required") String cname,
			@NotEmpty(message = "City is Required") String city,
			@NotEmpty(message = "Email is Required") String email) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.city = city;
		this.email = email;
	}
	public CustomerDto() {
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
	public static Logger getLogger() {
		return logger;
	}
	
	
}
