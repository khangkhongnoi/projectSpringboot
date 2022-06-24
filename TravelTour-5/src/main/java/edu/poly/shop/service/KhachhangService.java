package edu.poly.shop.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import edu.poly.shop.domain.Khachhang;

public interface KhachhangService {

	<S extends Khachhang> List<S> findAll(Example<S> example, Sort sort);

	<S extends Khachhang> List<S> findAll(Example<S> example);

	Khachhang getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends Khachhang> entities);

	Khachhang getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	<S extends Khachhang, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(Khachhang entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	<S extends Khachhang> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<Khachhang> entities);

	<S extends Khachhang> long count(Example<S> example);

	void deleteInBatch(Iterable<Khachhang> entities);

	<S extends Khachhang> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Khachhang> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Long id);

	<S extends Khachhang> S saveAndFlush(S entity);

	void flush();

	<S extends Khachhang> List<S> saveAll(Iterable<S> entities);

	Optional<Khachhang> findById(Long id);

	List<Khachhang> findAllById(Iterable<Long> ids);

	List<Khachhang> findAll(Sort sort);

	Page<Khachhang> findAll(Pageable pageable);

	List<Khachhang> findAll();

	<S extends Khachhang> Optional<S> findOne(Example<S> example);

	<S extends Khachhang> S save(S entity);

}
