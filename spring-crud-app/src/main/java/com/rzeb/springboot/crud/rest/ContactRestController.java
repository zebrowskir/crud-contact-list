package com.rzeb.springboot.crud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rzeb.springboot.crud.entity.Contact;
import com.rzeb.springboot.crud.service.ContactService;

@RestController
@RequestMapping("/api")
public class ContactRestController {

	
	private ContactService contactService;
		
	@Autowired
	public ContactRestController(ContactService theContactService) {
		contactService = theContactService;
	}
	
	@GetMapping("/contacts")
	public List<Contact> findAll() {
		return contactService.findAll();
	}
	
	@GetMapping("/contacts/{ContactId}")
	public Contact getContact(@PathVariable int ContactId) {
		
		Contact theContact = contactService.findById(ContactId);
		
		if(theContact == null) {
			throw new RuntimeException("Contact not found " + ContactId);
		}
		
		return theContact;
	}
	
	@PostMapping("/contacts")
	public Contact addContact(@RequestBody Contact theContact) {
		
		//set ID to 0 to save as new, not update		
		theContact.setId(0);
		
		contactService.save(theContact);
		
		return theContact;		
	}
	
	@PutMapping("/contacts")
	public Contact updateContact(@RequestBody Contact theContact) {
		
		contactService.save(theContact);
		
		return theContact;		
	}
	
	@DeleteMapping("/contacts/{ContactId}")
	public String deleteContact(@PathVariable int ContactId) {
		
		Contact tempContact = contactService.findById(ContactId);
		
		if (tempContact == null) {
			throw new RuntimeException("Contact not found " + ContactId);
		}
		
		contactService.deleteById(ContactId);
		
		return "Contact deleted";
	}
	
}
