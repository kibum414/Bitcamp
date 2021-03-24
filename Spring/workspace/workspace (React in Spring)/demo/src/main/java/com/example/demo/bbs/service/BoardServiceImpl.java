package com.example.demo.bbs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.demo.bbs.domain.Board;
import com.example.demo.bbs.repository.BoardRepository;
import com.example.demo.cmm.service.AbstractFactoryService;

@Service
public class BoardServiceImpl extends AbstractFactoryService<Board> {
	@Autowired
	private BoardRepository repo;
	
	@Override
	public long count() {
		return repo.count();
	}

	@Override
	public boolean existsById(Long id) {
		return repo.existsById(id);
	}

	@Override
	public List<Board> findAll() {
		return repo.findAll();
	}

	@Override
	public Optional<Board> findOne(Example<Board> example) {
		return repo.findOne(example);
	}

	@Override
	public void deleteById(Long id) {
		repo.deleteById(id);
	}

	@Override
	public Optional<Board> findById(Long id) {
		return repo.findById(id);
	}

	@Override
	public Board save(Board entity) {
		return repo.save(entity);
	}

	@Override
	public Board getOne(Long id) {
		return repo.getOne(id);
	}

}
