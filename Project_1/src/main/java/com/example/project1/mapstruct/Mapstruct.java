package com.example.project1.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.project1.dto.CustomerDto;
import com.example.project1.entity.Customer;


@Mapper(componentModel="spring")
public interface Mapstruct {
	CustomerDto customerToCustomerDto(Integer cid);

	CustomerDto customerToCustomerDto(Customer customer);

	Customer customerDtoToCustomer(String customerdto);

	List<CustomerDto> customerToCustomerDtoList(List<Customer> list);

	List<Customer> customerDtoToCustomerList(List<CustomerDto> list);

	Customer customerDtoToCustomer(CustomerDto customer);
}
