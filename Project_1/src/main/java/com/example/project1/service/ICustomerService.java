package com.example.project1.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.project1.Project1Application;
import com.example.project1.entity.Customer;


@Service
public interface ICustomerService {
	static final Logger logger = LoggerFactory.getLogger(Project1Application.class);
	  public default String ServiceLog() {
		logger.info("this is a customer management service file ");
		return "ServiceLog";
		}
	public List<Customer> getAllCustomers();
			
	public Customer getCustomer(Integer cid);

	public Customer addCustomer(Customer customer);

	public String healthCheck(Integer cid);

	public void delete(Integer id);
			

}
