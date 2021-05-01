package kb.dev.api.participant.service;

import kb.dev.api.common.service.AbstractService;
import kb.dev.api.participant.domain.Participant;
import kb.dev.api.participant.repository.ParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl extends AbstractService<Participant> implements ParticipantService {

    private final ParticipantRepository repository;

    @Override
    public Long count() {
        return repository.count();
    }

    @Override
    public Boolean existsById(long id) {
        return repository.existsById(id);
    }

    @Override
    public Page<Participant> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<Participant> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Participant> getOne(long id) {
        return Optional.of(repository.getOne(id));
    }

    @Override
    public Long save(Participant participant) {
        return (repository.save(participant) != null) ? 1L : 0L;
    }

    @Override
    public Long delete(Participant participant) {
        repository.delete(participant);

        return (findById(participant.getParticipantNo()).orElse(null) == null) ? 1L : 0L;
    }
}
