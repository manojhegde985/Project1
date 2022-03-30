package com.example.project1.eo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.project1.Project1Application;
import com.example.project1.dto.CustomerDto;



public interface ICustomerEo {
	static final Logger logger = LoggerFactory.getLogger(Project1Application.class);
	  public default String ServiceLog() {
		logger.info("this is a customer management entity file ");
	      logger.warn("this is a warn message");
	      logger.error("this is an error message");
		return "ServiceLog";
		}
	public List<CustomerDto> getAllCustomers();
			
	public CustomerDto getCustomer(Integer cid);

	public String addCustomer(CustomerDto customer);

	public String healthCheck(Integer cid);

}
