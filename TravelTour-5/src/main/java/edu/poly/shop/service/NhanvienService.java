package edu.poly.shop.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import edu.poly.shop.domain.Nhanvien;

public interface NhanvienService {

	<S extends Nhanvien> List<S> findAll(Example<S> example, Sort sort);

	<S extends Nhanvien> List<S> findAll(Example<S> example);

	Nhanvien getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends Nhanvien> entities);

	Nhanvien getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	<S extends Nhanvien, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(Nhanvien entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	<S extends Nhanvien> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<Nhanvien> entities);

	<S extends Nhanvien> long count(Example<S> example);

	void deleteInBatch(Iterable<Nhanvien> entities);

	<S extends Nhanvien> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Nhanvien> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Long id);

	<S extends Nhanvien> S saveAndFlush(S entity);

	void flush();

	<S extends Nhanvien> List<S> saveAll(Iterable<S> entities);

	Optional<Nhanvien> findById(Long id);

	List<Nhanvien> findAllById(Iterable<Long> ids);

	List<Nhanvien> findAll(Sort sort);

	Page<Nhanvien> findAll(Pageable pageable);

	List<Nhanvien> findAll();

	<S extends Nhanvien> Optional<S> findOne(Example<S> example);

	<S extends Nhanvien> S save(S entity);

	List<Nhanvien> findByTennhanvien(String tennhanvien);

}
