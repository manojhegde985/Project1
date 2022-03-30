package com.example.project1.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.project1.Project1Application;
import com.example.project1.dto.CustomerDto;



@Repository
public interface ICustomerRepository {
	static final Logger logger = LoggerFactory.getLogger(Project1Application.class);
	default String RepositoryLog() {
	logger.info("this is a customer management repository file ");
	return "RepositoryLog";
	}
	
	public static final JdbcTemplate jdbcTemp = new JdbcTemplate();
	
	public default List<CustomerDto> findAll() {
		List<CustomerDto> customerList=new ArrayList<>();
		jdbcTemp.queryForList("get all the customers",String.class);
		return  customerList;
		
	}
	
	 public default String save(CustomerDto customer) {
		 String query="insert into customer values(  "
				    +customer.getCid()+"','"+customer.getCname()+"','"+customer.getCity()+"','"+customer.getEmail();
				    return query;  
		
	}

	public default Optional<CustomerDto> findById(Integer cid) {
		CustomerDto customer=new CustomerDto(cid, null, null, null);
		jdbcTemp.queryForList("get a customer",String.class);
		return  Optional.of(customer);
		
	}

	public default void deleteById(Integer cid) {
		String query="delete from product where id='"+cid.getClass()+"' ";  
	    return;  
	}

	
}
