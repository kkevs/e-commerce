package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;

import model.Category;
import model.Product;
import service.ProductServiceImpl;

@ManagedBean
@ViewScoped
public class ProductBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String formPath = "home.xhtml";

	private String fileImagePath;

	private Date date;

	private Category category = new Category();
	Product product = new Product();
	Product selectedProduct = new Product();

	List<Category> categories = new ArrayList<Category>();
	List<Product> list_product = new ArrayList<Product>();
	List<Product> list_admin = new ArrayList<Product>();

	ProductServiceImpl impl = new ProductServiceImpl();

	static ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
	String realPath = ctx.getRealPath("/");

	public ProductBean() {
		fileImagePath = new String();
		categories = impl.getAllCategories();
		list_admin = impl.getAllProduct();
	}

	public void chooseCategory(int categoryId) {

		switch (categoryId) {
		case 1:
			formPath = "product.xhtml";
			list_product = impl.getAllProduct();
			break;
		case 2:
			formPath = "product.xhtml";
			list_product = impl.getProductById(1);
			break;
		case 3:
			formPath = "product.xhtml";
			list_product = impl.getProductById(2);
			break;
		case 4:
			formPath = "product.xhtml";
			list_product = impl.getProductById(3);
			break;
		case 5:
			formPath = "product.xhtml";
			list_product = impl.getProductById(4);
			break;
		case 6:
			formPath = "home.xhtml";
			break;
		case 7:
			formPath = "aboutus.xhtml";
			break;
		case 8:
			formPath = "login.xhtml";
			break;

		}
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Product> getList_product() {
		return list_product;
	}

	public void setList_product(List<Product> list_product) {
		this.list_product = list_product;
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

	public Product getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(Product selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Product> getList_admin() {
		return list_admin;
	}

	public void setList_admin(List<Product> list_admin) {
		this.list_admin = list_admin;
	}

	public String getFileImagePath() {
		return fileImagePath;
	}

	public void setFileImagePath(String fileImagePath) {
		this.fileImagePath = fileImagePath;
	}

	public void saveProduct() {
		product.setCategory(impl.getCategoryById(category.getId()));
		product.setImage_path("/resources/product_image/" + fileImagePath);
		impl.saveProduct(product);

	}

	public void handleFileUpload(FileUploadEvent event) {
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

		fileImagePath = fileName;

		try {
			// write the inputStream to a FileOutputStream
			OutputStream out = new FileOutputStream(new File(realPath + "resources\\product_image\\" + fileName));
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

	public void deleteProduct() throws Exception {
		impl.deleteProduct(selectedProduct);
		selectedProduct = null;
	}

	public void onRowEdit(RowEditEvent event) throws Exception {
		impl.updateProduct(event);
		FacesMessage msg = new FacesMessage("Product Edited", ((Product) event.getObject()).getName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent event) throws Exception {
		FacesMessage msg = new FacesMessage("Prdocut Canceled", ((Product) event.getObject()).getName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
