package kb.dev.api.participant.repository;

import kb.dev.api.participant.domain.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}
