package ua.org.oa.emelianov.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ua.org.oa.emelianov.entity.Animal;

public class AnimalsDao implements AbstractDao<Animal> {

	private Connection con;
	private Statement stmt;

	private static final String TABLE_NAME = "ANIMALS";
	private static final String ID = "ID";
	private static final String ANIMAL_NAME = "ANIMAL_NAME";
	private static final String ANIMAL_PRICE = "ANIMAL_PRICE";

	public AnimalsDao(Connection con, Statement stmt) {
		this.con = con;
		this.stmt = stmt;
	}

	@Override
	public List<Animal> getAll() {
		List<Animal> animals = new ArrayList<Animal>();
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery("SELECT * FROM " + TABLE_NAME);
			while (rs.next()) {
				Animal animal = new Animal();
				animal.setId(rs.getInt(ID));
				animal.setAnimal_name(rs.getString(ANIMAL_NAME));
				animal.setAnimal_price(rs.getInt(ANIMAL_PRICE));
				animals.add(animal);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return animals;
	}

	@Override
	public Animal findById(int id) {
		Animal animal = new Animal();
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery("SELECT * FROM " + TABLE_NAME + " WHERE ID=" + id);
			while (rs.next()) {
				animal.setId(rs.getInt(ID));
				animal.setAnimal_name(rs.getString(ANIMAL_NAME));
				animal.setAnimal_price(rs.getInt(ANIMAL_PRICE));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return animal;
	}

	@Override
	public Animal create(Animal item) throws SQLException {
		stmt.executeUpdate("INSERT INTO " + TABLE_NAME + " VALUES (default,'" + item.getAnimal_name() + "',"
				+ item.getAnimal_price() + ")");
		return item;
	}

	@Override
	public Animal update(Animal item) {
		try {
			stmt.executeUpdate("UPDATE " + TABLE_NAME + " SET " + ANIMAL_NAME + "='" + item.getAnimal_name() + "', "
					+ ANIMAL_PRICE + "=" + item.getAnimal_price() + " WHERE " + ID + "=" + item.getId());
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Animal newAnimal = findById(item.getId());
		return newAnimal;
	}

	@Override
	public Animal delete(Animal item) {
		Animal newAnimal = findById(item.getId());
		try {
			stmt.executeUpdate("DELETE FROM " + TABLE_NAME + " WHERE " + ID + "=" + item.getId());
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newAnimal;
	}

	@Override
	public List<Animal> getAll(long id) {
		return null;
	}
}
