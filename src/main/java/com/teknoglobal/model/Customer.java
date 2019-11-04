package com.teknoglobal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Customer {

	private long id;
	private String firstName;
	private String lastName;
    private String email;
	private String password;
<<<<<<< HEAD
	private String role;
=======
	private String email;
	private String phone;
	private String roleUser;
>>>>>>> 8813a76314af5011bb755b90a01217001e494bd4
	
	public Customer() {
		
	}
	
<<<<<<< HEAD
	public Customer(String firstName, String lastName, String email, String password, String role) {
		this.firstName = firstName;
		this.lastName = lastName;
        this.email = email;
		this.password = password;
		this.role=role;
=======
	public Customer(String name, String userName, String password, String email, String phone, String roleUser) {
		this.name = name;
		this.userName = userName; 
		this.password = password;		
		this.email = email;
		this.phone = phone;
		this.roleUser=roleUser;
>>>>>>> 8813a76314af5011bb755b90a01217001e494bd4
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}
<<<<<<< HEAD
	public void setLastName(String lastName) {
		this.lastName = lastName;
=======
	public void setPassword(String password) {
		this.password = password;
>>>>>>> 8813a76314af5011bb755b90a01217001e494bd4
	}
	
	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
    }

    @Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "role", nullable = false)
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
<<<<<<< HEAD
	return "Users [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ",role="+role+"]";
=======
	return "Users [id=" + id + ", name=" + name + ", userName=" + userName + ", password= " + password
				+ ", email=" + email + ", phone= "+ phone  + ",role="+ roleUser +"]";
>>>>>>> 8813a76314af5011bb755b90a01217001e494bd4
	}
	
}