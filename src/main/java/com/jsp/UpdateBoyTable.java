package com.jsp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UpdateBoyTable {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Query q = em.createQuery("select b from Boy b");
		List<Boy> listofboy = q.getResultList();
		if (!listofboy.isEmpty()) {

			Girl g = em.find(Girl.class, 1);
			
			et.begin();
			
			for (Boy b : listofboy) {
				if (b.getId() == 103) {
					Girl girl = b.getGirl();
					if (girl == null) {
						// mapping
						b.setGirl(g);
						em.merge(g);
						System.out.println("boy record updated");

					} else {
						Girl g1 = em.find(Girl.class, 2);
						if(g1!=null) {
							// mapping
							b.setGirl(g);
							em.merge(g);
							System.out.println("boy record updated");
							
						}else {
							System.out.println("particular girl record not found");
						}

					}
				}
				
			}
			et.commit();
		}
	}

}
