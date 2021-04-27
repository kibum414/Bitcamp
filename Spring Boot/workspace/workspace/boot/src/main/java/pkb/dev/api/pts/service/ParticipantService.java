package pkb.dev.api.pts.service;

import pkb.dev.api.pts.domain.ParticipantVo;

public interface ParticipantService {
	public ParticipantVo modify(long id, ParticipantVo participant);
}
