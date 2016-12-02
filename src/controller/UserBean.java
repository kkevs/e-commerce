package controller;

import javax.faces.bean.ManagedBean;

import dao.UserDaoImlp;
import model.User;

@ManagedBean
public class UserBean {
	User user = new User();
	UserDaoImlp daoImlp = new UserDaoImlp();

	public UserBean() {
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserDaoImlp getDaoImlp() {
		return daoImlp;
	}

	public void setDaoImlp(UserDaoImlp daoImlp) {
		this.daoImlp = daoImlp;
	}

	public void saveUser() {
		daoImlp.saveUser(user);
	}

}
