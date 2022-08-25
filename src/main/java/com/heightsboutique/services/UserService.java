package com.heightsboutique.services;


import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.heightsboutique.models.LoginUser;
import com.heightsboutique.models.User;
import com.heightsboutique.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User register(User newUser, BindingResult result) {
		Optional<User> alreadyUser = userRepository.findByEmail(newUser.getEmail());
		
		if(alreadyUser.isPresent()) {
			result.rejectValue("email", "Matches", "Email already in use");
		}
		
//		if(newUser.getPassword().equals(newUser.getConfirm()));{
//			result.rejectValue("confirm", "Matches", "Invalid Password");
//		}
		if(result.hasErrors()) {
			return null;
		}
		
		String hashedPW = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashedPW);
		return userRepository.save(newUser);
	}	
	public User login(LoginUser newLogin, BindingResult result) {
		Optional<User> alreadyUser = userRepository.findByEmail(newLogin.getEmail());
		
		if(!alreadyUser.isPresent()) {
			result.rejectValue("email", "Match", "Please enter a correct email and password");
		}
		
		User user = alreadyUser.get();
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("email", "Match", "Please enter a correct email and password");
		}
		if(result.hasErrors()) {
			return null;
		}
		return user;
	}
	public User findById(Long id) {
		Optional<User> alreadyUser = userRepository.findById(id);
		
		if(alreadyUser.isPresent()) {
			return alreadyUser.get();
		}
		return null;
	}
}