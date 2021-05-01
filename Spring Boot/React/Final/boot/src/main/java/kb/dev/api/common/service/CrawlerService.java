package kb.dev.api.common.service;

import kb.dev.api.common.domain.Crawler;

import java.io.IOException;
import java.util.List;

public interface CrawlerService {
    public List<?> scrapBugs(Crawler crawler) throws IOException;
}
