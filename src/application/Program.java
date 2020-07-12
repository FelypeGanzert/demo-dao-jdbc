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
		Department dep = new Department(2, null);
		list = sellerDao.findByDepartment(dep);
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
		
		System.out.println("\n===== TEST 4: seller insert");
		Seller newSeller = new Seller(null, "Joana", "joana@gmail.com", new Date(), 6000.0, dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n===== TEST 5: seller update =====");
		seller = sellerDao.findById(1);
		seller.setName("Matha Waine");
		sellerDao.update(seller);
		System.out.println("Update completed");
	}
}
