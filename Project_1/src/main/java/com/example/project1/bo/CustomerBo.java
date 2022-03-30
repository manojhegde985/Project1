package com.example.project1.bo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.project1.dto.CustomerDto;
import com.example.project1.eo.CustomerEo;
import com.example.project1.mapstruct.Mapstruct;



public class CustomerBo implements ICustomerBo{
	@Autowired
	private CustomerEo eo;
	@Autowired
	private Mapstruct mapstruct;


	private static final Logger logger = LoggerFactory.getLogger(CustomerBo.class);
	public String ServiceLog() {
	logger.info("this is a customer management bo file ");
	return "ServiceLog";
	}


	public List<CustomerDto> getAllCustomers() {
		List<CustomerDto> allCustomers=eo.getAllCustomers();
		return allCustomers;
	}

	public CustomerDto getCustomer(Integer cid) {
	return eo.getCustomer( cid);

	}

	@Override
	public String addCustomer(CustomerDto customer) {
		return eo.addCustomer(customer);
	}

	public void delete(Integer id) {

	eo.delete(id);
	}

	public String healthCheck(Integer cid) {
		return eo.healthCheck(cid);
	}



}
