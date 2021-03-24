package com.example.demo.bbs.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.bbs.domain.BoardDto;

import lombok.extern.java.Log;

@Log
@Repository
public class BoardRepositoryImpl implements BoardRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void create(BoardDto board) throws Exception {
		log.info("BoardRepo create()");
		
		String query = "insert into board(title, content, writer) values(?, ?, ?)";
		
		jdbcTemplate.update(query, board.getTitle(), board.getContent(), board.getWriter());
	}

	@Override
	public List<BoardDto> list() throws Exception {
		log.info("BoardRepo list()");
		
		return null;
	}

	@Override
	public BoardDto read(Long boardNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long boardNo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(BoardDto board) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
}
