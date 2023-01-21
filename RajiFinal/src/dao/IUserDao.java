package dao;

import java.util.List;

import entites.User;

public interface IUserDao {
	public User save(User cat);
	public User getUser(int id);
	public User updateUser(User cat);
	public void deleteUser(int id);
	public List<User> getAllUsers();
}
