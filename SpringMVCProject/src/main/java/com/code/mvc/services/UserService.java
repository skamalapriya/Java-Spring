package com.code.mvc.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.mvc.dao.IUserDao;
import com.code.mvc.entity.Users;

/* 1. This is an example for integration logic.
 * 
 * 2. Generally when a form is submitted, the controller transfers those data to this service class, where 
 *    the data is checked for authenticity and validated and then this service class would call Dao objects 
 *    and store( or CRUD operated) the data to the database. Any data from database would be sent by Dao to
 *    this service class and then to Controller. So, dealing between Controller and Dao happens through this
 *    service class.
 *    Controller --> Service --> Dao
 *    Controller <-- Service <-- Dao
 *    
 * 3. Purpose of UserService class is that, before a user is added(or any CRUD operated) to the database via
 *    UserDao object, the user has to be checked for authentication which could be done by a third-party s/w
 *    in our application. */

@Service
@Transactional
public class UserService implements IUserService{

	@Autowired
	IUserDao userDao;
	
	@Override
	public int createUser(Users user) {
		// TODO Auto-generated method stub
		return userDao.createUser(user);
	}

	@Override
	public int updateUser(Users user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}

	@Override
	public int deleteUser(Users user) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(user);
	}

	@Override
	public int deleteUser(String emailid) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(emailid);
	}

	@Override
	public Users getUserByEmailId(String emailid) {
		// TODO Auto-generated method stub
		return userDao.getUserByEmailId(emailid);
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return userDao.getAllUsers();
	}

}
