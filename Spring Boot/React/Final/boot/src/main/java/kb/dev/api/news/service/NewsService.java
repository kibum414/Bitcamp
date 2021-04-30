package kb.dev.api.news.service;

import kb.dev.api.news.domain.News;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface NewsService {

    public Document connectUrl(String url) throws IOException;

    public List<News> newsFindAll();

    public void crawlingHome();

    public Long saveAll(String category) throws IOException;

    public Optional<News> findByNewsNo(String newsNo);

    public void optionalInit(String newsNo);

}
