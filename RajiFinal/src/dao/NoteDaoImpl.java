package dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entites.Filiere;
import entites.User;
import entites.Note;
import util.JPAutil;

public class NoteDaoImpl implements INoteDao {
	private EntityManager entityManager=JPAutil.getEntityManager("RajiFinal");

	@Override
	public Note save(Note p) {
		EntityTransaction tx = entityManager.getTransaction();
	 	tx.begin();
	 	entityManager.persist(p);
	 	tx.commit();

		return p;
	}

	@Override
	public List<Note> notesParMC(String mc) {
		List<Note> mats =
		  entityManager.createQuery("select p from Note p where      p.noteFinal like :mc").setParameter("mc", "%"+mc+"%")
		          .getResultList();			
     return mats;
	}
	
	@Override
	public List<Note> list() {
		List<Note> mats =
				 entityManager.createQuery("select p from Note p").getResultList();
				 
					return mats;
	}

	@Override
	public Note getNote(Long id) {
     	return entityManager.find(Note.class, id);
	}

	@Override
	public Note updateNote(Note p) {
		EntityTransaction tx = entityManager.getTransaction();
	 	tx.begin();
	 	entityManager.merge(p);
	 	tx.commit();
		return p;
	}

	@Override
	public void deleteNote(Long id) {
		Note produit = entityManager.find(Note.class, id);

		 entityManager.getTransaction().begin();
		 entityManager.remove(produit);
		 entityManager.getTransaction().commit();
		
	}

}
