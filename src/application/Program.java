package application;

import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Department obj = new Department(1, "HQs");
		System.out.println(obj);
		Seller seller = new Seller(33, "John", "j@mail.com", new Date(), 7000.0, obj);
		System.out.println(seller);

	}

}
