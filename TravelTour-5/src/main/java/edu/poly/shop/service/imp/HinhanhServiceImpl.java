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

import edu.poly.shop.domain.Hinhanh;
import edu.poly.shop.repository.HinhanhRepository;
import edu.poly.shop.service.HinhanhService;
@Service
public class HinhanhServiceImpl implements HinhanhService {
	@Autowired
	HinhanhRepository hinhanhRepository;

	public HinhanhServiceImpl(HinhanhRepository hinhanhRepository) {
		super();
		this.hinhanhRepository = hinhanhRepository;
	}
		
	@Override
	public <S extends Hinhanh> S save(S entity) {
		return hinhanhRepository.save(entity);
	}

	@Override
	public <S extends Hinhanh> Optional<S> findOne(Example<S> example) {
		return hinhanhRepository.findOne(example);
	}

	@Override
	public List<Hinhanh> findAll() {
		return hinhanhRepository.findAll();
	}

	@Override
	public Page<Hinhanh> findAll(Pageable pageable) {
		return hinhanhRepository.findAll(pageable);
	}

	@Override
	public List<Hinhanh> findAll(Sort sort) {
		return hinhanhRepository.findAll(sort);
	}

	@Override
	public List<Hinhanh> findAllById(Iterable<Long> ids) {
		return hinhanhRepository.findAllById(ids);
	}

	@Override
	public Optional<Hinhanh> findById(Long id) {
		return hinhanhRepository.findById(id);
	}

	@Override
	public <S extends Hinhanh> List<S> saveAll(Iterable<S> entities) {
		return hinhanhRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		hinhanhRepository.flush();
	}

	@Override
	public <S extends Hinhanh> S saveAndFlush(S entity) {
		return hinhanhRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return hinhanhRepository.existsById(id);
	}

	@Override
	public <S extends Hinhanh> List<S> saveAllAndFlush(Iterable<S> entities) {
		return hinhanhRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Hinhanh> Page<S> findAll(Example<S> example, Pageable pageable) {
		return hinhanhRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Hinhanh> entities) {
		hinhanhRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Hinhanh> long count(Example<S> example) {
		return hinhanhRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Hinhanh> entities) {
		hinhanhRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return hinhanhRepository.count();
	}

	@Override
	public <S extends Hinhanh> boolean exists(Example<S> example) {
		return hinhanhRepository.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		hinhanhRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		hinhanhRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Hinhanh entity) {
		hinhanhRepository.delete(entity);
	}

	@Override
	public <S extends Hinhanh, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return hinhanhRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		hinhanhRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		hinhanhRepository.deleteAllInBatch();
	}

	@Override
	public Hinhanh getOne(Long id) {
		return hinhanhRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Hinhanh> entities) {
		hinhanhRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		hinhanhRepository.deleteAll();
	}

	@Override
	public Hinhanh getById(Long id) {
		return hinhanhRepository.getById(id);
	}

	@Override
	public <S extends Hinhanh> List<S> findAll(Example<S> example) {
		return hinhanhRepository.findAll(example);
	}

	@Override
	public <S extends Hinhanh> List<S> findAll(Example<S> example, Sort sort) {
		return hinhanhRepository.findAll(example, sort);
	}
	
}
