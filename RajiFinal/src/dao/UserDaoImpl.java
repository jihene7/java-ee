package dao;


import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import entites.User;

import util.JPAutil;

public class UserDaoImpl implements IUserDao {
 // TP6_JEE � replacer par votre persistence unit, consultez votre
//fichier persistence.xml <persistence-unit name="TP6_JEE">
	private EntityManager entityManager=JPAutil.getEntityManager("RajiFinal");

	@Override
	public User save(User cat ) {
		EntityTransaction tx = entityManager.getTransaction();
	 	tx.begin();
	 		entityManager.persist(cat);
	 	tx.commit();
	 	
		return cat;
	}

	@Override
	public User getUser(int id) {
     	return entityManager.find(User.class, id);
	}

	@Override
	public User updateUser(User cat) {
		EntityTransaction tx = entityManager.getTransaction();
	 	tx.begin();
	 	entityManager.merge(cat);
	 	tx.commit();
		return cat;
	}

	@Override
	public void deleteUser(int id) {
		User User = entityManager.find(User.class, id);

		 entityManager.getTransaction().begin();
		 entityManager.remove(User);
		 entityManager.getTransaction().commit();
		
	}

	@Override
	public List<User> getAllUsers() {
		List<User> cats =
 entityManager.createQuery("select c from User c where c.role ='enseignant'").getResultList();
 
	return cats;
	}

}

