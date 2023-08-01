package br.com.apispringboot.apispringboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apispringboot.apispringboot.domain.User;
import br.com.apispringboot.apispringboot.repository.UserRepository;

@Service
public class UserService {

	@Autowired // instaciar automaticamente
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

}
