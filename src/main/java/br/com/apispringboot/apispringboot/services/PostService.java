package br.com.apispringboot.apispringboot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apispringboot.apispringboot.domain.Post;
import br.com.apispringboot.apispringboot.repository.PostRepository;
import br.com.apispringboot.apispringboot.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired // instaciar automaticamente
	private PostRepository postRepository;

	public Post findById(String id){
		Optional<Post> obj = postRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

}
