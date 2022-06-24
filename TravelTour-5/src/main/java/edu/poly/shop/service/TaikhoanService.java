package edu.poly.shop.service;


import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import edu.poly.shop.domain.AppUser;

public interface TaikhoanService {

	<S extends AppUser> List<S> findAll(Example<S> example, Sort sort);

	<S extends AppUser> List<S> findAll(Example<S> example);

	AppUser getById(String id);

	void deleteAll();

	void deleteAll(Iterable<? extends AppUser> entities);

	AppUser getOne(String id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends String> ids);

	<S extends AppUser, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(AppUser entity);

	void deleteAllByIdInBatch(Iterable<String> ids);

	void deleteById(String id);

	<S extends AppUser> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<AppUser> entities);

	<S extends AppUser> long count(Example<S> example);

	void deleteInBatch(Iterable<AppUser> entities);

	<S extends AppUser> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends AppUser> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(String id);

	<S extends AppUser> S saveAndFlush(S entity);

	void flush();

	<S extends AppUser> List<S> saveAll(Iterable<S> entities);

	Optional<AppUser> findById(String id);

	List<AppUser> findAllById(Iterable<String> ids);

	List<AppUser> findAll(Sort sort);

	Page<AppUser> findAll(Pageable pageable);

	List<AppUser> findAll();

	<S extends AppUser> Optional<S> findOne(Example<S> example);

	<S extends AppUser> S save(S entity);

	Optional<AppUser> findByEmail(String email);
	
//	Taikhoan login(String email, String password);

	List<String> findByRoleName(String tentaikhoan);

}
