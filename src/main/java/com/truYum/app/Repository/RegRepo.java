package com.truYum.app.Repository;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.truYum.app.persitant.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class RegRepo {
	@Autowired
	private EntityManager em;
	private Logger logger = LoggerFactory.getLogger(Customer.class);
	@Transactional
	public String doRegistration(String name,String userName,String password,String location,String contactNo) {
		String jpqlQuery = "select d from Customer d";
		TypedQuery<Customer> query =em.createQuery(jpqlQuery,Customer.class);
		List<Customer> customers = query.getResultList();
		for(Customer cust:customers) {
			if(cust.getUserId().equals(userName)) {
				return "User Name already exist";
			}
		}
		Customer cust = new Customer(name,userName,password,location,contactNo);
		em.persist(cust);
		logger.info("We have saved succesfully : "+cust);
		return "User is registred";
		
	}
}
