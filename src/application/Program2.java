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
		Department department = depDao.findByID(12);
		System.out.println(department);
		
		
		/*System.out.println("----- TEST 2: seller findByDepartment -----");
		Department dep = new Department(2, "");
		List<Seller> sellerList = sellerDao.findByDepartment(dep);
		for(Seller obj : sellerList) {
			System.out.println(obj);
		}
		*/
		
		/*
		System.out.println("----- TEST 3: seller findAll -------");
		sellerList = sellerDao.findAll();
		for(Seller obj : sellerList) {
			System.out.println(obj);
		}
		*/
		
		System.out.println("----- TEST 4: department insert -------");
		Department newDepartment = new Department(13, "HQs");
		depDao.insert(newDepartment);
		System.out.println("Inserted! new id = " + newDepartment.getId());
		/*
		System.out.println("----- TEST 5: seller update -------");
		seller = sellerDao.findByID(1);
		seller.setName("NewName");
		sellerDao.update(seller);
		System.out.println("Update completed");
		*/
		
		/*
		System.out.println("----- TEST 6: seller delete -------");
		int id = in.nextInt();
		sellerDao.deleteByID(id);
		System.out.println(id + " has been deleted!");
		in.close();
		*/
	}

}
