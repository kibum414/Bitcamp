package kb.dev.api.common.service;

import kb.dev.api.common.domain.Crawler;
import kb.dev.api.news.domain.News;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CrawlerServiceImpl implements CrawlerService{

    public static Document connectUrl(String url) throws IOException {
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
    public List<?> scrapBugs(Crawler crawler) throws IOException {
        Document document = connectUrl(crawler.getUrl());
// Daum Document document = connectUrl("https://news.daum.net/" + category); //
// Bugs Document document = connectUrl("https://music.bugs.co.kr/" + category); // chart
// CGV  Document document = connectUrl("http://www.cgv.co.kr/" + category); // movies

        Elements elements = document.select(crawler.getCssQuery());
// Daum Elements elements = document.select("ul.tab_aside>li.on>div.cont_aside>ol.list_ranking>li>strong.tit_g>a");
// Bugs Elements elements = document.select("div.innerContainer>div>table.list>tbody>tr>th>p.title>a");
// CGV  Elements elements = document.select("div.wrap-movie-chart>div.sect-movie-chart>ol>li>div.box-contents>a>strong.title");

        for (int i = 0; i < elements.size(); i++) {
            News news = new News();

            news.setTitle(elements.get(i).text());
            news.setAddress(elements.get(i).attr("href"));
            news.setCategory(crawler.getCategory());
        }

        // return count > 0L ? 1L : 0L;
        return null;
    }
}
