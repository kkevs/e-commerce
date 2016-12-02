package dao;

import org.hibernate.Session;

import model.Role;
import model.User;
import util.HibernateUtil;

public class UserDaoImlp implements UserDao {

	Session session = HibernateUtil.getSessionFactory().openSession();

	@Override
	public void saveUser(User user) {
		
		
		user.setRole(Role.USER);
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}

//	@Override
//	public void controlUser() {
//
//	}

}
