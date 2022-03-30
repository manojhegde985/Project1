package com.example.project1.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project1.entity.Customer;
import com.example.project1.exception.CustomerNotFoundException;
import com.example.project1.mapstruct.Mapstruct;
import com.example.project1.service.ICustomerService;



@ControllerAdvice
@RequestMapping(value="/customer")
@RestController
	
public class CustomerController {
	@Autowired
	private ICustomerService service;
	@Autowired
	private Mapstruct mapstruct;
	private final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @RequestMapping("/")
    String controller(){
        logger.info("This is a customer management controller layer");
        return "controller";
    }
    
	@GetMapping(value="/getAll")
	public ResponseEntity<List<Customer>> getAllCustomers()
	{
		List<Customer> getAllCustomers=service.getAllCustomers();
		
		return new ResponseEntity<>(getAllCustomers,HttpStatus.OK);
	}
	
	@GetMapping(value="/{cid}")
	public ResponseEntity<Customer> getCustomer(@PathVariable Integer cid)
	{
		Customer customer=service.getCustomer(cid);
		if(customer.getCid()==cid) {
			return new ResponseEntity<Customer>(customer,HttpStatus.OK);
		}
		else {
			throw new CustomerNotFoundException("Customer not found");
		}
	}
	
	
	@PostMapping(value="/save")
	public ResponseEntity<Customer> savecustomer( @RequestBody Customer customer)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(service.addCustomer(customer));
	}
	
	
	@DeleteMapping("/delete/{cid}")
	public void delete(@PathVariable Integer id) {
		 service.delete(id);
	}
	
	@GetMapping(value ="/healthcheck/{cid}")
	public ResponseEntity<String> healthcheck(@PathVariable Integer cid){
	String str = service.healthCheck(cid);
	logger.info("HealthCheck Successful");
	return new ResponseEntity<String>(str, HttpStatus.CREATED);
	}

}
