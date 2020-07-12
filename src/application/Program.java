package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entites.Department;
import model.entites.Seller;

public class Program {
	
	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n===== TEST 2: seller findByDepartment");
		List<Seller> list = new ArrayList<>();
		list = sellerDao.findByDepartment(new Department(2, null));
		//list.get(0).getDepartment().setName("Changed");
		for(Seller s : list) {
			System.out.println(s);
		}
		
		System.out.println("\n===== TEST 3: seller findAll");
		List<Seller> list2 = new ArrayList<>();
		list2 = sellerDao.findAll();
		for(Seller s : list2) {
			System.out.println(s);
		}
		
	}
}
