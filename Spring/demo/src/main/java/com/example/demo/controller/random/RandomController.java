package com.example.demo.controller.random;

import com.example.demo.entity.random.RandomNumber;
import com.example.demo.service.random.RandomNumberService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Log
@Controller
// Vue - Spring 통신
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class RandomController {
    static final Random rand = new Random();

    @Autowired
    private RandomNumberService randNumService;

    @GetMapping("/random")
    @ResponseBody
    public ResponseEntity<RandomNumber> getRandom() {
        log.info("getRandom()");

        RandomNumber rand = randNumService.getRandom();

        return ResponseEntity.ok(rand);
    }
}
