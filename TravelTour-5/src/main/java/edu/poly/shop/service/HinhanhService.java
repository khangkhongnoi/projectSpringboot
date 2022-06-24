package edu.poly.shop.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import edu.poly.shop.domain.Hinhanh;

public interface HinhanhService {

	<S extends Hinhanh> List<S> findAll(Example<S> example, Sort sort);

	<S extends Hinhanh> List<S> findAll(Example<S> example);

	Hinhanh getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends Hinhanh> entities);

	Hinhanh getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	<S extends Hinhanh, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(Hinhanh entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	<S extends Hinhanh> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<Hinhanh> entities);

	<S extends Hinhanh> long count(Example<S> example);

	void deleteInBatch(Iterable<Hinhanh> entities);

	<S extends Hinhanh> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Hinhanh> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Long id);

	<S extends Hinhanh> S saveAndFlush(S entity);

	void flush();

	<S extends Hinhanh> List<S> saveAll(Iterable<S> entities);

	Optional<Hinhanh> findById(Long id);

	List<Hinhanh> findAllById(Iterable<Long> ids);

	List<Hinhanh> findAll(Sort sort);

	Page<Hinhanh> findAll(Pageable pageable);

	List<Hinhanh> findAll();

	<S extends Hinhanh> Optional<S> findOne(Example<S> example);

	<S extends Hinhanh> S save(S entity);

}
