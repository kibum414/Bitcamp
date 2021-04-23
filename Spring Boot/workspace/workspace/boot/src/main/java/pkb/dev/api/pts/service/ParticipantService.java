package pkb.dev.api.pts.service;

import pkb.dev.api.pts.domain.Participant;

public interface ParticipantService {
	public Participant modify(long id, Participant participant);
}
