package ua.org.oa.emelianov.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ua.org.oa.emelianov.entity.Food;
import ua.org.oa.emelianov.entity.Tools;

public class ToolsRepository {

	
	  private final SessionFactory sessionFactory;

	    public ToolsRepository(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
	    
		public Tools create(Tools item) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(item);
			session.getTransaction().commit();
			return item;
		}

		public void update(Tools item) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(item);
			session.getTransaction().commit();
		}

		public void delete(Tools item) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(item);
			session.getTransaction().commit();
		}

		public List<Tools> findAllByAnimalId(int animalId) {

			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.createQuery("FROM Tools where animals_id = :id");
			query.setParameter("id", animalId);
			List<Tools> result = query.list();
			session.getTransaction().commit();
			return result;

		}

		public Tools findById(int id) {

			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.createQuery("FROM Tools where id = :id");
			query.setParameter("id", id);
			return (Tools) query.uniqueResult();

		}
}
