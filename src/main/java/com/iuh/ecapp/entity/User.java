package com.iuh.ecapp.entity;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "username")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "address")
	private String address;
	@Column(name = "telephone")
	private String telephone;
	@Column(name = "role")
	private String role;
	@Column(name = "create_date")
	private Date createdDate;
	@Column(name = "modified_date")
	private Date modifiedDate;

}
