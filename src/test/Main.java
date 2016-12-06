package test;

import dao.ProductDaoImlp;
import dao.UserDaoImlp;
import model.Category;
import model.Product;
import model.User;

public class Main {

	public static void main(String[] args) {

		UserDaoImlp daoImlp = new UserDaoImlp();

		User user = new User("kevser", "kose", "kkevs", "123");

		daoImlp.saveUser(user);

		Category category = new Category("saat");

		Product product = new Product("kol saati", 5, 12.22, "mavi", category);

		ProductDaoImlp productDaoImlp = new ProductDaoImlp();

		productDaoImlp.addProduct(product);

	}

}
