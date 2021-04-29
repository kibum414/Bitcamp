package com.example.demo.repository.crawl;

import com.example.demo.entity.crawl.HomeNews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeNewsRepository extends JpaRepository<HomeNews, Long> {
}
