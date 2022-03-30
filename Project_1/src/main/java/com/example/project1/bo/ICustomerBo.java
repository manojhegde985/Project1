package com.example.project1.bo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.example.project1.Project1Application;
import com.example.project1.dto.CustomerDto;

public interface ICustomerBo {
	static final Logger logger = LoggerFactory.getLogger(Project1Application.class);
	  public default String ServiceLog() {
		logger.info("this is a customer management bo file ");
	     
		return "ServiceLog";
		}
	public List<CustomerDto> getAllCustomers();
			
	public CustomerDto getCustomer(Integer cid);

	public String addCustomer(CustomerDto customer);

	public String healthCheck(Integer cid);

	public void delete(Integer id);
			

}
