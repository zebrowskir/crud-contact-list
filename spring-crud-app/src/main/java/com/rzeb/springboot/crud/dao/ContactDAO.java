package com.rzeb.springboot.crud.dao;

import java.util.List;

import com.rzeb.springboot.crud.entity.Contact;

public interface ContactDAO{

		
	public List<Contact> findAll();
	
	public Contact findById(int theId);
	
	public void save(Contact theCustomer);
	
	public void deleteById(int theId);
}
