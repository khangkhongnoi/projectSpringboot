package edu.poly.shop.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import edu.poly.shop.domain.Hoadon;

public interface HoadonService {

	<S extends Hoadon> List<S> findAll(Example<S> example, Sort sort);

	<S extends Hoadon> List<S> findAll(Example<S> example);

	Hoadon getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends Hoadon> entities);

	Hoadon getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	<S extends Hoadon, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(Hoadon entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	<S extends Hoadon> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<Hoadon> entities);

	<S extends Hoadon> long count(Example<S> example);

	void deleteInBatch(Iterable<Hoadon> entities);

	<S extends Hoadon> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Hoadon> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Long id);

	<S extends Hoadon> S saveAndFlush(S entity);

	void flush();

	<S extends Hoadon> List<S> saveAll(Iterable<S> entities);

	Optional<Hoadon> findById(Long id);

	List<Hoadon> findAllById(Iterable<Long> ids);

	List<Hoadon> findAll(Sort sort);

	Page<Hoadon> findAll(Pageable pageable);

	List<Hoadon> findAll();

	<S extends Hoadon> Optional<S> findOne(Example<S> example);

	<S extends Hoadon> S save(S entity);

}
