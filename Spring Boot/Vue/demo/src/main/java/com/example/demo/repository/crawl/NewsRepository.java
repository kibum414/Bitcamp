package com.example.demo.repository.crawl;

import com.example.demo.entity.crawl.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
    public News findByNewsNo(String newsNo);
}
