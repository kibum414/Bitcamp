package com.example.demo.bbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bbs.domain.BoardDto;
import com.example.demo.bbs.service.BoardService;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping("/boards")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class BoardController {
	@Autowired
	private BoardService service;
	
	@GetMapping("/{boardNo}")
	public ResponseEntity<BoardDto> read(@PathVariable("boardNo") Long boardNo) throws Exception {
		log.info("read()");
		
		//Board board = service.read(boardNo);
		//System.out.println("BoardController: " + board);
		
		//return new ResponseEntity<BoardDto>(board, HttpStatus.OK);
		return null;
	}
}
