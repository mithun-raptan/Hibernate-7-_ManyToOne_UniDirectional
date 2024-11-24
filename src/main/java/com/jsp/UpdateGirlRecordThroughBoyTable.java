  package com.jsp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UpdateGirlRecordThroughBoyTable {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Query q = em.createQuery("select b from Boy b");
		List<Boy> listofboy =q.getResultList();
		if(!listofboy.isEmpty()) {
			for(Boy b:listofboy) {
				if(b.getGirl().getId()==1) { 
					et.begin();
					b.getGirl().setName("mia");
					em.merge(b.getGirl());
					et.commit();
					break;
				}
			}
		}
			
			
			
			
			
			
//		Boy b = em.find(Boy.class, 101);
//		if(b!=null) {
//			Girl g =b.getGirl();
//			if(g!=null) {
//				et.begin();
//				g.setName("nora");
//				em.merge(g);
//				et.commit();
//			}
//		}
	}

}
