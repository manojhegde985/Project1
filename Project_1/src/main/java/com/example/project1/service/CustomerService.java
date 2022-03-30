package com.example.project1.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project1.Project1Application;
import com.example.project1.bo.CustomerBo;
import com.example.project1.dto.CustomerDto;
import com.example.project1.entity.Customer;
import com.example.project1.exception.NoRecordFoundException;
import com.example.project1.mapstruct.Mapstruct;



@Service
public class CustomerService {
	@Autowired
	private CustomerBo bo;
	@Autowired
	private Mapstruct mapstruct;

	private static final Logger logger = LoggerFactory.getLogger(Project1Application.class);
	public String ServiceLog() {
	logger.info("this is a customer management service layer ");

	return "ServiceLog";
	}



	
	public List<Customer> getAllCustomers()throws Exception   {
	List<Customer> allCustomers = mapstruct.customerDtoToCustomerList(bo.getAllCustomers());
	try{if(!allCustomers.isEmpty()) {
	return allCustomers;
	}
	else throw new NoRecordFoundException("list is empty");
	}
	catch(NoRecordFoundException e) {
	    logger.error(e.getMessage());
	    System.out.println (e.getMessage());
	}
	return allCustomers;
	}

	
	public Customer getCustomer(Integer cid) {
		
	return mapstruct.customerDtoToCustomer(bo.getCustomer(cid));
		
	     }

	
	public Customer addCustomer(Customer customer) {
		try {
			String customerdto=bo.addCustomer(mapstruct.customerToCustomerDto(customer));
		return mapstruct.customerDtoToCustomer((customerdto));
	}catch(Exception e){
		 logger.error("could not add customer");
		    System.out.println("could not add customer" + e);
	}
		return customer;
	}


	public void delete(Integer id) {

	bo.delete(id);
	}

	public String healthCheck(Integer cid) {
		return bo.healthCheck(cid);
	}

}
