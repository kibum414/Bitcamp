package com.example.demo.service.crawl;

import com.example.demo.entity.crawl.HomeNews;
import com.example.demo.entity.crawl.News;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;

public interface NewsCrawlService {
    public Document connectUrl(String url) throws Exception;
    public List<News> newsFindAll();
    public List<HomeNews> homeNewsFindAll();
    public void crawlingHome() throws Exception;
    public void mainCrawler(String category) throws Exception;
    public void daumNews(Elements elements, String category);
    //public ClickedNews crawlingOne(String newsNo);
}
