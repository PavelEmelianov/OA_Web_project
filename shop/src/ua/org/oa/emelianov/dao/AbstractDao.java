package ua.org.oa.emelianov.dao;

import java.sql.SQLException;
import java.util.List;

import ua.org.oa.emelianov.entity.Animal;
import ua.org.oa.emelianov.entity.Tools;

public interface AbstractDao<T> {

	List<T> getAll();

	List<T> getAll(long id);

	T findById(int id);

	T create(T item) throws SQLException;

	T update(T item);

	T delete(T item);
}
