package model.dao;

import java.util.List;

import model.entities.Department;
import model.entities.Seller;

public interface SellerDAO {
	void insert(Seller obj);
	void update(Seller obj);
	void deleteByID(Integer id);
	Seller findByID(Integer id);
	List<Seller> findAll();
	List<Seller> findByDepartment(Department dep);
}
