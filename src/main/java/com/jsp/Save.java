package com.jsp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Save {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em  = emf.createEntityManager();
		EntityTransaction et  = em.getTransaction();
		
		//create Girl object
		Girl g = new Girl();
		g.setId(1);
		g.setName("sunny");
		g.setInstaid("sun@69");
		
		//create Boy object
		Boy b1 = new Boy();
		b1.setId(101);
		b1.setName("tapan");
		b1.setEmail("t@g.com");
		b1.setPassword("1234");
		b1.setMob(6291l);
		b1.setEx("lapata");
		//mapping
		b1.setGirl(g);
		
		Boy b2 = new Boy();
		b2.setId(102);
		b2.setName("rakesh");
		b2.setEmail("r@g.com");
		b2.setPassword("5678");
		b2.setMob(8420l);
		b2.setEx("ranu");
		//mapping
		b2.setGirl(g);
		
		//save into DB
		et.begin();
		em.persist(g);
		em.persist(b1);
		em.persist(b2);
		et.commit();
		System.out.println("boy and girl object saved successfully in DB ");
		
	}

}
