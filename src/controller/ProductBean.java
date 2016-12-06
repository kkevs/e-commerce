package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import dao.ProductDaoImlp;
import model.Category;
import model.Product;

@ManagedBean
public class ProductBean {
	private String formPath;
	private Category category = new Category();

	ProductDaoImlp daoImlp = new ProductDaoImlp();
	Product product = new Product();

	List<Product> list;

	public ProductBean() {
		formPath = "home.xhtml";

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

	public void addProduct() {
		daoImlp.addProduct(product);
	}

}
