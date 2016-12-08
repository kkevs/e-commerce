package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Category;
import model.Product;
import service.ProductServiceImpl;

@ManagedBean
@SessionScoped
public class ProductBean {
	private String formPath = "home.xhtml";

	private Category category = new Category();
	Product product = new Product();

	List<Category> categories = new ArrayList<Category>();
	List<Product> list = new ArrayList<Product>();

	ProductServiceImpl impl = new ProductServiceImpl();

	public ProductBean() {
		categories = impl.getAllCategories();
	}

	public void chooseCategory(int categoryId) {

		formPath = "product.xhtml";
		list = impl.getAllProduct();

		switch (categoryId) {
		case 3:
			formPath = "home.xhtml";
			break;
		case 4:
			formPath = "aboutus.xhtml";
			break;
		case 5:
			formPath = "login.xhtml";
			break;

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

	public void saveProduct() {
		product.setCategory(impl.getCategoryById(category.getId()));
		impl.saveProduct(product);
	}

}
