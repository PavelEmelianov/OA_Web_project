package ua.org.oa.emelianov.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.org.oa.emelianov.entity.Food;

public class FoodRepository {

	private final SessionFactory sessionFactory;

	public FoodRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Food create(Food item) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(item);
		session.getTransaction().commit();
		return item;
	}

	public void update(Food item) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(item);
		session.getTransaction().commit();
	}

	public void delete(Food item) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(item);
		session.getTransaction().commit();
	}

	public List<Food> findAllByAnimalId(int animalId) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM Food where animals_id = :id");
		query.setParameter("id", animalId);
		List<Food> result = query.list();
		session.getTransaction().commit();
		return result;

	}

	public Food findById(int id) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM Food where id = :id");
		query.setParameter("id", id);
		return (Food) query.uniqueResult();

	}

}
