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

import edu.poly.shop.domain.Hoadon;
import edu.poly.shop.repository.Hoadonrepository;
import edu.poly.shop.service.HoadonService;

@Service
public class HoadonServiceImpl implements HoadonService {
	@Autowired
	Hoadonrepository hoadonrepository;

	public HoadonServiceImpl(Hoadonrepository hoadonrepository) {
		super();
		this.hoadonrepository = hoadonrepository;
	}

	@Override
	public <S extends Hoadon> S save(S entity) {
		return hoadonrepository.save(entity);
	}

	@Override
	public <S extends Hoadon> Optional<S> findOne(Example<S> example) {
		return hoadonrepository.findOne(example);
	}

	@Override
	public List<Hoadon> findAll() {
		return hoadonrepository.findAll();
	}

	@Override
	public Page<Hoadon> findAll(Pageable pageable) {
		return hoadonrepository.findAll(pageable);
	}

	@Override
	public List<Hoadon> findAll(Sort sort) {
		return hoadonrepository.findAll(sort);
	}

	@Override
	public List<Hoadon> findAllById(Iterable<Long> ids) {
		return hoadonrepository.findAllById(ids);
	}

	@Override
	public Optional<Hoadon> findById(Long id) {
		return hoadonrepository.findById(id);
	}

	@Override
	public <S extends Hoadon> List<S> saveAll(Iterable<S> entities) {
		return hoadonrepository.saveAll(entities);
	}

	@Override
	public void flush() {
		hoadonrepository.flush();
	}

	@Override
	public <S extends Hoadon> S saveAndFlush(S entity) {
		return hoadonrepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return hoadonrepository.existsById(id);
	}

	@Override
	public <S extends Hoadon> List<S> saveAllAndFlush(Iterable<S> entities) {
		return hoadonrepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Hoadon> Page<S> findAll(Example<S> example, Pageable pageable) {
		return hoadonrepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Hoadon> entities) {
		hoadonrepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Hoadon> long count(Example<S> example) {
		return hoadonrepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Hoadon> entities) {
		hoadonrepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return hoadonrepository.count();
	}

	@Override
	public <S extends Hoadon> boolean exists(Example<S> example) {
		return hoadonrepository.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		hoadonrepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		hoadonrepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Hoadon entity) {
		hoadonrepository.delete(entity);
	}

	@Override
	public <S extends Hoadon, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return hoadonrepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		hoadonrepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		hoadonrepository.deleteAllInBatch();
	}

	@Override
	public Hoadon getOne(Long id) {
		return hoadonrepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Hoadon> entities) {
		hoadonrepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		hoadonrepository.deleteAll();
	}

	@Override
	public Hoadon getById(Long id) {
		return hoadonrepository.getById(id);
	}

	@Override
	public <S extends Hoadon> List<S> findAll(Example<S> example) {
		return hoadonrepository.findAll(example);
	}

	@Override
	public <S extends Hoadon> List<S> findAll(Example<S> example, Sort sort) {
		return hoadonrepository.findAll(example, sort);
	}
	
}
