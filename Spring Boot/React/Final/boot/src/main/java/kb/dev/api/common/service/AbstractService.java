package kb.dev.api.common.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;

public abstract class AbstractService<T> {

	public abstract long count();

	public abstract boolean existsById(long id);

	public abstract List<T> findAll();

	public abstract Optional<T> findById(long id);

	public abstract Optional<T> getOne(long id);

	public abstract long save(T t);

	public abstract long delete(T t);

	/*
	public abstract long count();
	
	public abstract boolean existsById(long id);
	
	public abstract List<T> findAll();
	
	public abstract Optional<T> findOne(Example<T> example);
	
	public abstract void deleteById(long id);
	
	public abstract Optional<T> findById(long id);
	
	public abstract T save(T entity);
	
	public abstract T getOne(long id);
	 */
	
}
