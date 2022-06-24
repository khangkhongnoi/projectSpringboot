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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.poly.shop.domain.AppUser;
import edu.poly.shop.repository.AppUserRepository;
import edu.poly.shop.service.AppUserService;
@Service
public class AppUserServiceImpl implements AppUserService {
	@Autowired 
	AppUserRepository appUserRepository;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	public AppUserServiceImpl(AppUserRepository appUserRepository) {
		super();
		this.appUserRepository = appUserRepository;
	}

	@Override
	public AppUser findByTentaikhoan(String tentaikhoan) {
		return appUserRepository.findByTentaikhoan(tentaikhoan);
	}

	@Override
	public <S extends AppUser> S save(S entity ) {
		String pass = entity.getPassword();
		entity.setPassword(this.bCryptPasswordEncoder.encode(pass));
		if(entity.getSdt() != null) {
			entity.setEmail("null");
		}else {
			entity.setSdt(0);
		}
		
		return appUserRepository.save(entity);
	}

	@Override
	public <S extends AppUser> Optional<S> findOne(Example<S> example) {
		return appUserRepository.findOne(example);
	}

	@Override
	public List<AppUser> findAll() {
		return appUserRepository.findAll();
	}

	@Override
	public Page<AppUser> findAll(Pageable pageable) {
		return appUserRepository.findAll(pageable);
	}

	@Override
	public List<AppUser> findAll(Sort sort) {
		return appUserRepository.findAll(sort);
	}

	@Override
	public List<AppUser> findAllById(Iterable<Long> ids) {
		return appUserRepository.findAllById(ids);
	}

	@Override
	public Optional<AppUser> findById(Long id) {
		return appUserRepository.findById(id);
	}

	@Override
	public <S extends AppUser> List<S> saveAll(Iterable<S> entities) {
		return appUserRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		appUserRepository.flush();
	}

	@Override
	public <S extends AppUser> S saveAndFlush(S entity) {
		return appUserRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return appUserRepository.existsById(id);
	}

	@Override
	public <S extends AppUser> List<S> saveAllAndFlush(Iterable<S> entities) {
		return appUserRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends AppUser> Page<S> findAll(Example<S> example, Pageable pageable) {
		return appUserRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<AppUser> entities) {
		appUserRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends AppUser> long count(Example<S> example) {
		return appUserRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<AppUser> entities) {
		appUserRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return appUserRepository.count();
	}

	@Override
	public <S extends AppUser> boolean exists(Example<S> example) {
		return appUserRepository.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		appUserRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		appUserRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(AppUser entity) {
		appUserRepository.delete(entity);
	}

	@Override
	public <S extends AppUser, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return appUserRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		appUserRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		appUserRepository.deleteAllInBatch();
	}

	@Override
	public AppUser getOne(Long id) {
		return appUserRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends AppUser> entities) {
		appUserRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		appUserRepository.deleteAll();
	}

	@Override
	public AppUser getById(Long id) {
		return appUserRepository.getById(id);
	}

	@Override
	public <S extends AppUser> List<S> findAll(Example<S> example) {
		return appUserRepository.findAll(example);
	}

	@Override
	public <S extends AppUser> List<S> findAll(Example<S> example, Sort sort) {
		return appUserRepository.findAll(example, sort);
	}
	
}
