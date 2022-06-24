package edu.poly.shop.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import edu.poly.shop.domain.Tour;

public interface TourService {

//	Tour getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends Tour> entities);

	Tour getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	<S extends Tour, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(Tour entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	long count();

	void deleteAllInBatch(Iterable<Tour> entities);

	void deleteInBatch(Iterable<Tour> entities);

	<S extends Tour> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Long id);

	<S extends Tour> S saveAndFlush(S entity);

	void flush();

	<S extends Tour> List<S> saveAll(Iterable<S> entities);

	Optional<Tour> findById(Long id);

	List<Tour> findAllById(Iterable<Long> ids);

	List<Tour> findAll(Sort sort);

	Page<Tour> findAll(Pageable pageable);

	List<Tour> findAll();

	<S extends Tour> S save(S entity);

	Tour findByIdtour(Long idtour);

	List<Tour> findAllIddiadiem();

	List<Tour> findByIdtourlimit();

	List<Tour> findByAllHinhanh();

	List<Tour> findByTentour(String tentour);

//	List<Tour> findByIdchitiettour(Long idtour);


}
