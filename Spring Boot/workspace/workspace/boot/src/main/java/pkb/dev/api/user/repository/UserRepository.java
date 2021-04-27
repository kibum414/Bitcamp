package pkb.dev.api.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import pkb.dev.api.user.domain.UserVo;

public interface UserRepository extends JpaRepository<UserVo, Long> {

	@Transactional
	@Query(value = "SELECT username FROM users WHERE username = :username AND password = :password", nativeQuery = true)
	public String login(@Param("username") String username, @Param("password") String password);
}
