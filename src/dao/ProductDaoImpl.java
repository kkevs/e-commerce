package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.primefaces.event.RowEditEvent;

import model.Category;
import model.Product;
import util.HibernateUtil;

public class ProductDaoImpl implements ProductDao {

	Session session = HibernateUtil.getSessionFactory().openSession();

	@Override
	public void saveProduct(Product product) {
		session.beginTransaction();
		session.save(product);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateProduct(RowEditEvent event) {
		Product product = (Product) event.getObject();
		session.beginTransaction();
		session.merge(product);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteProduct(Product product) {
		session.beginTransaction();
		session.delete(product);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> p_list = new ArrayList<Product>();
		Query query = session.createQuery("from Product");
		query.setCacheable(true);
		p_list = query.list();
		return p_list;
	}

	@Override
	public List<Category> getAllCategory() {
		List<Category> c_list = new ArrayList<Category>();
		Query query = session.createQuery("from Category");
		query.setCacheable(true);
		c_list = query.list();
		return c_list;
	}

	@Override
	public Category getCategoryById(int id) {
		Category category = (Category) session.get(Category.class, id);
		return category;
	}

	public List<Product> getProductById(int id) {
		List<Product> p_list = new ArrayList<Product>();
		Query query = session.createQuery("from Product p  where p.category.id=:id");
		query.setParameter("id", id);
		query.setCacheable(true);
		p_list = query.list();
		return p_list;
	}

}
