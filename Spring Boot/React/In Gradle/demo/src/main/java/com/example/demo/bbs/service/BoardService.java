package com.example.demo.bbs.service;

import java.util.List;

import com.example.demo.bbs.domain.BoardDto;

public interface BoardService {
	public List<BoardDto> list() throws Exception;
	
	public void register(BoardDto board) throws Exception;
	
	public BoardDto read(Long boardNo) throws Exception;
	
	public void remove(Long boardNo) throws Exception;
	
	public void modify(BoardDto board) throws Exception;
}
