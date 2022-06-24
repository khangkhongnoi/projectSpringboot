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

import edu.poly.shop.domain.Giatour;
import edu.poly.shop.repository.GiatourRepository;
import edu.poly.shop.service.GiatourService;
@Service
public class GiatourServiceImpl implements GiatourService {

	@Autowired
	GiatourRepository giatourRepository;

	public GiatourServiceImpl(GiatourRepository giatourRepository) {
		super();
		this.giatourRepository = giatourRepository;
	}
	
	
	@Override
	public List<Giatour> findAllIdgiatour() {
		return giatourRepository.findAllIdgiatour();
	}
	





	@Override
	public int updateTrangthaiid(Long id) {
		return giatourRepository.updateTrangthaiid(id);
	}


	@Override
	public <S extends Giatour> S save(S entity) {
		return giatourRepository.save(entity);
	}

	@Override
	public <S extends Giatour> Optional<S> findOne(Example<S> example) {
		return giatourRepository.findOne(example);
	}

	@Override
	public List<Giatour> findAll() {
		return giatourRepository.findAll();
	}

	@Override
	public Page<Giatour> findAll(Pageable pageable) {
		return giatourRepository.findAll(pageable);
	}

	@Override
	public List<Giatour> findAll(Sort sort) {
		return giatourRepository.findAll(sort);
	}

	@Override
	public List<Giatour> findAllById(Iterable<Long> ids) {
		return giatourRepository.findAllById(ids);
	}

	@Override
	public Optional<Giatour> findById(Long id) {
		return giatourRepository.findById(id);
	}

	@Override
	public <S extends Giatour> List<S> saveAll(Iterable<S> entities) {
		return giatourRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		giatourRepository.flush();
	}

	@Override
	public <S extends Giatour> S saveAndFlush(S entity) {
		return giatourRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return giatourRepository.existsById(id);
	}

	@Override
	public <S extends Giatour> List<S> saveAllAndFlush(Iterable<S> entities) {
		return giatourRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Giatour> Page<S> findAll(Example<S> example, Pageable pageable) {
		return giatourRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Giatour> entities) {
		giatourRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Giatour> long count(Example<S> example) {
		return giatourRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Giatour> entities) {
		giatourRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return giatourRepository.count();
	}

	@Override
	public <S extends Giatour> boolean exists(Example<S> example) {
		return giatourRepository.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		giatourRepository.deleteById(id);
	}



	@Override
	public void delete(Giatour entity) {
		giatourRepository.delete(entity);
	}

	@Override
	public <S extends Giatour, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return giatourRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		giatourRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		giatourRepository.deleteAllInBatch();
	}

	@Override
	public Giatour getOne(Long id) {
		return giatourRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Giatour> entities) {
		giatourRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		giatourRepository.deleteAll();
	}

	@Override
	public Giatour getById(Long id) {
		return giatourRepository.getById(id);
	}

	@Override
	public <S extends Giatour> List<S> findAll(Example<S> example) {
		return giatourRepository.findAll(example);
	}

	@Override
	public <S extends Giatour> List<S> findAll(Example<S> example, Sort sort) {
		return giatourRepository.findAll(example, sort);
	}
	
}
