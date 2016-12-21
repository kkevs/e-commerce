package test;

import dao.UserDaoImpl;
import model.User;

public class Main {

	public static void main(String[] args) {

		UserDaoImpl daoImlp = new UserDaoImpl();

		User user = new User("kevser", "kose", "kkevs", "123");

		daoImlp.saveUser(user);

		// Category category = new Category("saat");

		//
		// Product product = new Product("kol saati", 5, 12.22, "mavi",
		// category);
		//
		// ProductDaoImlp productDaoImlp = new ProductDaoImlp();
		//
		// productDaoImlp.addProduct(product);

	}

}
