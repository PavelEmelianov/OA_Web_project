package ua.org.oa.emelianov.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ua.org.oa.emelianov.dao.StorageRepositories;
import ua.org.oa.emelianov.entity.Tools;

@Controller
@RequestMapping("/tools")
public class ToolsService {
	
	@RequestMapping(value = "{id}", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody List<Tools> getAll(@PathVariable("id") int id) {

		StorageRepositories storage = StorageRepositories.getInstance();
		List<Tools> toolsList = storage.getToolsRepository().findAllByAnimalId(id);
		return toolsList;

	}

	@RequestMapping(produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	public @ResponseBody Tools add(@RequestBody Tools tool) throws SQLException {
		
		StorageRepositories storage = StorageRepositories.getInstance();
		Tools newTool = storage.getToolsRepository().create(tool);
		return newTool;
	}

	@RequestMapping(produces = "application/json", consumes = "application/json", method = RequestMethod.DELETE)
	public @ResponseBody Tools delete(@RequestBody Tools tool) {

		StorageRepositories storage = StorageRepositories.getInstance();
		storage.getToolsRepository().delete(tool);
		return tool;
		
	}

	@RequestMapping(produces = "application/json", consumes = "application/json", method = RequestMethod.PUT)
	public @ResponseBody Tools update(@RequestBody Tools tool) {

		StorageRepositories storage = StorageRepositories.getInstance();
		storage.getToolsRepository().update(tool);
		return tool;
		
	}

}
