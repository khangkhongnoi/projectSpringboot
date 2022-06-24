package edu.poly.shop.service.imp;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.poly.shop.domain.AppUser;
import edu.poly.shop.repository.TaikhoanRepository;
import edu.poly.shop.service.TaikhoanService;
@Service
public class TaikhoanServiceImpl implements TaikhoanService {
	@Autowired
	private TaikhoanRepository taikhoanRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
//	@Override
//	public Taikhoan login(String email, String password) {
//		Optional<Taikhoan> optExist = findByEmail(email);
//		if(optExist.isPresent() && bCryptPasswordEncoder.matches(password, optExist.get().getPassword())) {
//			optExist.get().setPassword("");
//			return optExist.get();
//		}
//		return null;
//	}
	
	@Override
	public <S extends AppUser> S save(S entity) {
		Optional<AppUser> optExist = findById(entity.getTentaikhoan());
		if(optExist.isPresent()) {
			if(StringUtils.isEmpty(entity.getPassword())){
				entity.setPassword(optExist.get().getPassword());
			}
		else {
			entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
		}
		}else {
		entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
		}
		return taikhoanRepository.save(entity);
		
	}
	
	
	@Override
	public Optional<AppUser> findByEmail(String email) {
		return taikhoanRepository.findByEmail(email);
	}

	@Override
	public <S extends AppUser> Optional<S> findOne(Example<S> example) {
		return taikhoanRepository.findOne(example);
	}

	@Override
	public List<AppUser> findAll() {
		return taikhoanRepository.findAll();
	}

	@Override
	public Page<AppUser> findAll(Pageable pageable) {
		return taikhoanRepository.findAll(pageable);
	}

	@Override
	public List<AppUser> findAll(Sort sort) {
		return taikhoanRepository.findAll(sort);
	}

	@Override
	public List<AppUser> findAllById(Iterable<String> ids) {
		return taikhoanRepository.findAllById(ids);
	}

	@Override
	public Optional<AppUser> findById(String id) {
		return taikhoanRepository.findById(id);
	}

	@Override
	public <S extends AppUser> List<S> saveAll(Iterable<S> entities) {
		return taikhoanRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		taikhoanRepository.flush();
	}

	@Override
	public <S extends AppUser> S saveAndFlush(S entity) {
		return taikhoanRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(String id) {
		return taikhoanRepository.existsById(id);
	}

	@Override
	public <S extends AppUser> List<S> saveAllAndFlush(Iterable<S> entities) {
		return taikhoanRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends AppUser> Page<S> findAll(Example<S> example, Pageable pageable) {
		return taikhoanRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<AppUser> entities) {
		taikhoanRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends AppUser> long count(Example<S> example) {
		return taikhoanRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<AppUser> entities) {
		taikhoanRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return taikhoanRepository.count();
	}

	@Override
	public <S extends AppUser> boolean exists(Example<S> example) {
		return taikhoanRepository.exists(example);
	}

	@Override
	public void deleteById(String id) {
		taikhoanRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<String> ids) {
		taikhoanRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(AppUser entity) {
		taikhoanRepository.delete(entity);
	}

	@Override
	public <S extends AppUser, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return taikhoanRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		taikhoanRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		taikhoanRepository.deleteAllInBatch();
	}

	@Override
	public AppUser getOne(String id) {
		return taikhoanRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends AppUser> entities) {
		taikhoanRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		taikhoanRepository.deleteAll();
	}

	@Override
	public AppUser getById(String id) {
		return taikhoanRepository.getById(id);
	}

	@Override
	public <S extends AppUser> List<S> findAll(Example<S> example) {
		return taikhoanRepository.findAll(example);
	}

	@Override
	public <S extends AppUser> List<S> findAll(Example<S> example, Sort sort) {
		return taikhoanRepository.findAll(example, sort);
	}

	@Override
	public List<String> findByRoleName(String tentaikhoan) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
