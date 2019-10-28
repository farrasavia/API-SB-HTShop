  
package com.teknoglobal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;




import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teknoglobal.exception.ResourceNotFoundException;
import com.teknoglobal.model.Customer;
import com.teknoglobal.repository.CustomerRepository;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@CrossOrigin
	@GetMapping("/customer")
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}
	
	//TEST
	@CrossOrigin
	@GetMapping("/login/{email}/{password}")
	public ResponseEntity<Customer> getCustomerByEmailAndPassword(@PathVariable(value = "email") String email, @PathVariable(value = "password") String password)
			throws ResourceNotFoundException {
		Customer customer = customerRepository.findByEmailAndPassword(email, password);
		return ResponseEntity.ok().body(customer);
	}


	@CrossOrigin
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getcustomerById(@PathVariable(value = "id") Long customerId)
			throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("customer not found for this id :: " + customerId));
		return ResponseEntity.ok().body(customer);
	}
	
	@CrossOrigin
	@PostMapping("/customer")
	public Customer createcustomer(@Valid @RequestBody Customer customer) {


		// test enskripsi password

		String password=customer.getPassword(); 		
		String encryptPwd = passwordEncoder.encode(password);
		customer.setPassword(encryptPwd);
		// SET ROLE 
		customer.setRoleUser("customer");
		return customerRepository.save(customer);
	}
	
	@CrossOrigin
	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> updatecustomer(@PathVariable(value = "id") Long customerId,
			@Valid @RequestBody Customer customerDetails) throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("customer not found for this id :: " + customerId));

		customer.setName(customerDetails.getName());
		customer.setUserName(customerDetails.getUserName());
		customer.setPassword(customerDetails.getPassword());
		customer.setAlamat(customerDetails.getAlamat());
		customer.setEmail(customerDetails.getEmail());
		customer.setPhone(customerDetails.getPhone());
		customer.setRoleUser(customerDetails.getRoleUser());
		final Customer updatedcustomer = customerRepository.save(customer);
		return ResponseEntity.ok(updatedcustomer);
	}
	
	@CrossOrigin
	@DeleteMapping("/customer/{id}")
	public Map<String, Boolean> deletecustomer(@PathVariable(value = "id") Long customerId)
			throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("customer not found for this id :: " + customerId));

		customerRepository.delete(customer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}