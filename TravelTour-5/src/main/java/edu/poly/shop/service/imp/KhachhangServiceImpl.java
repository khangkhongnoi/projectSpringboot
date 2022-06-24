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

import edu.poly.shop.domain.Khachhang;
import edu.poly.shop.repository.KhachhangRepository;
import edu.poly.shop.service.KhachhangService;

@Service
public class KhachhangServiceImpl implements KhachhangService {
		@Autowired
		KhachhangRepository khachhangRepository;

		public KhachhangServiceImpl(KhachhangRepository khachhangRepository) {
			super();
			this.khachhangRepository = khachhangRepository;
		}

		@Override
		public <S extends Khachhang> S save(S entity) {
			return khachhangRepository.save(entity);
		}

		@Override
		public <S extends Khachhang> Optional<S> findOne(Example<S> example) {
			return khachhangRepository.findOne(example);
		}

		@Override
		public List<Khachhang> findAll() {
			return khachhangRepository.findAll();
		}

		@Override
		public Page<Khachhang> findAll(Pageable pageable) {
			return khachhangRepository.findAll(pageable);
		}

		@Override
		public List<Khachhang> findAll(Sort sort) {
			return khachhangRepository.findAll(sort);
		}

		@Override
		public List<Khachhang> findAllById(Iterable<Long> ids) {
			return khachhangRepository.findAllById(ids);
		}

		@Override
		public Optional<Khachhang> findById(Long id) {
			return khachhangRepository.findById(id);
		}

		@Override
		public <S extends Khachhang> List<S> saveAll(Iterable<S> entities) {
			return khachhangRepository.saveAll(entities);
		}

		@Override
		public void flush() {
			khachhangRepository.flush();
		}

		@Override
		public <S extends Khachhang> S saveAndFlush(S entity) {
			return khachhangRepository.saveAndFlush(entity);
		}

		@Override
		public boolean existsById(Long id) {
			return khachhangRepository.existsById(id);
		}

		@Override
		public <S extends Khachhang> List<S> saveAllAndFlush(Iterable<S> entities) {
			return khachhangRepository.saveAllAndFlush(entities);
		}

		@Override
		public <S extends Khachhang> Page<S> findAll(Example<S> example, Pageable pageable) {
			return khachhangRepository.findAll(example, pageable);
		}

		@Override
		public void deleteInBatch(Iterable<Khachhang> entities) {
			khachhangRepository.deleteInBatch(entities);
		}

		@Override
		public <S extends Khachhang> long count(Example<S> example) {
			return khachhangRepository.count(example);
		}

		@Override
		public void deleteAllInBatch(Iterable<Khachhang> entities) {
			khachhangRepository.deleteAllInBatch(entities);
		}

		@Override
		public long count() {
			return khachhangRepository.count();
		}

		@Override
		public <S extends Khachhang> boolean exists(Example<S> example) {
			return khachhangRepository.exists(example);
		}

		@Override
		public void deleteById(Long id) {
			khachhangRepository.deleteById(id);
		}

		@Override
		public void deleteAllByIdInBatch(Iterable<Long> ids) {
			khachhangRepository.deleteAllByIdInBatch(ids);
		}

		@Override
		public void delete(Khachhang entity) {
			khachhangRepository.delete(entity);
		}

		@Override
		public <S extends Khachhang, R> R findBy(Example<S> example,
				Function<FetchableFluentQuery<S>, R> queryFunction) {
			return khachhangRepository.findBy(example, queryFunction);
		}

		@Override
		public void deleteAllById(Iterable<? extends Long> ids) {
			khachhangRepository.deleteAllById(ids);
		}

		@Override
		public void deleteAllInBatch() {
			khachhangRepository.deleteAllInBatch();
		}

		@Override
		public Khachhang getOne(Long id) {
			return khachhangRepository.getOne(id);
		}

		@Override
		public void deleteAll(Iterable<? extends Khachhang> entities) {
			khachhangRepository.deleteAll(entities);
		}

		@Override
		public void deleteAll() {
			khachhangRepository.deleteAll();
		}

		@Override
		public Khachhang getById(Long id) {
			return khachhangRepository.getById(id);
		}

		@Override
		public <S extends Khachhang> List<S> findAll(Example<S> example) {
			return khachhangRepository.findAll(example);
		}

		@Override
		public <S extends Khachhang> List<S> findAll(Example<S> example, Sort sort) {
			return khachhangRepository.findAll(example, sort);
		}
		
}
