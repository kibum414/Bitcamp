package kb.dev.api.participant.service;

import kb.dev.api.common.service.AbstractService;
import kb.dev.api.participant.domain.Participant;
import kb.dev.api.participant.repository.ParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl extends AbstractService<Participant> implements ParticipantService {

    private final ParticipantRepository repository;

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public boolean existsById(long id) {
        return repository.existsById(id);
    }

    @Override
    public List<Participant> findAll() {
        return repository.findAll();
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
    public long save(Participant participant) {
        return (repository.save(participant) != null) ? 1L : 0L;
    }

    @Override
    public long delete(Participant participant) {
        repository.delete(participant);

        return (findById(participant.getParticipantNo()).orElse(null) == null) ? 1L : 0L;
    }
}
