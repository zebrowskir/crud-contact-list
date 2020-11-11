package com.rzeb.springboot.crud.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rzeb.springboot.crud.entity.Contact;
import com.rzeb.springboot.crud.service.ContactService;

@Controller
@RequestMapping("/contacts")
public class ContactController {

	private ContactService contactService;
	
	//injection
	public ContactController(ContactService thecontactService) {
		contactService = thecontactService;
	}
	
	
	@GetMapping("/list")
	public String listContacts(Model theModel) {
		
		// get list from database
		List<Contact> theContacts = contactService.findAll();
		
		// add to the model
		theModel.addAttribute("contacts", theContacts);
		
		return "contacts/list-contacts";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// bind form data
		Contact theContact = new Contact();
		
		theModel.addAttribute("contact", theContact);
		
		return "contacts/contact-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("contactId") int theId,
									Model theModel) {
		
		// get the contact
		Contact theContact = contactService.findById(theId);
		
		// pre-populate form
		theModel.addAttribute("contact", theContact);
		
		return "contacts/contact-form";			
	}
	
	@PostMapping("/save")
	public String saveContact(@ModelAttribute("contact") Contact theContact) {
		
		contactService.save(theContact);
		
		return "redirect:/contacts/list";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("contactId") int theId) {
		
		contactService.deleteById(theId);
	
		return "redirect:/contacts/list";		
	}
}


















