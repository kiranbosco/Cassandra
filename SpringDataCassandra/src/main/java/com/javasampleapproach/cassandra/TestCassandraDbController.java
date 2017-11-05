package com.javasampleapproach.cassandra;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.cassandra.model.Customer;
import com.javasampleapproach.cassandra.repository.CustomerRepository;

@RestController
public class TestCassandraDbController {
	
	
	@Autowired
	CustomerRepository customerRepository;
	
	
	@RequestMapping(value = "/saveData", method = RequestMethod.POST, produces = "application/json")
	public void saveData(@RequestBody Customer customer){
		System.out.println("===================Save Customers to Cassandra===================");
		
        customerRepository.save(customer);
	}
	
	@RequestMapping(value = "/getData/{firstname}", method = RequestMethod.GET, produces = "application/json")
	public List<Customer> lookup(@PathVariable("firstname") String firstname){
		System.out.println("===================Lookup Customers from Cassandra by Firstname===================");
		List<Customer> peters = customerRepository.findByFirstname(firstname);

		/*System.out.println("===================Lookup Customers from Cassandra by Age===================");
		List<Customer> custsAgeGreaterThan25 = customerRepository.findCustomerHasAgeGreaterThan(25);
		custsAgeGreaterThan25.forEach(System.out::println);*/
		
		return peters;
	}
	
	@RequestMapping(value = "/getAge/{age}", method = RequestMethod.GET, produces = "application/json")
	public List<Customer> findCustomerHasAgeGreaterThan(@PathVariable("age") int age){
		List<Customer> custsAgeGreaterThan25 = customerRepository.findCustomerHasAgeGreaterThan(age);
		
		return custsAgeGreaterThan25;
	}
	

}
