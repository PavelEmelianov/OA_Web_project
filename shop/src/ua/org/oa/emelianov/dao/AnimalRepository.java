package ua.org.oa.emelianov.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ua.org.oa.emelianov.entity.Animal;

import java.util.List;

public class AnimalRepository {

    private final SessionFactory sessionFactory;

    public AnimalRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Animal create(Animal item){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        return item;
    }

    public void update(Animal item){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(item);
        session.getTransaction().commit();
    }

    public void delete(Animal item){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(item);
        session.getTransaction().commit();
    }

    public List<Animal> findAll(){
    	
    	Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("FROM Animal");
		List<Animal> result = query.list();

		session.getTransaction().commit();
		return result;
		
    }
}
