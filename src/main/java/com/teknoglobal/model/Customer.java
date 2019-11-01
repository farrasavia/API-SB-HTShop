package com.teknoglobal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	private long id;
	private String name;
	private String userName;
	private String password;
	private String alamat;
	private String email;
	private String phone;
	private String roleUser;
	
	public Customer() {
		
	}
	
	public Customer(String name, String userName, String password, String alamat, String email, String phone, String roleUser) {
		this.name = name;
		this.userName = userName; 
		this.password = password;		
		this.alamat = alamat;
		this.email = email;
		this.phone = phone;
		this.roleUser=roleUser;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "username", nullable = false)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

    @Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "alamat", nullable = false)
	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	
	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
    }

	@Column(name = "phone", nullable = false)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(name = "role_user", nullable = false)
	public String getRoleUser() {
		return roleUser;
	}
	public void setRoleUser(String roleUser) {
		this.roleUser = roleUser;
	}

	@Override
	public String toString() {
	return "Users [id=" + id + ", name=" + name + ", userName=" + userName + ", password= " + password
				+ ", alamat= "+ alamat + ", email=" + email + ", phone= "+ phone  + ",role="+ roleUser +"]";
	}

}
