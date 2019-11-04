  
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
@RequestMapping("/api/v9")
public class CustomerController {
	@Autowired
	private CustomerRepository usersRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@CrossOrigin
	@GetMapping("/users")
	public List<Customer> getAllUsers() {
		return usersRepository.findAll();
	}
	
	//TEST
	@CrossOrigin
	@GetMapping("/users/{email}/{password}")
	public ResponseEntity<Customer> getUserByEmailAndPassword(@PathVariable(value = "email") String email, @PathVariable(value = "password") String password)
			throws ResourceNotFoundException {
//		System.out.print("password" + password);
//		System.out.print("email" + email);
		Customer users = usersRepository.findByEmailAndPassword(email, password);
//		System.out.print("dsasdasdasdasdasd" + users);
		return ResponseEntity.ok().body(users);
	}



	
	@CrossOrigin
	@GetMapping("/users/{id}")
	public ResponseEntity<Customer> getUsersById(@PathVariable(value = "id") Long usersId)
			throws ResourceNotFoundException {
		Customer users = usersRepository.findById(usersId)
				.orElseThrow(() -> new ResourceNotFoundException("Users not found for this id :: " + usersId));
		return ResponseEntity.ok().body(users);
	}
	
	@CrossOrigin
	@PostMapping("/users")
	public Customer createUsers(@Valid @RequestBody Customer users) {


		// test enskripsi password

		String password=users.getPassword(); 		
//		String encryptPwd = passwordEncoder.encode(password);
		users.setPassword(password);
		// SET ROLE 
		users.setRole("customer");
		return usersRepository.save(users);
	}
	
	@CrossOrigin
<<<<<<< HEAD
	@PutMapping("/users/{id}")
	public ResponseEntity<Customer> updateUsers(@PathVariable(value = "id") Long usersId,
			@Valid @RequestBody Customer usersDetails) throws ResourceNotFoundException {
		Customer users = usersRepository.findById(usersId)
				.orElseThrow(() -> new ResourceNotFoundException("Users not found for this id :: " + usersId));

		users.setEmail(usersDetails.getEmail());
		users.setLastName(usersDetails.getLastName());
        users.setFirstName(usersDetails.getFirstName());
        users.setEmail(usersDetails.getEmail());
		users.setPassword(usersDetails.getPassword());
		users.setRole(usersDetails.getRole());
		final Customer updatedUsers = usersRepository.save(users);
		return ResponseEntity.ok(updatedUsers);
=======
	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> updatecustomer(@PathVariable(value = "id") Long customerId,
			@Valid @RequestBody Customer customerDetails) throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("customer not found for this id :: " + customerId));

		customer.setName(customerDetails.getName());
		customer.setUserName(customerDetails.getUserName());
		customer.setPassword(customerDetails.getPassword());
		customer.setEmail(customerDetails.getEmail());
		customer.setPhone(customerDetails.getPhone());
		customer.setRoleUser(customerDetails.getRoleUser());
		final Customer updatedcustomer = customerRepository.save(customer);
		return ResponseEntity.ok(updatedcustomer);
>>>>>>> 8813a76314af5011bb755b90a01217001e494bd4
	}
	
	@CrossOrigin
	@DeleteMapping("/users/{id}")
	public Map<String, Boolean> deleteUsers(@PathVariable(value = "id") Long usersId)
			throws ResourceNotFoundException {
		Customer users = usersRepository.findById(usersId)
				.orElseThrow(() -> new ResourceNotFoundException("Users not found for this id :: " + usersId));

		usersRepository.delete(users);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}