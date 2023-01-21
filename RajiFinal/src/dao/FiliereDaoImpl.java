package dao;


import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import entites.Filiere;

import util.JPAutil;

public class FiliereDaoImpl implements IFiliereDao {
 // TP6_JEE � replacer par votre persistence unit, consultez votre
//fichier persistence.xml <persistence-unit name="TP6_JEE">
	private EntityManager entityManager=JPAutil.getEntityManager("RajiFinal");

	@Override
	public Filiere save(Filiere cat ) {
		EntityTransaction tx = entityManager.getTransaction();
	 	tx.begin();
	 		entityManager.persist(cat);
	 	tx.commit();
	 	
		return cat;
	}

	@Override
	public Filiere getFiliere(Long id) {
     	return entityManager.find(Filiere.class, id);
	}

	@Override
	public Filiere updateFiliere(Filiere cat) {
		EntityTransaction tx = entityManager.getTransaction();
	 	tx.begin();
	 	entityManager.merge(cat);
	 	tx.commit();
		return cat;
	}

	@Override
	public void deleteFiliere(Long id) {
		Filiere Filiere = entityManager.find(Filiere.class, id);

		 entityManager.getTransaction().begin();
		 entityManager.remove(Filiere);
		 entityManager.getTransaction().commit();
		
	}

	@Override
	public List<Filiere> getAllFilieres() {
		List<Filiere> cats =
 entityManager.createQuery("select c from Filiere c").getResultList();
 
	return cats;
	}

}
