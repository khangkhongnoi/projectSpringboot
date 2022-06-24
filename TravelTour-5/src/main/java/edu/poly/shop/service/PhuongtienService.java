package edu.poly.shop.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import edu.poly.shop.domain.Phuongtien;

public interface PhuongtienService {

	<S extends Phuongtien> List<S> findAll(Example<S> example, Sort sort);

	<S extends Phuongtien> List<S> findAll(Example<S> example);

	Phuongtien getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends Phuongtien> entities);

	Phuongtien getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	<S extends Phuongtien, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(Phuongtien entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	<S extends Phuongtien> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<Phuongtien> entities);

	<S extends Phuongtien> long count(Example<S> example);

	void deleteInBatch(Iterable<Phuongtien> entities);

	<S extends Phuongtien> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Phuongtien> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Long id);

	<S extends Phuongtien> S saveAndFlush(S entity);

	void flush();

	<S extends Phuongtien> List<S> saveAll(Iterable<S> entities);

	Optional<Phuongtien> findById(Long id);

	List<Phuongtien> findAllById(Iterable<Long> ids);

	List<Phuongtien> findAll(Sort sort);

	Page<Phuongtien> findAll(Pageable pageable);

	List<Phuongtien> findAll();

	<S extends Phuongtien> Optional<S> findOne(Example<S> example);

	<S extends Phuongtien> S save(S entity);

}
