package pkb.dev.api.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import pkb.dev.api.common.service.AbstractService;
import pkb.dev.api.user.domain.User;
import pkb.dev.api.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends AbstractService<User> implements UserService {

	private final UserRepository repo;

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existsById(long id) {
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
	public void deleteById(long id) {
		repo.deleteById(id);
	}

	@Override
	public Optional<User> findById(long id) {
		return repo.findById(id);
	}

	@Override
	public User save(User entity) {
		return repo.save(entity);
	}

	@Override
	public User getOne(long id) {
		return repo.getOne(id);
	}

	@Override
	public String login(User user) {
		return repo.login(user.getUsername(), user.getPassword());
	}
	
}
