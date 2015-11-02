package ua.org.oa.emelianov.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ua.org.oa.emelianov.entity.Animal;

public class DaoFacade {

	private Connection con;
	private Statement stmt;

	private AnimalsDao animalsDao;
	private ToolsDao toolsDao;
	private FoodDao foodDao;

	public FoodDao getFoodDao() {
		return foodDao;
	}

	public void setFoodDao(FoodDao foodDao) {
		this.foodDao = foodDao;
	}

	public ToolsDao getToolsDao() {
		return toolsDao;
	}

	public void setToolsDao(ToolsDao toolsDao) {
		this.toolsDao = toolsDao;
	}

	public AnimalsDao getAnimalsDao() {
		return animalsDao;
	}

	public void setAnimalsDao(AnimalsDao animalsDao) {
		this.animalsDao = animalsDao;
	}

	public DaoFacade() {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			con = DriverManager
					.getConnection("jdbc:derby://localhost:1527/Zoo_shop;create=true;user=pavel;password=emelianov");
			stmt = con.createStatement();
			animalsDao = new AnimalsDao(con, stmt);
			toolsDao = new ToolsDao(con, stmt);
			foodDao= new FoodDao(con, stmt);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
