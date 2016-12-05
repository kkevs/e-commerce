package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Category;

@ManagedBean
@SessionScoped
public class ProductBean {
	private String formPath;
	private Category category = new Category();

	public ProductBean() {
		formPath = "home.xhtml";
	}

	public void chooseCategory(int categoryId) {

		formPath = "product.xhtml";

		switch (categoryId) {
		case 3:
			formPath = "home.xhtml";
			break;
		case 4:
			formPath = "login.xhtml";

		}
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

}
