package ua.org.oa.emelianov.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StorageRepositories {
	
	private static class Holder {
		private static final StorageRepositories INSTANCE = new StorageRepositories();
	}

	public static StorageRepositories getInstance() {
		return Holder.INSTANCE;
	}

    private AnimalRepository animalRepository;
    private FoodRepository foodRepository;
    private ToolsRepository toolsRepository;


	public StorageRepositories() {
        SessionFactory sessionFactory;
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        this.animalRepository = new AnimalRepository(sessionFactory);
        this.foodRepository = new FoodRepository(sessionFactory);
        this.toolsRepository = new ToolsRepository(sessionFactory);
    }

	
    public AnimalRepository getAnimalRepository() {
        return animalRepository;
    }
    
    public FoodRepository getFoodRepository() {
    	return foodRepository;
    }
    
    public ToolsRepository getToolsRepository() {
    	return toolsRepository;
    }
    
}
