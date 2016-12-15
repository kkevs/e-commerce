package service;

import java.util.List;

import org.primefaces.event.RowEditEvent;

import model.Category;
import model.Product;

public interface ProductService {
	public List<Category> getAllCategories();

	public void saveProduct(Product product);

	public List<Product> getAllProduct();

	public Category getCategoryById(int id);

	public void deleteProduct(Product selectedProduct);

	public void updateProduct(RowEditEvent event);
}
