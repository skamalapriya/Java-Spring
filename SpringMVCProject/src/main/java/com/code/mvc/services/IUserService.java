package com.code.mvc.services;

import java.util.List;

import com.code.mvc.entity.Users;

public interface IUserService {
	public int createUser(Users user);
	public int updateUser(Users user);
	public int deleteUser(Users user);
	public int deleteUser(String emailid);
	public Users getUserByEmailId(String emailid);
	public List<Users> getAllUsers();
}
