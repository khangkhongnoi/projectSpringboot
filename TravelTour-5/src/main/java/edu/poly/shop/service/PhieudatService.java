package edu.poly.shop.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import edu.poly.shop.domain.Phieudat;

public interface PhieudatService {

	<S extends Phieudat> List<S> findAll(Example<S> example, Sort sort);

	<S extends Phieudat> List<S> findAll(Example<S> example);

	Phieudat getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends Phieudat> entities);

	Phieudat getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	<S extends Phieudat, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(Phieudat entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	<S extends Phieudat> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<Phieudat> entities);

	<S extends Phieudat> long count(Example<S> example);

	void deleteInBatch(Iterable<Phieudat> entities);

	<S extends Phieudat> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Phieudat> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Long id);

	<S extends Phieudat> S saveAndFlush(S entity);

	void flush();

	<S extends Phieudat> List<S> saveAll(Iterable<S> entities);

	Optional<Phieudat> findById(Long id);

	List<Phieudat> findAllById(Iterable<Long> ids);

	List<Phieudat> findAll(Sort sort);

	Page<Phieudat> findAll(Pageable pageable);

	List<Phieudat> findAll();

	<S extends Phieudat> Optional<S> findOne(Example<S> example);

	<S extends Phieudat> S save(S entity);

}
