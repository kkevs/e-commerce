package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.event.FileUploadEvent;

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

	// private static String destination =
	// "C:\\Users\\köse\\Documents\\workspace-sts-3.8.1.RELEASE1\\e-commerce\\WebContent\\resources\\product_image\\";

	static ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
	private static String realPath = ctx.getRealPath("/");

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
		product.setImage_path(realPath);
		impl.saveProduct(product);

	}

	public void handleFileUpload(FileUploadEvent event) {
		ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		String realPath = ctx.getRealPath("/");


		FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		// Do what you want with the file
		try {
			copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void copyFile(String fileName, InputStream in) {
		ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		String realPath = ctx.getRealPath("/");


		try {
			// write the inputStream to a FileOutputStream
			OutputStream out = new FileOutputStream(
					new File(realPath + "image_" + fileName.substring(fileName.length() - 10, fileName.length())));
			realPath = realPath + "image_" + fileName.substring(fileName.length() - 10, fileName.length());
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			in.close();
			out.flush();
			out.close();

			System.out.println("New file created!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
