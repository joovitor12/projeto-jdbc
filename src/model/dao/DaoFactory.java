package model.dao;

import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
		public static SellerDAO createSellerDAO() {
			return new SellerDaoJDBC();
		}
}
