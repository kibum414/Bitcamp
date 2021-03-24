package com.example.demo.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bbs.domain.BoardDto;
import com.example.demo.bbs.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository boardRepo;
	
	@Override
	public List<BoardDto> list() throws Exception {
		return boardRepo.list();
	}

	@Override
	public void register(BoardDto board) throws Exception {
		boardRepo.create(board);
	}

	@Override
	public BoardDto read(Long boardNo) throws Exception {
		return boardRepo.read(boardNo);
	}

	@Override
	public void remove(Long boardNo) throws Exception {
		boardRepo.delete(boardNo);
	}

	@Override
	public void modify(BoardDto board) throws Exception {
		boardRepo.update(board);
	}

}
