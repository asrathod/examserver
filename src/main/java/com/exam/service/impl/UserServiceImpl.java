package com.exam.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.exam.helper.UserFoundException;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import com.exam.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	//creating user
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		
		
		//Checking for user in db.
		User local = this.userRepository.findByUsername(user.getUsername());
		
		//printing msg if user present
		if(local != null) {
			System.out.println("User is already there !!");
			throw new UserFoundException();
		} 
		//create new user
		else {
			//getting all user roles and save
			for(UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}
			//adding all roles to user and save
			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);
		}
				
		return local;
	}

	//get user by username
	@Override
	public User getUser(String username) {
		
		return this.userRepository.findByUsername(username);
	}

	@Override
	public void deleteUser(Long userId) {
		this.userRepository.deleteById(userId);
		
	}

}
