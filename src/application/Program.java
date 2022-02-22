package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDAO sellerDao = DaoFactory.createSellerDAO();
		System.out.println("----- TEST 1: seller findById -----");
		Seller seller = sellerDao.findByID(2);
		System.out.println(seller);
		
		System.out.println("----- TEST 2: seller findByDepartment -----");
		Department dep = new Department(2, "");
		List<Seller> sellerList = sellerDao.findByDepartment(dep);
		for(Seller obj : sellerList) {
			System.out.println(obj);
		}
		
		System.out.println("----- TEST 3: seller findAll -------");
		sellerList = sellerDao.findAll();
		for(Seller obj : sellerList) {
			System.out.println(obj);
		}
		System.out.println("----- TEST 4: seller insert -------");
		Seller newSeller = new Seller(null, "Maju", "majulinda@bbb.com", new Date(), 8000.0, dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! new id = " + newSeller.getId());
	}

}
