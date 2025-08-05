package com.example.SpringBootUserApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> getAllUsers() {
		return repository.findAll();
	}

	public User saveUser(User user) {
		return repository.save(user);
	}

	public User updateUser(int id, User updatedUser) {
		Optional<User> existingUser = repository.findById(id);
		if (existingUser.isPresent()) {
			User user = existingUser.get();
			user.setName(updatedUser.getName());
			user.setEmail(updatedUser.getEmail());
			user.setAge(updatedUser.getAge());
			return repository.save(user);
		}
		return null;
	}

	public String deleteUser(int id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return "User deleted with ID: " + id;
		}
		return "User not found with ID: " + id;
	}
}
