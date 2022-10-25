package com.iuh.ecapp.model.entity;

import com.iuh.ecapp.model.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
	@Column(name = "create_date")
	private Date createdDate;
	@Column(name = "modified_date")
	private Date modifiedDate;
	@Enumerated(EnumType.STRING)
	private UserRole role;
	private String avatar;
}
