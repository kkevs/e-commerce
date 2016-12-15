package dao;

import java.util.List;

import org.primefaces.event.RowEditEvent;

import model.Category;
import model.Product;

public interface ProductDao {
	public void updateProduct(RowEditEvent event);

	public void deleteProduct(Product product);

	public List<Product> getAllProduct();

	public void saveProduct(Product product);
	//
	// public List<Product> getByCategory(Category category);
	//
	public List<Category> getAllCategory();
	
	public Category getCategoryById(int id);
}

