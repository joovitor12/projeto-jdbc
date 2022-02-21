package application;

import model.dao.DaoFactory;
import model.dao.SellerDAO;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDAO sellerDao = DaoFactory.createSellerDAO();
		System.out.println("----- TEST 1: seller findById -----");
		Seller seller = sellerDao.findByID(2);
		System.out.println(seller);

	}

}
