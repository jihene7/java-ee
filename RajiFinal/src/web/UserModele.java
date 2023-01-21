package web;

import java.util.ArrayList;
import java.util.List;

import entites.Filiere;
import entites.User;

public class UserModele {
List<User> users = new ArrayList<>();
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
