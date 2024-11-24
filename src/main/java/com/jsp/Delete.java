package com.jsp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Delete {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Query q = em.createQuery("select b from Boy b");
		List<Boy> listofboy = q.getResultList();
		if (!listofboy.isEmpty()) {
			et.begin();
			for (Boy b : listofboy) {
				Girl g = b.getGirl();
				if (g != null && g.getId() == 1) {
					b.setGirl(null);
					em.remove(g);
				}

			}
			et.commit();
		}
	}

}
