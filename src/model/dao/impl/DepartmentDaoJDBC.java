package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartmentDAO;
import model.entities.Department;
import model.entities.Seller;

public class DepartmentDaoJDBC implements DepartmentDAO{
	
	private Connection conn;
	
	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Department obj) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("insert into department" + "(Id, Name) "
					+ "values " + "(?, ?)", Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, obj.getId());
			st.setString(2, obj.getName());
			int rows = st.executeUpdate();
			if (rows > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSets(rs);
			} else {
				throw new DbException("Unexpected error! No rows affected ");
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatements(st);

		}
		
	}

	@Override
	public void update(Department obj) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("UPDATE department "
					+ "SET Name = ? " + "WHERE Id = ? ",
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getName());
			st.setInt(2, obj.getId() );
			st.executeUpdate();
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatements(st);

		}
		
	}

	@Override
	public void deleteByID(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Department findByID(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * from department where id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Department dep = instantiateDepartment(rs);
				return dep;
			}
			return null;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatements(st);
			DB.closeResultSets(rs);
		}

	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("Id"));
		dep.setName(rs.getString("Name"));
		return dep;
	}

}
