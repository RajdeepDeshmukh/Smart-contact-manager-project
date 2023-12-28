package com.contact.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CONTACT")
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int contactID;
	private String first_name;
	private String last_name;
	private String work;
	private String email;
	private String phone;
	private String image;
	@Column(length = 500 )
	private String discrption;
	
	
	
	public int getContactID() {
		return contactID;
	}
	public void setContactID(int contactID) {
		this.contactID = contactID;
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
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDiscrption() {
		return discrption;
	}
	public void setDiscrption(String discrption) {
		this.discrption = discrption;
	}
	@Override
	public String toString() {
		return "Contact [contactID=" + contactID + ", First_name=" + first_name + ", last_name=" + last_name + ", work=" + work
				+ ", email=" + email + ", phone=" + phone + ", image=" + image + ", discrption=" + discrption + "]";
	}
	public Contact(int contactID, String first_name, String last_name, String work, String email, String phone, String image,
			String discrption) {
		super();
		this.contactID = contactID;
		this.first_name = first_name;
		this.last_name = last_name;
		this.work = work;
		this.email = email;
		this.phone = phone;
		this.image = image;
		this.discrption = discrption;
	}
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@ManyToOne
	private User user;


	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
