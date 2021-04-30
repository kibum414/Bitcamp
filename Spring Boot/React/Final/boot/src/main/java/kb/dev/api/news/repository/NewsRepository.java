package kb.dev.api.news.repository;

import kb.dev.api.news.domain.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
    public News findByNewsNo(String newsNo);
}
