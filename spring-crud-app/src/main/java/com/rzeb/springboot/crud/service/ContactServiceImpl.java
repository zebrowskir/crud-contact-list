package com.rzeb.springboot.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rzeb.springboot.crud.dao.ContactDAO;
import com.rzeb.springboot.crud.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	private ContactDAO contactDAO;
	
	@Autowired
	public ContactServiceImpl(ContactDAO theContactDAO) {
		contactDAO = theContactDAO;
	}
	
	@Override
	@Transactional
	public List<Contact> findAll() {
		return contactDAO.findAll();
	}

	@Override
	@Transactional
	public Contact findById(int theId) {
		return contactDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Contact theContact) {
		contactDAO.save(theContact);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		contactDAO.deleteById(theId);
	}

}






