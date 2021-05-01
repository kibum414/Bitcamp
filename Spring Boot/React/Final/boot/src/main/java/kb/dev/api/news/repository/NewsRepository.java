package kb.dev.api.news.repository;

import kb.dev.api.news.domain.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@NoRepositoryBean
@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    public News findByNewsId(String newsId);
//    Page<News> fetchAll(Pageable pageable, Integer totalElements);
}
