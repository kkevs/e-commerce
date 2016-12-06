package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import model.Product;
import util.HibernateUtil;

public class ProductDaoImlp implements ProductDao {

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

	}

	@Override
	public void deleteProduct(Product product) {

	}

	@Override
	public List<Product> allProduct() {
		List<Product> p_list = new ArrayList<Product>();
		Query query = session.createQuery("from Product");
		p_list = query.list();
		session.close();
		return p_list;
	}

}
