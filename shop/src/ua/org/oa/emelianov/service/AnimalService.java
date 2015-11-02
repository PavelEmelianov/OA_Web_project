package ua.org.oa.emelianov.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import ua.org.oa.emelianov.dao.DaoFacade;
import ua.org.oa.emelianov.dao.StorageRepositories;
import ua.org.oa.emelianov.entity.Animal;


@Controller
@RequestMapping("/animals")
public class AnimalService {

	@RequestMapping(produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody List<Animal> getAll() {
		
		StorageRepositories storage = StorageRepositories.getInstance();
		List<Animal> animalList = storage.getAnimalRepository().findAll();
		return animalList;
		
	}

	@RequestMapping(produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	public @ResponseBody Animal add(@RequestBody Animal animal) throws SQLException {
		
		StorageRepositories storage = StorageRepositories.getInstance();
		Animal newAnimal = storage.getAnimalRepository().create(animal);
		return newAnimal;
	}

	@RequestMapping(produces = "application/json", consumes = "application/json", method = RequestMethod.DELETE)
	public @ResponseBody Animal delete(@RequestBody Animal animal) {

		StorageRepositories storage = StorageRepositories.getInstance();
		storage.getAnimalRepository().delete(animal);
		return animal;
		
	}

	@RequestMapping(produces = "application/json", consumes = "application/json", method = RequestMethod.PUT)
	public @ResponseBody Animal update(@RequestBody Animal animal) {

		StorageRepositories storage = StorageRepositories.getInstance();
		storage.getAnimalRepository().update(animal);
		return animal;
		
	}
}
