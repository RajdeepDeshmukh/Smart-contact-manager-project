package com.contact.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.contact.entities.Contact;

public interface ContactRepository extends CrudRepository<Contact, Integer> {

	@Query("from Contact as c where c.user.userID =:userID")
	public List<Contact> findContactsByUser(@Param("userID") int userID);
}
