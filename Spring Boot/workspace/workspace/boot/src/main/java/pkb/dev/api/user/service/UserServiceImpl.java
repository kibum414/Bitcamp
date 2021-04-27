package pkb.dev.api.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import pkb.dev.api.common.service.AbstractService;
import pkb.dev.api.user.domain.UserVo;
import pkb.dev.api.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends AbstractService<UserVo> implements UserService {

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
	public List<UserVo> findAll() {
		return repo.findAll();
	}

	@Override
	public Optional<UserVo> findOne(Example<UserVo> example) {
		return repo.findOne(example);
	}

	@Override
	public void deleteById(long id) {
		repo.deleteById(id);
	}

	@Override
	public Optional<UserVo> findById(long id) {
		return repo.findById(id);
	}

	@Override
	public UserVo save(UserVo entity) {
		return repo.save(entity);
	}

	@Override
	public UserVo getOne(long id) {
		return repo.getOne(id);
	}

	@Override
	public String login(UserVo userVo) {
		return repo.login(userVo.getUsername(), userVo.getPassword());
	}
	
}
