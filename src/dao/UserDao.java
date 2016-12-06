package dao;

import model.User;

public interface UserDao {
	public void saveUser(User user);

	public int controlUser(User user);

}
