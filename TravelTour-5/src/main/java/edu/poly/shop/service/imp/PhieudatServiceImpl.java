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

import edu.poly.shop.domain.Phieudat;
import edu.poly.shop.repository.PhieudatRepository;
import edu.poly.shop.service.PhieudatService;

@Service
public class PhieudatServiceImpl implements PhieudatService {
	@Autowired
	PhieudatRepository phieudatRepository;

	public PhieudatServiceImpl(PhieudatRepository phieudatRepository) {
		super();
		this.phieudatRepository = phieudatRepository;
	}

	@Override
	public <S extends Phieudat> S save(S entity) {
		return phieudatRepository.save(entity);
	}

	@Override
	public <S extends Phieudat> Optional<S> findOne(Example<S> example) {
		return phieudatRepository.findOne(example);
	}

	@Override
	public List<Phieudat> findAll() {
		return phieudatRepository.findAll();
	}

	@Override
	public Page<Phieudat> findAll(Pageable pageable) {
		return phieudatRepository.findAll(pageable);
	}

	@Override
	public List<Phieudat> findAll(Sort sort) {
		return phieudatRepository.findAll(sort);
	}

	@Override
	public List<Phieudat> findAllById(Iterable<Long> ids) {
		return phieudatRepository.findAllById(ids);
	}

	@Override
	public Optional<Phieudat> findById(Long id) {
		return phieudatRepository.findById(id);
	}

	@Override
	public <S extends Phieudat> List<S> saveAll(Iterable<S> entities) {
		return phieudatRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		phieudatRepository.flush();
	}

	@Override
	public <S extends Phieudat> S saveAndFlush(S entity) {
		return phieudatRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return phieudatRepository.existsById(id);
	}

	@Override
	public <S extends Phieudat> List<S> saveAllAndFlush(Iterable<S> entities) {
		return phieudatRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Phieudat> Page<S> findAll(Example<S> example, Pageable pageable) {
		return phieudatRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Phieudat> entities) {
		phieudatRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Phieudat> long count(Example<S> example) {
		return phieudatRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Phieudat> entities) {
		phieudatRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return phieudatRepository.count();
	}

	@Override
	public <S extends Phieudat> boolean exists(Example<S> example) {
		return phieudatRepository.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		phieudatRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		phieudatRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Phieudat entity) {
		phieudatRepository.delete(entity);
	}

	@Override
	public <S extends Phieudat, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return phieudatRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		phieudatRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		phieudatRepository.deleteAllInBatch();
	}

	@Override
	public Phieudat getOne(Long id) {
		return phieudatRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Phieudat> entities) {
		phieudatRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		phieudatRepository.deleteAll();
	}

	@Override
	public Phieudat getById(Long id) {
		return phieudatRepository.getById(id);
	}

	@Override
	public <S extends Phieudat> List<S> findAll(Example<S> example) {
		return phieudatRepository.findAll(example);
	}

	@Override
	public <S extends Phieudat> List<S> findAll(Example<S> example, Sort sort) {
		return phieudatRepository.findAll(example, sort);
	}
	
	
}
