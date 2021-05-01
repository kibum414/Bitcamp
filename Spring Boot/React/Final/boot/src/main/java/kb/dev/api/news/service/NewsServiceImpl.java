package kb.dev.api.news.service;

import kb.dev.api.common.service.AbstractService;
import kb.dev.api.common.domain.Crawler;
import kb.dev.api.news.domain.News;
import kb.dev.api.news.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static kb.dev.api.common.service.CrawlerServiceImpl.connectUrl;

@Log
@Service
@RequiredArgsConstructor
public class NewsServiceImpl extends AbstractService<News> implements NewsService {

    // 생성자 주입 방식
    private final NewsRepository repository;

    @Override
    public List<News> saveAll(Crawler crawler) throws IOException {
        Document document = connectUrl(crawler.getUrl());
        repository.deleteAll();

        Elements elements = document.select(crawler.getCssQuery());

        List<News> newsList = new ArrayList<>();

        for (int i = 0; i < elements.size(); i++) {
            News news = new News();

            news.setTitle(elements.get(i).text());
            news.setAddress(elements.get(i).attr("href"));
            news.setCategory(crawler.getCategory());
            newsList.add(news);
            repository.save(news);
        }

        return newsList;
    }

    @Override
    public Page<News> findAll(final Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override // 뉴스가 언론사에 의해 막혔을 때
    public Optional<News> findByNewsId(String newsId) {
        Optional.ofNullable(repository.findByNewsId(newsId)).ifPresent(System.out::println);
        return Optional.ofNullable(repository.findByNewsId(newsId));
    }

    @Override
    public void optionalInit(String newsId) {
        Optional<String> optVal = Optional.empty(); // Optional Initializer
    }

    @Override
    public Long count() {
        return repository.count();
    }

    @Override
    public Boolean existsById(long id) {
        return repository.existsById(id);
    }

    @Override
    public Optional<News> findById(long id) { // 있는지 없는지 모르는 상태에서 찾을 때
        return repository.findById(id);
    }

    @Override
    public Optional<News> getOne(long id) { // 무조건 있다는 가정 하에서 찾을 때
        return Optional.of(repository.getOne(id));
    }

    @Override
    public Long save(News news) {
        // 스크래핑이 발생함

        return (repository.save(news) != null) ? 1L : 0L;
    }

    @Override
    public Long delete(News news) {
        repository.delete(news);

        // orElse : null 이면 () 내부 값 리턴
        return (findById(news.getNewsId()).orElse(null) == null) ? 1L : 0L;
    }
}
