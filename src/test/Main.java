package test;

import dao.UserDaoImlp;
import model.User;
public class Main {

	public static void main(String[] args) {

		UserDaoImlp daoImlp=new UserDaoImlp();
		
		User user=new User("kevser", "kose", "kkevs");
		
		daoImlp.saveUser(user);
	}

}
