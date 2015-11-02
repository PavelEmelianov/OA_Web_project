package ua.org.oa.emelianov.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.org.oa.emelianov.dao.StorageRepositories;
import ua.org.oa.emelianov.entity.Food;

@Controller
@RequestMapping("/food")
public class FoodService {

	@RequestMapping(value = "{id}", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody List<Food> getAll(@PathVariable("id") int id) {

		StorageRepositories storage = StorageRepositories.getInstance();
		List<Food> foodList = storage.getFoodRepository().findAllByAnimalId(id);
		return foodList;

	}

	@RequestMapping(produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	public @ResponseBody Food add(@RequestBody Food food) throws SQLException {
		
		StorageRepositories storage = StorageRepositories.getInstance();
		Food newFood = storage.getFoodRepository().create(food);
		return newFood;
	}

	@RequestMapping(produces = "application/json", consumes = "application/json", method = RequestMethod.DELETE)
	public @ResponseBody Food delete(@RequestBody Food food) {

		StorageRepositories storage = StorageRepositories.getInstance();
		storage.getFoodRepository().delete(food);
		return food;
		
	}

	@RequestMapping(produces = "application/json", consumes = "application/json", method = RequestMethod.PUT)
	public @ResponseBody Food update(@RequestBody Food food) {

		StorageRepositories storage = StorageRepositories.getInstance();
		storage.getFoodRepository().update(food);
		return food;
		
	}

}
