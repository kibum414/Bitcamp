package kb.dev.api.user.repository;

import kb.dev.api.user.domain.UserVo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserVo, Long> {
}
