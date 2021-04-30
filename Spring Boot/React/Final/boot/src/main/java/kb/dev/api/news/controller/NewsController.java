package kb.dev.api.news.controller;

import kb.dev.api.news.service.NewsServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Log
@RestController
@RequiredArgsConstructor
@RequestMapping("/news")
public class NewsController {
    private final NewsServiceImpl service;

    @GetMapping("/{category}/scrap")
    public ResponseEntity<Long> crawling(@PathVariable String category) throws IOException {
        System.out.println("********** 카테고리 : " + category);

        return ResponseEntity.ok(service.saveAll(category));
    }
}
