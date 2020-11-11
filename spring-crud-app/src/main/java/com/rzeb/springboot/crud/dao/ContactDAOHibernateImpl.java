package com.rzeb.springboot.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rzeb.springboot.crud.entity.Contact;

@Repository
public class ContactDAOHibernateImpl implements ContactDAO {

	
	private EntityManager entityManager;
	
	//constructor injection
	@Autowired
	public ContactDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}	
	
	
	@Override
	public List<Contact> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Contact> theQuery = currentSession.createQuery("from Contact", Contact.class);
		
		List<Contact> Contacts = theQuery.getResultList();
		
		return Contacts;
	}

	@Override
	public Contact findById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Contact theContact = currentSession.get(Contact.class, theId);
		
		return theContact;
	}

	@Override
	public void save(Contact theContact) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theContact);		
	}
	
	@Override
	public void deleteById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("delete from Contact where id=:ContactId");
		
		theQuery.setParameter("ContactId", theId);
		
		theQuery.executeUpdate();
		
	}
	
}
