package br.com.apispringboot.apispringboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apispringboot.apispringboot.domain.User;
import br.com.apispringboot.apispringboot.dto.UserDTO;
import br.com.apispringboot.apispringboot.repository.UserRepository;
import br.com.apispringboot.apispringboot.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired // instaciar automaticamente
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(String id){
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User obj) {
		return userRepository.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);	
		return userRepository.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
