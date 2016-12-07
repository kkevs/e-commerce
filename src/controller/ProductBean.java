package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import dao.ProductDaoImpl;
import model.Category;
import model.Product;

@ManagedBean
public class ProductBean {
	private String formPath;

	private Category category = new Category();
	Product product = new Product();
	ProductDaoImpl daoImlp = new ProductDaoImpl();

	List<Category> categories = new ArrayList<Category>();
	List<Product> list;

	public ProductBean() {
		formPath = "home.xhtml";
		categories = daoImlp.allCategory();
	}

	public void chooseCategory(int categoryId) {

		formPath = "product.xhtml";
		list = new ArrayList<Product>();
		list = daoImlp.allProduct();

		switch (categoryId) {
		case 3:
			formPath = "home.xhtml";
			break;
		case 4:
			formPath = "login.xhtml";

		}
	}

	public List<Product> getList() {
		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}

	public String getFormPath() {
		return formPath;
	}

	public void setFormPath(String formPath) {
		this.formPath = formPath;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public void addProduct() {
		System.out.println("deneme..");
		System.out.println(category.getName());
		// product.setCategory(category);
		// daoImlp.addProduct(product);
	}

}
