package edu.poly.shop.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import edu.poly.shop.domain.Tinh;

public interface TinhService {

	void deleteAll();

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	<S extends Tinh, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(Tinh entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	<S extends Tinh> boolean exists(Example<S> example);

	long count();

	void deleteInBatch(Iterable<Tinh> entities);

	<S extends Tinh> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Long id);

	<S extends Tinh> S saveAndFlush(S entity);

	void flush();

	<S extends Tinh> List<S> saveAll(Iterable<S> entities);

	Optional<Tinh> findById(Long id);

	List<Tinh> findAllById(Iterable<Long> ids);

	List<Tinh> findAll(Sort sort);

	Page<Tinh> findAll(Pageable pageable);

	List<Tinh> findAll();

	<S extends Tinh> S save(S entity);

	List<Tinh> findByTentinhContaining(String tentinh);

	Page<Tinh> findByTentinhContaining(String tentinh, Pageable pageable);

	List<Tinh> findByTentinh(String tentinh);

	Tinh findByIdtinh(Long id);





}
