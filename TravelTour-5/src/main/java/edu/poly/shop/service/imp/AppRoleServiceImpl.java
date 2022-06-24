package edu.poly.shop.service.imp;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import edu.poly.shop.domain.AppRole;
import edu.poly.shop.domain.AppUser;
import edu.poly.shop.repository.AppRoleRository;
import edu.poly.shop.service.AppRoleService;
@Service
public class AppRoleServiceImpl implements AppRoleService {
	@Autowired
	AppRoleRository appRoleRository;

	public AppRoleServiceImpl(AppRoleRository appRoleRository) {
		super();
		this.appRoleRository = appRoleRository;
	}

	@Override
	public <S extends AppUser> S save(S entity) {
		return appRoleRository.save(entity);
	}

	@Override
	public <S extends AppUser> Optional<S> findOne(Example<S> example) {
		return appRoleRository.findOne(example);
	}

	@Override
	public List<AppUser> findAll() {
		return appRoleRository.findAll();
	}

	@Override
	public Page<AppUser> findAll(Pageable pageable) {
		return appRoleRository.findAll(pageable);
	}

	@Override
	public List<AppUser> findAll(Sort sort) {
		return appRoleRository.findAll(sort);
	}

	@Override
	public List<AppUser> findAllById(Iterable<Long> ids) {
		return appRoleRository.findAllById(ids);
	}

	@Override
	public Optional<AppUser> findById(Long id) {
		return appRoleRository.findById(id);
	}

	@Override
	public <S extends AppUser> List<S> saveAll(Iterable<S> entities) {
		return appRoleRository.saveAll(entities);
	}

	@Override
	public void flush() {
		appRoleRository.flush();
	}

	@Override
	public <S extends AppUser> S saveAndFlush(S entity) {
		return appRoleRository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return appRoleRository.existsById(id);
	}

	@Override
	public <S extends AppUser> List<S> saveAllAndFlush(Iterable<S> entities) {
		return appRoleRository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends AppUser> Page<S> findAll(Example<S> example, Pageable pageable) {
		return appRoleRository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<AppUser> entities) {
		appRoleRository.deleteInBatch(entities);
	}

	@Override
	public <S extends AppUser> long count(Example<S> example) {
		return appRoleRository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<AppUser> entities) {
		appRoleRository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return appRoleRository.count();
	}

	@Override
	public <S extends AppUser> boolean exists(Example<S> example) {
		return appRoleRository.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		appRoleRository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		appRoleRository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(AppUser entity) {
		appRoleRository.delete(entity);
	}

	@Override
	public <S extends AppUser, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return appRoleRository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		appRoleRository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		appRoleRository.deleteAllInBatch();
	}

	@Override
	public AppUser getOne(Long id) {
		return appRoleRository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends AppUser> entities) {
		appRoleRository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		appRoleRository.deleteAll();
	}

	@Override
	public AppUser getById(Long id) {
		return appRoleRository.getById(id);
	}

	@Override
	public <S extends AppUser> List<S> findAll(Example<S> example) {
		return appRoleRository.findAll(example);
	}

	@Override
	public <S extends AppUser> List<S> findAll(Example<S> example, Sort sort) {
		return appRoleRository.findAll(example, sort);
	}

	@Override
	public void save(AppRole appRole) {
		// TODO Auto-generated method stub
		
	}
	
}
