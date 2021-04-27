package pkb.dev.api.pts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import pkb.dev.api.common.service.AbstractService;
import pkb.dev.api.pts.domain.ParticipantVo;
import pkb.dev.api.pts.repository.ParticipantRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl extends AbstractService<ParticipantVo> implements ParticipantService {

	private final ParticipantRepository repo;

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existsById(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ParticipantVo> findAll() {
		return repo.findAll();
	}

	@Override
	public Optional<ParticipantVo> findOne(Example<ParticipantVo> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(long id) {
		repo.deleteById(id);
	}

	@Override
	public Optional<ParticipantVo> findById(long id) {
		return repo.findById(id);
	}

	@Override
	public ParticipantVo save(ParticipantVo entity) {
		return repo.save(entity);
	}

	@Override
	public ParticipantVo getOne(long id) {
		return repo.getOne(id);
	}

	@Override
	public ParticipantVo modify(long id, ParticipantVo participant) {
		participant.setParticipantNo(id);
		
		repo.modify(participant.getName(), participant.getGender(), participant.getPhoneNumber(),
				participant.getEmail(), participant.getBirthday(), participant.getParticipantNo());
		System.out.println(participant);
		
		return participant;
	}

}
