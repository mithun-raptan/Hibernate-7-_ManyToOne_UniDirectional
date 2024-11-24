package com.jsp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAll {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery("select b from Boy b");
		List<Boy> listofboy = q.getResultList();
		if (!listofboy.isEmpty()) {
			for (Boy boy : listofboy) {
				System.out.println("boy details");
				System.out.println(boy.getName() + " " + boy.getEmail() + " " + boy.getMob() + " " + boy.getEx());
				System.out.println("girl details");
				Girl g = boy.getGirl();
				System.out.println(g.getName()+" "+g.getInstaid());
			}
		}

	}

}
