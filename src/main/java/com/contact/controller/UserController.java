package com.contact.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.contact.dao.ContactRepository;
import com.contact.dao.UserRepository;
import com.contact.entities.Contact;
import com.contact.entities.User;



@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ContactRepository contactRepository;
	
	@ModelAttribute
	public void addCommonData(Model model, Principal principal) {
		String userName = principal.getName();
		System.out.println(userName);
		
		User user = userRepository.getUserByUserName(userName);
		model.addAttribute("user", user);
		
		
	}
	
	@RequestMapping("/index")
	public String dashboard(Model model, Principal principal) {
		
		return "normal/userdashboard";
	}
	
	@GetMapping("/add-contact")
	public String openAddContactForm(Model model) {
		
		model.addAttribute("title", "Add Contact");
		model.addAttribute("contact", new Contact());
		
		return "normal/add_contact_form";
	}
	
	@PostMapping("/process-contact")
	public String processContact(@ModelAttribute Contact contact, Principal principal) {
		
		String name = principal.getName();
		User user = userRepository.getUserByUserName(name);
		contact.setUser(user);
		user.getContacts().add(contact);
		userRepository.save(user);
		System.out.println(contact);
		return "normal/add_contact_form";
	}
	
	@GetMapping("/show-contacts")
	public String showContacts(Model m, Principal principal) {
		
		String userName = principal.getName();
		User user = userRepository.getUserByUserName(userName);
		
		List<Contact> contacts = contactRepository.findContactsByUser(user.getUserID());
		
		m.addAttribute("contacts", contacts);
		return "normal/show_contacts";
	}
	
	@GetMapping("/delete/{contactID}")
	public String deleteContact(@PathVariable("contactID") Integer contactID, Model model) {
		
		Optional<Contact> contactOptional = contactRepository.findById(contactID);
		Contact contact = contactOptional.get();
		contact.setUser(null);
		contactRepository.delete(contact);
		
		return "redirect:/user/show-contacts";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
