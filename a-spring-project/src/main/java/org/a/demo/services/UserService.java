package org.a.demo.services;

import java.util.List;
import java.util.Optional;

import org.a.demo.entities.User;
import org.a.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 * Service class for content type User
 * @author Adrian Gutierrez
 *
 */
@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	/**
	 * Retrieves an user by its username and password.
	 * @param username must not be null.
	 * @param password must not be null.
	 * @return the user with the given username and password or ResponseStatusException if none found* 
	 */
	public User getUserByUsernameAndPassword(String username, String password) {
		return repository.findByUsernameAndPassword(username, password).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User %s not found", username)));
	}
	
	/**
	 * Retrieves all stored user.
	 * 
	 * @return all user.
	 */
	public List<User> getUsers() {
		return repository.findAll();
	}
	
	/**
	 * Save a given user. Use the returned instance for further operations as the
	 * save operation might have changed the user instance completely
	 * 
	 * @param user must not be null
	 * @return the saved user; will never be null
	 * @throws IllegalArgumentException - in case the given user is null.
	 */
	public User create(User user) {
		return repository.save(user);
	}

	/**
	 * Update a given user. Use the returned instance for further operations as the save operation might have changed the user instance completely
	 * @param id must not be null
	 * @param user must not be null
	 * @return the saved user; will never be null
	 * @throws ResponseStatusException - in case the given id is null
	 */
	public User update(String id, User user) {
		Optional<User> result = repository.findById(id);
		if (result.isPresent()) {
			return repository.save(user);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User %s is doesn't exists", id));
		}
	}

	/**
	 * Deletes a given user.
	 * @param id must not be null
	 * @throws ResponseStatusException - in case the given id is null
	 */
	public void delete(String id) {
		Optional<User> result = repository.findById(id);
		if (result.isPresent()) {
			repository.delete(result.get());
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User %s is doesn't exists", id));
		}
	}

}
