package kb.dev.api.news.service;

import kb.dev.api.common.domain.Crawler;
import kb.dev.api.news.domain.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface NewsService {

    public List<News> saveAll(Crawler crawler) throws IOException;
    public Page<News> findAll(Pageable pageable);
    public Optional<News> findByNewsId(String newsId);
    public void optionalInit(String newsId);

}
