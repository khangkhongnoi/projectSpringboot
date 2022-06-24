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

import edu.poly.shop.domain.Loaitour;
import edu.poly.shop.repository.LoaitourRepository;
import edu.poly.shop.service.LoaitourService;

@Service
public class LoaitourServiceImpl implements LoaitourService {
	@Autowired
	LoaitourRepository loaitourRepository;

	public LoaitourServiceImpl(LoaitourRepository loaitourRepository) {
		super();
		this.loaitourRepository = loaitourRepository;
	}

	@Override
	public <S extends Loaitour> S save(S entity) {
		return loaitourRepository.save(entity);
	}

	@Override
	public <S extends Loaitour> Optional<S> findOne(Example<S> example) {
		return loaitourRepository.findOne(example);
	}

	@Override
	public List<Loaitour> findAll() {
		return loaitourRepository.findAll();
	}

	@Override
	public Page<Loaitour> findAll(Pageable pageable) {
		return loaitourRepository.findAll(pageable);
	}

	@Override
	public List<Loaitour> findAll(Sort sort) {
		return loaitourRepository.findAll(sort);
	}

	@Override
	public List<Loaitour> findAllById(Iterable<Long> ids) {
		return loaitourRepository.findAllById(ids);
	}

	@Override
	public Optional<Loaitour> findById(Long id) {
		return loaitourRepository.findById(id);
	}

	@Override
	public <S extends Loaitour> List<S> saveAll(Iterable<S> entities) {
		return loaitourRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		loaitourRepository.flush();
	}

	@Override
	public <S extends Loaitour> S saveAndFlush(S entity) {
		return loaitourRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return loaitourRepository.existsById(id);
	}

	@Override
	public <S extends Loaitour> List<S> saveAllAndFlush(Iterable<S> entities) {
		return loaitourRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Loaitour> Page<S> findAll(Example<S> example, Pageable pageable) {
		return loaitourRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Loaitour> entities) {
		loaitourRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Loaitour> long count(Example<S> example) {
		return loaitourRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Loaitour> entities) {
		loaitourRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return loaitourRepository.count();
	}

	@Override
	public <S extends Loaitour> boolean exists(Example<S> example) {
		return loaitourRepository.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		loaitourRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		loaitourRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Loaitour entity) {
		loaitourRepository.delete(entity);
	}

	@Override
	public <S extends Loaitour, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return loaitourRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		loaitourRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		loaitourRepository.deleteAllInBatch();
	}

	@Override
	public Loaitour getOne(Long id) {
		return loaitourRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Loaitour> entities) {
		loaitourRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		loaitourRepository.deleteAll();
	}

	@Override
	public Loaitour getById(Long id) {
		return loaitourRepository.getById(id);
	}

	@Override
	public <S extends Loaitour> List<S> findAll(Example<S> example) {
		return loaitourRepository.findAll(example);
	}

	@Override
	public <S extends Loaitour> List<S> findAll(Example<S> example, Sort sort) {
		return loaitourRepository.findAll(example, sort);
	}
	
}
