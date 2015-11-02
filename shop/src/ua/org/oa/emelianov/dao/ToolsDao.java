package ua.org.oa.emelianov.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import ua.org.oa.emelianov.entity.Animal;
import ua.org.oa.emelianov.entity.Tools;

public class ToolsDao implements AbstractDao<Tools> {
	

	private Connection con;
	private Statement stmt;

	private static final String TABLE_NAME = "TOOLS";

	private static final String ID = "ID";
	private static final String TOOL_NAME = "tool_name";
	private static final String TOOL_ORIGIN = "tool_origin";
	private static final String TOOL_WEIGHT = "tool_weight";
	private static final String TOOL_PRICE = "tool_price";
	private static final String ANIMALS_ID = "animals_id";

	public ToolsDao(Connection con, Statement stmt) {
		this.con = con;
		this.stmt = stmt;
	}

	@Override
	public List<Tools> getAll(long id) {
		List<Tools> tools = new ArrayList<Tools>();
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM TOOLS WHERE " + ANIMALS_ID + "=" + id);
			while (rs.next()) {
				Tools tool = new Tools();
				tool.setId(rs.getInt(ID));
				tool.setTool_name(rs.getString(TOOL_NAME));
				tool.setTool_origin(rs.getString(TOOL_ORIGIN));
				tool.setTool_weight(rs.getInt(TOOL_WEIGHT));
				tool.setTool_price(rs.getInt(TOOL_PRICE));
				tool.setAnimals_id(rs.getInt(ANIMALS_ID));
				tools.add(tool);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tools;

	}

	@Override
	public List<Tools> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tools findById(int id) {
		Tools tool = new Tools();
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery("SELECT * FROM " + TABLE_NAME + " WHERE ID=" + id);
			while (rs.next()) {
				tool.setId(rs.getInt(ID));
				tool.setTool_name(rs.getString(TOOL_NAME));
				tool.setTool_origin(rs.getString(TOOL_ORIGIN));
				tool.setTool_weight(rs.getInt(TOOL_WEIGHT));
				tool.setTool_price(rs.getInt(TOOL_PRICE));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tool;
	}

	@Override
	public Tools create(Tools item) throws SQLException {
		stmt.executeUpdate(
				"INSERT INTO " + TABLE_NAME + " VALUES(DEFAULT,'" + item.getTool_name() + "','" + item.getTool_origin()
						+ "'," + item.getTool_weight() + "," + item.getTool_price() + "," + item.getAnimals_id() + ")");
		return item;
	}

	@Override
	public Tools update(Tools item) {
		try {
			stmt.executeUpdate("UPDATE " + TABLE_NAME + " SET " + TOOL_NAME + "='" + item.getTool_name() + "', "
					+ TOOL_ORIGIN + "='" + item.getTool_origin() + "', "
							+ TOOL_WEIGHT + "=" + item.getTool_weight() + ", "
									+ TOOL_PRICE + "=" + item.getTool_price() + " WHERE " + ID + "=" + item.getId());
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Tools newTool = findById(item.getId());
		return newTool;
	}

	@Override
	public Tools delete(Tools item) {
		Tools newTool = findById(item.getId());
		try {
			stmt.executeUpdate("DELETE FROM " + TABLE_NAME + " WHERE " + ID + "=" + item.getId());
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newTool;
	}

}
