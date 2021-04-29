package com.example.demo.cmm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;

public abstract class AbstractFactoryService<T> {

	public abstract long count();
	public abstract boolean existsById(Long id);
	public abstract List<T> findAll();
	public abstract Optional<T> findOne(Example<T> example);
	public abstract void deleteById(Long id);
	public abstract Optional<T> findById(Long id);
	public abstract T save(T entity);
	public abstract T getOne(Long id);
}
