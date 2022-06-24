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

import edu.poly.shop.domain.Diadiem;
import edu.poly.shop.domain.Tour;
import edu.poly.shop.repository.DiadiemRepository;
import edu.poly.shop.service.DiadiemService;

@Service
public class DiadiemServiceImpl implements DiadiemService {
	@Autowired
	DiadiemRepository diadiemRepository;

	public DiadiemServiceImpl(DiadiemRepository diadiemRepository) {
		this.diadiemRepository = diadiemRepository;
	}

	
	@Override
	public List<Diadiem> findByIdtinh(Long idtinh) {
		return diadiemRepository.findByIdtinh(idtinh);
	}


	@Override
	public <S extends Diadiem> S save(S entity) {
		return diadiemRepository.save(entity);
	}

	@Override
	public <S extends Diadiem> Optional<S> findOne(Example<S> example) {
		return diadiemRepository.findOne(example);
	}

	@Override
	public List<Diadiem> findAll() {
		return diadiemRepository.findAll();
	}

	@Override
	public Page<Diadiem> findAll(Pageable pageable) {
		return diadiemRepository.findAll(pageable);
	}

	@Override
	public List<Diadiem> findAll(Sort sort) {
		return diadiemRepository.findAll(sort);
	}

	@Override
	public List<Diadiem> findAllById(Iterable<Long> ids) {
		return diadiemRepository.findAllById(ids);
	}

	@Override
	public Optional<Diadiem> findById(Long id) {
		return diadiemRepository.findById(id);
	}

	@Override
	public <S extends Diadiem> List<S> saveAll(Iterable<S> entities) {
		return diadiemRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		diadiemRepository.flush();
	}

	@Override
	public <S extends Diadiem> S saveAndFlush(S entity) {
		return diadiemRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return diadiemRepository.existsById(id);
	}

	@Override
	public <S extends Diadiem> List<S> saveAllAndFlush(Iterable<S> entities) {
		return diadiemRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Diadiem> Page<S> findAll(Example<S> example, Pageable pageable) {
		return diadiemRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Diadiem> entities) {
		diadiemRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Diadiem> long count(Example<S> example) {
		return diadiemRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Diadiem> entities) {
		diadiemRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return diadiemRepository.count();
	}

	@Override
	public <S extends Diadiem> boolean exists(Example<S> example) {
		return diadiemRepository.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		diadiemRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		diadiemRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Diadiem entity) {
		diadiemRepository.delete(entity);
	}

	@Override
	public <S extends Diadiem, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return diadiemRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		diadiemRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		diadiemRepository.deleteAllInBatch();
	}

	@Override
	public Diadiem getOne(Long id) {
		return diadiemRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Diadiem> entities) {
		diadiemRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		diadiemRepository.deleteAll();
	}

	@Override
	public Diadiem getById(Long id) {
		return diadiemRepository.getById(id);
	}

	@Override
	public <S extends Diadiem> List<S> findAll(Example<S> example) {
		return diadiemRepository.findAll(example);
	}

	@Override
	public <S extends Diadiem> List<S> findAll(Example<S> example, Sort sort) {
		return diadiemRepository.findAll(example, sort);
	}


	@Override
	public List<Diadiem> findByTourdId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
		
	
}
