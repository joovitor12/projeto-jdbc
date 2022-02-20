package model.dao;

import db.DB;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
		public static SellerDAO createSellerDAO() {
			return new SellerDaoJDBC(DB.getConnection());
		}
}
