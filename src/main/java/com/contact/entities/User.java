package com.contact.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userID;

	@Column(unique = true)
	@Email(message = "Invalid email format")
	@NotBlank(message = "Email cannot be empty or contain only whitespace")
	private String email;


	private String password;

	@NotBlank(message = "First Name Cannot be empty !!")
	@Size(min = 1, max = 10, message = "The first name should be Between 1-10 character")
	private String first_name;

	@NotBlank(message = "Last Name Cannot be empty !!")
	@Size(min = 1, max = 10, message = "The last name should be Between 1-10 character")
	private String last_name;

	private String image;

	private String role;

	@Column(length = 500)
	private String about;

	private boolean enabled;

	@Override
	public String toString() {
		return "User [userID=" + userID + ", email=" + email + ", password=" + password + ", first_name=" + first_name
				+ ",last_name=" + last_name + ", image=" + image + ", role=" + role + ", about=" + about + ", enabled="
				+ enabled + "]";
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int id) {
		this.userID = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String email, String password, String first_name, String last_name, String image, String role,
			String about, boolean enabled) {
		super();
		this.userID = id;
		this.email = email;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.image = image;
		this.role = role;
		this.about = about;
		this.enabled = enabled;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	private List<Contact> contacts = new ArrayList<>();

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

}
