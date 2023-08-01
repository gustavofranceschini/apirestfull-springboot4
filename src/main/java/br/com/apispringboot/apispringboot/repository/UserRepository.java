package br.com.apispringboot.apispringboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.apispringboot.apispringboot.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>  {
	
}
