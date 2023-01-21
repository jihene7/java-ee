package dao;


import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import entites.Etudiant;

import util.JPAutil;

public class EtudiantDaoImpl implements IEtudiantDao {
 // TP6_JEE � replacer par votre persistence unit, consultez votre
//fichier persistence.xml <persistence-unit name="TP6_JEE">
	private EntityManager entityManager=JPAutil.getEntityManager("RajiFinal");

	@Override
	public Etudiant save(Etudiant cat ) {
		EntityTransaction tx = entityManager.getTransaction();
	 	tx.begin();
	 		entityManager.persist(cat);
	 	tx.commit();
	 	
		return cat;
	}

	@Override
	public Etudiant getEtudiant(Long id) {
     	return entityManager.find(Etudiant.class, id);
	}

	@Override
	public Etudiant updateEtudiant(Etudiant cat) {
		EntityTransaction tx = entityManager.getTransaction();
	 	tx.begin();
	 	entityManager.merge(cat);
	 	tx.commit();
		return cat;
	}

	@Override
	public void deleteEtudiant(Long id) {
		Etudiant Etudiant = entityManager.find(Etudiant.class, id);

		 entityManager.getTransaction().begin();
		 entityManager.remove(Etudiant);
		 entityManager.getTransaction().commit();
		
	}

	@Override
	public List<Etudiant> getAllEtudiant() {
		List<Etudiant> cats =
 entityManager.createQuery("select c from Etudiant c").getResultList();
 
	return cats;
	}

}
