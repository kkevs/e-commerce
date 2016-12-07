package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import model.Role;
import model.User;
import util.HibernateUtil;

public class UserDaoImpl implements UserDao {

	Session session = HibernateUtil.getSessionFactory().openSession();

	@Override
	public void saveUser(User user) {
		user.setRole(Role.USER);
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public int controlUser(User user) {
		Query query = session.createQuery("from User where user_name=? and pwd=?");
		query.setString(0, user.getUser_name()).setString(1, user.getPwd());
		List list = query.list();

		if (list.size() == 0) {
			return 0;
		}
		User user2 = (User) list.get(0);
		if (user2.getRole().toString().equals("ADMIN")) {
			return 1;
		}
		if (user2.getRole().toString().equals("USER")) {
			return 2;
		}
		return 0;
	}

}
