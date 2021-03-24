package com.example.demo.service.crawl;

import com.example.demo.entity.crawl.HomeNews;
import com.example.demo.entity.crawl.News;
import com.example.demo.repository.crawl.HomeNewsRepository;
import com.example.demo.repository.crawl.NewsRepository;
import lombok.extern.java.Log;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// 땡겨오는 데이터가 많기 때문에 lazy loading 사용
@Lazy
@Log
public class NewsCrawlServiceImpl implements NewsCrawlService {

    @Autowired
    private NewsRepository newsRepo;

    @Autowired
    private HomeNewsRepository homeNewsRepo;

    //@Autowired
    //private ClickedNewsRepository clickedNewsRepo;

    private Document document;

    @Override
    public Document connectUrl(String url) throws Exception {
        log.info("connectUrl(): " + url);

        try {
            Connection.Response homepage =
                    Jsoup.connect(url).method(Connection.Method.GET)
                            .userAgent("Mozila/5.0 (X11; Linux x86_64; rv:10.0) " +
                                    "Gecko/20100101 Firefox/10.0 " +
                                    "AppleWebKit/537.36 (KHTML, like Gecko) " +
                                    "Chrome/51.0.2704.106 Safari/537.36")
                            .execute();

            document = homepage.parse();
        } catch(Exception e) {
            System.out.println("Error in mainCrawler");
        }

        return document;
    }

    @Override
    public List<News> newsFindAll() {
        log.info("newsFindAll()");

        return newsRepo.findAll();
    }

    @Override
    public List<HomeNews> homeNewsFindAll() {
        log.info("homeNewsFindAll()");

        return homeNewsRepo.findAll();
    }

    @Override
    public void crawlingHome() throws Exception {
        log.info("crawlingHome()");

        homeNewsRepo.deleteAll();
        document = connectUrl("https://news.daum.net/");

        // 마우스 오른쪽 버튼 inspect 해서 어떤 걸 쓸지 봐야 함
        Elements total = document.select(
                "strong.tit_thumb>a.link_txt");
        Elements image = document.select(
                "div.item_issue>a.link_thumb>img.thumb_g");

        HomeNews homeNews = null;

        for (int i = 0; i < total.size(); i++) {
            homeNews = new HomeNews();

            homeNews.setHomeNewsNo(String.valueOf(i + 1));
            homeNews.setTitle(total.get(i).text());
            homeNews.setAddress(total.get(i).attr("href"));
            homeNews.setImage(image.get(i).attr("src"));
            homeNewsRepo.save(homeNews);
        }
    }

    @Override
    public void mainCrawler(String category) throws Exception {
        log.info("mainCrawler(): " + category);

        document = connectUrl("https://news.daum.net/" + category);
        newsRepo.deleteAll();

        daumNews(document.select(
                "div.item_mainnews>div.cont_thumb>strong.tit_thumb>a"),
                category);

        daumNews(document.select(
                "ul.list_mainnews>li>div.cont_thumb>strong.tit_thumb>a"),
                category);

        daumNews(document.select(
                "strong.tit_mainnews>a"), category);

        daumNews(document.select(
                "div.item_relate>a"), category);
    }

    @Override
    public void daumNews(Elements elements, String category) {
        log.info("daumNews(): elements - " +
                elements + ", category - " + category);

        News news = null;

        for (int i = 0; i < elements.size(); i++) {
            news = new News();

            news.setNewsNo(String.valueOf(newsRepo.findAll().size() + 1));
            news.setAddress(elements.get(i).attr("href"));
            news.setCategory(category);
            news.setTitle(elements.get(i).text());

            newsRepo.save(news);
        }
    }

    /*
    @Override
    public ClickedNews crawlingOne(String newsNo) {
        return null;
    }
     */
}
