package com.daniel;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.daniel.dao.UserDao;
import com.daniel.model.User;
import com.daniel.util.DbUtil;

public class App {
	
	public static void main(String[] args) {
		UserDao dao = new UserDao();

		// Add new user
		User user = new User();
		user.setFirstName("Daniel");
		user.setLastName("Niko");
		try {
			Date dob = new SimpleDateFormat("yyyy-MM-dd").parse("1986-01-02");
			user.setDob(dob);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		user.setEmail("daniel@example.com");
		dao.addUser(user);
//
//		// Update user
		user.setEmail("danielniko@example.com");
		user.setUserid(1);
		dao.updateUser(user);

		// Delete user
		//dao.deleteUser(2);

		// Get all users
		for (User iter : dao.getAllUsers()) {
			System.out.println(iter);
		}

		// Get user by id
		System.out.println(dao.getUserById(8));
		
		try {
			DbUtil.getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
