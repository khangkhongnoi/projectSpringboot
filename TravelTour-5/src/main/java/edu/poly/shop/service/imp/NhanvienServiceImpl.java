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

import edu.poly.shop.domain.Nhanvien;
import edu.poly.shop.repository.NhanvienRepository;
import edu.poly.shop.service.NhanvienService;
@Service
public class NhanvienServiceImpl implements NhanvienService {
	@Autowired
	NhanvienRepository nhanvienRepository;

	public NhanvienServiceImpl(NhanvienRepository nhanvienRepository) {
		super();
		this.nhanvienRepository = nhanvienRepository;
	}
	
	@Override
	public List<Nhanvien> findByTennhanvien(String tennhanvien) {
		return nhanvienRepository.findByTennhanvien(tennhanvien);
	}

	@Override
	public <S extends Nhanvien> S save(S entity) {
		return nhanvienRepository.save(entity);
	}

	@Override
	public <S extends Nhanvien> Optional<S> findOne(Example<S> example) {
		return nhanvienRepository.findOne(example);
	}

	@Override
	public List<Nhanvien> findAll() {
		return nhanvienRepository.findAll();
	}

	@Override
	public Page<Nhanvien> findAll(Pageable pageable) {
		return nhanvienRepository.findAll(pageable);
	}

	@Override
	public List<Nhanvien> findAll(Sort sort) {
		return nhanvienRepository.findAll(sort);
	}

	@Override
	public List<Nhanvien> findAllById(Iterable<Long> ids) {
		return nhanvienRepository.findAllById(ids);
	}

	@Override
	public Optional<Nhanvien> findById(Long id) {
		return nhanvienRepository.findById(id);
	}

	@Override
	public <S extends Nhanvien> List<S> saveAll(Iterable<S> entities) {
		return nhanvienRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		nhanvienRepository.flush();
	}

	@Override
	public <S extends Nhanvien> S saveAndFlush(S entity) {
		return nhanvienRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return nhanvienRepository.existsById(id);
	}

	@Override
	public <S extends Nhanvien> List<S> saveAllAndFlush(Iterable<S> entities) {
		return nhanvienRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Nhanvien> Page<S> findAll(Example<S> example, Pageable pageable) {
		return nhanvienRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Nhanvien> entities) {
		nhanvienRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Nhanvien> long count(Example<S> example) {
		return nhanvienRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Nhanvien> entities) {
		nhanvienRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return nhanvienRepository.count();
	}

	@Override
	public <S extends Nhanvien> boolean exists(Example<S> example) {
		return nhanvienRepository.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		nhanvienRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		nhanvienRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Nhanvien entity) {
		nhanvienRepository.delete(entity);
	}

	@Override
	public <S extends Nhanvien, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return nhanvienRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		nhanvienRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		nhanvienRepository.deleteAllInBatch();
	}

	@Override
	public Nhanvien getOne(Long id) {
		return nhanvienRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Nhanvien> entities) {
		nhanvienRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		nhanvienRepository.deleteAll();
	}

	@Override
	public Nhanvien getById(Long id) {
		return nhanvienRepository.getById(id);
	}

	@Override
	public <S extends Nhanvien> List<S> findAll(Example<S> example) {
		return nhanvienRepository.findAll(example);
	}

	@Override
	public <S extends Nhanvien> List<S> findAll(Example<S> example, Sort sort) {
		return nhanvienRepository.findAll(example, sort);
	}

	
	
	
}
