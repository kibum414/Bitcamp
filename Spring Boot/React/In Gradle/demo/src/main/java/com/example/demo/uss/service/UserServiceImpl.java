package com.example.demo.uss.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.cmm.service.AbstractFactoryService;
import com.example.demo.uss.domain.User;
import com.example.demo.uss.domain.UserDto;
import com.example.demo.uss.repository.UserRepository;

@Service
public class UserServiceImpl extends AbstractFactoryService<User> implements UserService {
	@Autowired UserRepository repo;
	
	@Override
	public long count() {
		return repo.count();
	}

	@Override
	public boolean existsById(Long id) {
		return repo.existsById(id);
	}

	@Override
	public List<User> findAll() {
		return repo.findAll();
	}

	@Override
	public Optional<User> findOne(Example<User> example) {
		return repo.findOne(example);
	}

	@Override
	public void deleteById(Long id) {
		repo.deleteById(id);
	}

	@Override
	public Optional<User> findById(Long id) {
		return repo.findById(id);
	}

	@Override
	public User save(User entity) {
		return repo.save(entity);
	}

	@Override
	public User getOne(Long id) {
		return repo.getOne(id);
	}

	// UserDetailsService의 메서드
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDto user = repo.findByUsername(username);
		
		if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return user;
        }
	}

	@Override
	public UserDto login(String username, String password) {
		return repo.login(username, password);
	}

}
