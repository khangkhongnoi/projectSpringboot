package edu.poly.shop.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import edu.poly.shop.domain.Giatour;

public interface GiatourService {

	<S extends Giatour> List<S> findAll(Example<S> example, Sort sort);

	<S extends Giatour> List<S> findAll(Example<S> example);

	Giatour getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends Giatour> entities);

	Giatour getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	<S extends Giatour, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(Giatour entity);

	void deleteById(Long id);

	<S extends Giatour> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<Giatour> entities);

	<S extends Giatour> long count(Example<S> example);

	void deleteInBatch(Iterable<Giatour> entities);

	<S extends Giatour> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Giatour> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Long id);

	<S extends Giatour> S saveAndFlush(S entity);

	void flush();

	<S extends Giatour> List<S> saveAll(Iterable<S> entities);

	Optional<Giatour> findById(Long id);

	List<Giatour> findAllById(Iterable<Long> ids);

	List<Giatour> findAll(Sort sort);

	Page<Giatour> findAll(Pageable pageable);

	List<Giatour> findAll();

	<S extends Giatour> Optional<S> findOne(Example<S> example);

	<S extends Giatour> S save(S entity);

	List<Giatour> findAllIdgiatour();

	int updateTrangthaiid(Long id);


}
