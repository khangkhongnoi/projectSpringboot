package edu.poly.shop.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import edu.poly.shop.domain.Diadiem;
import edu.poly.shop.domain.Tour;

public interface DiadiemService {

	<S extends Diadiem> List<S> findAll(Example<S> example, Sort sort);

	<S extends Diadiem> List<S> findAll(Example<S> example);

	Diadiem getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends Diadiem> entities);

	Diadiem getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	<S extends Diadiem, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(Diadiem entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	<S extends Diadiem> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<Diadiem> entities);

	<S extends Diadiem> long count(Example<S> example);

	void deleteInBatch(Iterable<Diadiem> entities);

	<S extends Diadiem> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Diadiem> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Long id);

	<S extends Diadiem> S saveAndFlush(S entity);

	void flush();

	<S extends Diadiem> List<S> saveAll(Iterable<S> entities);

	Optional<Diadiem> findById(Long id);

	List<Diadiem> findAllById(Iterable<Long> ids);

	List<Diadiem> findAll(Sort sort);

	Page<Diadiem> findAll(Pageable pageable);

	List<Diadiem> findAll();

	<S extends Diadiem> Optional<S> findOne(Example<S> example);

	<S extends Diadiem> S save(S entity);



	List<Diadiem> findByIdtinh(Long idtinh);

	

	List<Diadiem> findByTourdId(Long id);

}
