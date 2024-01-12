package com.example.demo.service;

import com.example.demo.entity.Users;

public interface UsersService {
	public String addUser(Users users);
	public boolean emailExists(String email);
	public boolean validateUser(String email, String password);
	public String getRole(String email);
	
	public Users getuUsers(String email);
	public void updateUsers(Users users);
	public Users getUser(String mail);
	public void updateUser(Users u);
}
