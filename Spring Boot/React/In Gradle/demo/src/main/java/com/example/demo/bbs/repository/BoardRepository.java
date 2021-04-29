package com.example.demo.bbs.repository;

import java.util.List;

import com.example.demo.bbs.domain.BoardDto;

public interface BoardRepository {
	public void create(BoardDto board) throws Exception;
	
	public List<BoardDto> list() throws Exception;
	
	public BoardDto read(Long boardNo) throws Exception;
	
	public void delete(Long boardNo) throws Exception;
	
	public void update(BoardDto board) throws Exception;
}
