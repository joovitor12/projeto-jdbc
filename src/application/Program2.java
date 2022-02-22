package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDAO;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		SellerDAO sellerDao = DaoFactory.createSellerDAO();
		DepartmentDAO depDao = DaoFactory.createDepartmentDAO();
		
		System.out.println("----- TEST 1: department findById -----");
		Department department = depDao.findByID(14);
		System.out.println(department);
		
		
		System.out.println("----- TEST 2: department findAll -------");
		List<Department> depList = depDao.findAll();
		for(Department obj : depList) {
			System.out.println(obj);
		}
		
		/*
		System.out.println("----- TEST 3: department insert -------");
		Department newDepartment = new Department(19, "HQs");
		depDao.insert(newDepartment);
		System.out.println("Inserted! new id = " + newDepartment.getId());
		*/
		
		System.out.println("----- TEST 4: department update -------");
		department.setName("Swords");
		depDao.update(department);
		System.out.println("Update completed");
		
		
		
		System.out.println("----- TEST 5: department delete -------");
		int id = in.nextInt();
		depDao.deleteByID(id);
		System.out.println(id + " has been deleted!");
		in.close();
		
	}

}
