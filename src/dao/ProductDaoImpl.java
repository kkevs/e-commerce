package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import model.Category;
import model.Product;
import util.HibernateUtil;

public class ProductDaoImpl implements ProductDao {

	Session session = HibernateUtil.getSessionFactory().openSession();

	@Override
	public void addProduct(Product product) {
		session.beginTransaction();
		session.save(product);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateProduct(Product product) {
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
	public List<Product> allProduct() {
		session.beginTransaction();
		List<Product> p_list = new ArrayList<Product>();
		Query query = session.createQuery("from Product");
		p_list = query.list();
		session.close();
		return p_list;
	}

	@Override
	public List<Product> getByCategory(Category category) {
		session.beginTransaction();
		List<Product> p_list = new ArrayList<Product>();
		Query query = session.createQuery("from Product p where p.category.id=:id");
		query.setParameter(0, category.getId());
		p_list = query.list();
		session.close();
		return p_list;
	}

	@Override
	public List<Category> allCategory() {
		session.beginTransaction();
		List<Category> c_list = new ArrayList<Category>();
		Query query = session.createQuery("from Category");
		c_list = query.list();
		session.close();
		return c_list;
	}

}
