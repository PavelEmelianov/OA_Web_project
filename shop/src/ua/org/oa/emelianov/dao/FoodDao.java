package ua.org.oa.emelianov.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.org.oa.emelianov.entity.Food;

public class FoodDao implements AbstractDao<Food> {
	
	private Connection con;
	private Statement stmt;

	private static final String TABLE_NAME = "FOOD";
	private static final String ID = "ID";
	private static final String FOOD_NAME = "food_name";
	private static final String FOOD_ORIGIN = "food_origin";
	private static final String FOOD_PRICE = "food_price";
	private static final String ANIMALS_ID = "animals_id";

	public FoodDao(Connection con, Statement stmt) {
		this.con = con;
		this.stmt = stmt;
	}

	@Override
	public List<Food> getAll(long id) {
		List<Food> foods = new ArrayList<Food>();
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM "+TABLE_NAME+" WHERE " + ANIMALS_ID + "=" + id);
			while (rs.next()) {
				Food food = new Food();
				food.setId(rs.getInt(ID));
				food.setFood_name(rs.getString(FOOD_NAME));
				food.setFood_origin(rs.getString(FOOD_ORIGIN));
				food.setFood_price(rs.getInt(FOOD_PRICE));
				food.setAnimals_id(rs.getInt(ANIMALS_ID));
				foods.add(food);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return foods;

	}

	@Override
	public List<Food> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Food findById(int id) {
		Food food = new Food();
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery("SELECT * FROM " + TABLE_NAME + " WHERE ID=" + id);
			while (rs.next()) {
				food.setId(rs.getInt(ID));
				food.setFood_name(rs.getString(FOOD_NAME));
				food.setFood_origin(rs.getString(FOOD_ORIGIN));
				food.setFood_price(rs.getInt(FOOD_PRICE));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return food;
	}

	@Override
	public Food create(Food item) throws SQLException {
		stmt.executeUpdate(
				"INSERT INTO " + TABLE_NAME + " VALUES(DEFAULT,'" + item.getFood_name() + "','" + item.getFood_origin()
						+ "',"  + item.getFood_price() + "," + item.getAnimals_id() + ")");
		return item;
	}

	@Override
	public Food update(Food item) {
		try {
			stmt.executeUpdate("UPDATE " + TABLE_NAME + " SET " + FOOD_NAME + "='" + item.getFood_name() + "', "
					+ FOOD_ORIGIN + "='" + item.getFood_origin() + "', "
							
									+ FOOD_PRICE + "=" + item.getFood_price() + " WHERE " + ID + "=" + item.getId());
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Food newFood = findById(item.getId());
		return newFood;
	}

	@Override
	public Food delete(Food item) {
		Food newFood = findById(item.getId());
		try {
			stmt.executeUpdate("DELETE FROM " + TABLE_NAME + " WHERE " + ID + "=" + item.getId());
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newFood;
	}

}
