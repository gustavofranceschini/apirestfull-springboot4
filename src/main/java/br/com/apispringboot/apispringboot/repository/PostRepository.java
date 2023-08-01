package br.com.apispringboot.apispringboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.apispringboot.apispringboot.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>  {
	
}