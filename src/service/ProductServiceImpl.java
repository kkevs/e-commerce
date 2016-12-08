package service;

import java.util.List;

import dao.ProductDaoImpl;
import model.Category;
import model.Product;

public class ProductServiceImpl implements ProductService {
	ProductDaoImpl daoImpl = new ProductDaoImpl();

	@Override
	public List<Category> getAllCategories() {
		return daoImpl.getAllCategory();
	}

	@Override
	public void saveProduct(Product product) {
		daoImpl.saveProduct(product);
	}

	@Override
	public List<Product> getAllProduct() {
		return daoImpl.getAllProduct();
	}

	public Category getCategoryById(int id) {
		return daoImpl.getCategoryById(id);
	}

}
