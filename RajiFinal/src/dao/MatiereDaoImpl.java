package dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entites.Filiere;
import entites.User;
import entites.Matiere;
import util.JPAutil;

public class MatiereDaoImpl implements IMatiereDao {
	private EntityManager entityManager=JPAutil.getEntityManager("RajiFinal");

	@Override
	public Matiere save(Matiere p) {
		EntityTransaction tx = entityManager.getTransaction();
	 	tx.begin();
	 	entityManager.persist(p);
	 	tx.commit();

		return p;
	}

	@Override
	public List<Matiere> matieresParMC(String mc) {
		List<Matiere> mats =
		  entityManager.createQuery("select p from Matiere p where      p.nomMatiere like :mc").setParameter("mc", "%"+mc+"%")
		          .getResultList();			
     return mats;
	}
	@Override
	public List<Matiere> list() {
		List<Matiere> mats =
				 entityManager.createQuery("select p from Matiere p").getResultList();
				 
					return mats;
	}

	@Override
	public Matiere getMatiere(Long id) {
     	return entityManager.find(Matiere.class, id);
	}

	@Override
	public Matiere updateMatiere(Matiere p) {
		EntityTransaction tx = entityManager.getTransaction();
	 	tx.begin();
	 	entityManager.merge(p);
	 	tx.commit();
		return p;
	}

	@Override
	public void deleteMatiere(Long id) {
		Matiere produit = entityManager.find(Matiere.class, id);

		 entityManager.getTransaction().begin();
		 entityManager.remove(produit);
		 entityManager.getTransaction().commit();
		
	}

}
