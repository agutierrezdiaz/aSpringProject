package org.a.demo.repositories;

import java.util.Optional;

import org.a.demo.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>  {

	/**
	 * Retrieves an user by its username
	 * @param username must not be null
	 * @return the user with the given username or IllegalArgumentException if none found
	 * @throws IllegalArgumentException - if username is null
	 */
	public Optional<User> findByUsername(String username);
	
	/**
 	 * Retrieves an user by its username and password.
	 * @param username must not be null.
	 * @param password must not be null.
	 * @return the user with the given username and password or IllegalArgumentException if none found
	 * @throws IllegalArgumentException - if properties are null.
	 */
	public Optional<User> findByUsernameAndPassword(String username, String password);
	
}
