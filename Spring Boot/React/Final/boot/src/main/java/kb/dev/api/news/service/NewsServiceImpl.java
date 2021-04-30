package kb.dev.api.news.service;

import kb.dev.api.common.service.AbstractService;
import kb.dev.api.news.domain.News;
import kb.dev.api.news.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Log
@Service
@RequiredArgsConstructor
public class NewsServiceImpl extends AbstractService<News> implements NewsService {

    // 생성자 주입 방식
    private final NewsRepository repository;

    @Override
    public Document connectUrl(String url) throws IOException {
//        log.info("connectUrl(): " + url);
//        Document document = null;
//        Connection.Response homepage =
//                Jsoup
//                        .connect(url)
//                        .method(Connection.Method.GET)
//                        .userAgent("Mozila/5.0 (X11; Linux x86_64; rv:10.0) " +
//                                "Gecko/20100101 Firefox/10.0 " +
//                                "AppleWebKit/537.36 (KHTML, like Gecko) " +
//                                "Chrome/51.0.2704.106 Safari/537.36")
//                        .execute();
//
//        return homepage.parse();
        return Jsoup
                .connect(url)
                .method(Connection.Method.GET)
                .userAgent("Mozila/5.0 (X11; Linux x86_64; rv:10.0) " +
                        "Gecko/20100101 Firefox/10.0 " +
                        "AppleWebKit/537.36 (KHTML, like Gecko) " +
                        "Chrome/51.0.2704.106 Safari/537.36")
                .execute()
                .parse();
    }

    @Override
    public List<News> newsFindAll() {
        return null;
    }

    @Override
    public void crawlingHome() {

    }

    @Override
    public Long saveAll(String category) throws IOException {
        Document document = connectUrl("https://news.daum.net/" + category);
// Bugs Document document = connectUrl("https://music.bugs.co.kr/" + category); // chart
// CGV  Document document = connectUrl("http://www.cgv.co.kr/" + category); // movies
        repository.deleteAll();

        Elements elements = document.select("ul.tab_aside>li.on>div.cont_aside>ol.list_ranking>li>strong.tit_g>a");
// Bugs Elements elements = document.select("div.innerContainer>div>table.list>tbody>tr>th>p.title>a");
// CGV  Elements elements = document.select("div.wrap-movie-chart>div.sect-movie-chart>ol>li>div.box-contents>a>strong.title");

        int count = 0;

        for (int i = 0; i < elements.size(); i++) {
            News news = new News();

            news.setTitle(elements.get(i).text());
            news.setAddress(elements.get(i).attr("href"));
            news.setCategory(category);
            // repository.save(news);

            count++;
            System.out.println("********** News 정보: " + news.toString());
        }
        System.out.println("********** 크롤링 카운트: " + count);

        return 0L;
    }

    @Override // 뉴스가 언론사에 의해 막혔을 때
    public Optional<News> findByNewsNo(String newsNo) {
        Optional.ofNullable(repository.findByNewsNo(newsNo)).ifPresent(System.out::println);
        return Optional.ofNullable(repository.findByNewsNo(newsNo));
    }

    @Override
    public void optionalInit(String newsNo) {
        Optional<String> optVal = Optional.empty(); // Optional Initializer
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public boolean existsById(long id) {
        return repository.existsById(id);
    }

    @Override
    public List<News> findAll() {
        return repository.findAll();
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
    public long save(News news) {
        // 스크래핑이 발생함

        return (repository.save(news) != null) ? 1L : 0L;
    }

    @Override
    public long delete(News news) {
        repository.delete(news);

        // orElse : null 이면 () 내부 값 리턴
        return (findById(news.getNewsId()).orElse(null) == null) ? 1L : 0L;
    }
}
