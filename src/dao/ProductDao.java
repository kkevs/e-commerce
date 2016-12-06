package dao;

import java.util.List;

import model.Product;

public interface ProductDao {
	public void updateProduct(Product product);

	public void deleteProduct(Product product);

	public List<Product> allProduct();

	public void addProduct(Product product);
}
