package com.example.demo.bbs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.demo.bbs.domain.Article;
import com.example.demo.bbs.repository.ArticleRepository;
import com.example.demo.cmm.service.AbstractFactoryService;

@Service
public class ArticleServiceImpl extends AbstractFactoryService<Article> {

	@Autowired
	private ArticleRepository repo;

	@Override
	public long count() {
		return repo.count();
	}

	@Override
	public boolean existsById(Long id) {
		return repo.existsById(id);
	}

	@Override
	public List<Article> findAll() {
		return repo.findAll();
	}

	@Override
	public Optional<Article> findOne(Example<Article> example) {
		return repo.findOne(example);
	}

	@Override
	public void deleteById(Long id) {
		repo.deleteById(id);
	}

	@Override
	public Optional<Article> findById(Long id) {
		return repo.findById(id);
	}

	@Override
	public Article save(Article entity) {
		return repo.save(entity);
	}

	@Override
	public Article getOne(Long id) {
		return repo.getOne(id);
	}
}