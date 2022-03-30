package com.example.project1.eo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.project1.Project1Application;
import com.example.project1.dao.ICustomerRepository;
import com.example.project1.dto.CustomerDto;
import com.example.project1.exception.CustomerNotFoundException;
import com.example.project1.mapstruct.Mapstruct;



public class CustomerEo implements ICustomerEo {
	@Autowired
	private ICustomerRepository repository;
	@Autowired
	private Mapstruct mapstruct;

	private static final Logger logger = LoggerFactory.getLogger(Project1Application.class);
	public String ServiceLog() {
	logger.info("this is a customer management eo file ");
	return "ServiceLog";
	}




	public List<CustomerDto> getAllCustomers() {
	List<CustomerDto> allCustomers=repository.findAll();
	return allCustomers;
	}

	public CustomerDto getCustomer(Integer cid) {
	return repository.findById(cid).orElseThrow(()->new CustomerNotFoundException("Customer Not Found"));

	}

	@Override
	public String addCustomer(CustomerDto customer) {
		return repository.save(customer);
	}

	public void delete(Integer id) {

	repository.deleteById(id);
	}


	@Override
	public String healthCheck(Integer cid) {

	java.util.Optional<CustomerDto> s = repository.findById(cid);
	if(s.isPresent()) {
	return ("HealthCheck-Success");
	}
	else {
	return ("HealthCheck-Failure");
	}
	}

}
