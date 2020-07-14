package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entites.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		Department dp = new Department(null, "MovieTheather");
		System.out.println("\n====== TEST1 - Department insert");
		departmentDao.insert(dp);
		System.out.println("Done! Department Inserted");
		System.out.println(dp);
		
		System.out.println("\n====== TEST2 - Department update");
		dp.setName("Movie Show");
		departmentDao.update(dp);
		System.out.println("Done! Updated.");
		
		System.out.println("\n====== TEST3 - Department Delete");
		System.out.print("Delete department with the id? ");
		int idToDelete = scan.nextInt();
		departmentDao.deleteById(idToDelete);
		System.out.println("Done! Deleted.");
		
		System.out.println("\n====== TEST4 - Department FindById");
		System.out.print("Id to find? ");
		int idToFind = scan.nextInt();
		Department dpFind = departmentDao.findById(idToFind);
		System.out.println("Done! Department with id "+idToFind+": "+dpFind);
		
		System.out.println("\n====== TEST5 - Department FindAll");
		List<Department> departments = null;
		departments = departmentDao.findAll();
		for(Department d : departments) {
			System.out.println(d);
		}

	}
}
