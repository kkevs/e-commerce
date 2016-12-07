package dao;

import java.util.List;

import model.Category;
import model.Product;

public interface ProductDao {
	public void updateProduct(Product product);

	public void deleteProduct(Product product);

	public List<Product> allProduct();

	public void addProduct(Product product);

	public List<Product> getByCategory(Category category);

	public List<Category> allCategory();
}
