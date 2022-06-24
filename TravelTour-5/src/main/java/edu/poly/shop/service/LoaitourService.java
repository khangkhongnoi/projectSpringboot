package edu.poly.shop.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import edu.poly.shop.domain.Loaitour;

public interface LoaitourService {

	<S extends Loaitour> List<S> findAll(Example<S> example, Sort sort);

	<S extends Loaitour> List<S> findAll(Example<S> example);

	Loaitour getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends Loaitour> entities);

	Loaitour getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	<S extends Loaitour, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(Loaitour entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	<S extends Loaitour> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<Loaitour> entities);

	<S extends Loaitour> long count(Example<S> example);

	void deleteInBatch(Iterable<Loaitour> entities);

	<S extends Loaitour> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Loaitour> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Long id);

	<S extends Loaitour> S saveAndFlush(S entity);

	void flush();

	<S extends Loaitour> List<S> saveAll(Iterable<S> entities);

	Optional<Loaitour> findById(Long id);

	List<Loaitour> findAllById(Iterable<Long> ids);

	List<Loaitour> findAll(Sort sort);

	Page<Loaitour> findAll(Pageable pageable);

	List<Loaitour> findAll();

	<S extends Loaitour> Optional<S> findOne(Example<S> example);

	<S extends Loaitour> S save(S entity);
	
}
