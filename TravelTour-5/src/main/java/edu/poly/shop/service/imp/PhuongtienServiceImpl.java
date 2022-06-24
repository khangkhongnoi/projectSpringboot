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

import edu.poly.shop.domain.Phuongtien;
import edu.poly.shop.repository.PhuongtienRepository;
import edu.poly.shop.service.PhuongtienService;
@Service
public class PhuongtienServiceImpl implements PhuongtienService {
	@Autowired
		PhuongtienRepository phuongtienRepository;

		public PhuongtienServiceImpl(PhuongtienRepository phuongtienRepository) {
			this.phuongtienRepository = phuongtienRepository;
		}

		@Override
		public <S extends Phuongtien> S save(S entity) {
			return phuongtienRepository.save(entity);
		}

		@Override
		public <S extends Phuongtien> Optional<S> findOne(Example<S> example) {
			return phuongtienRepository.findOne(example);
		}

		@Override
		public List<Phuongtien> findAll() {
			return phuongtienRepository.findAll();
		}

		@Override
		public Page<Phuongtien> findAll(Pageable pageable) {
			return phuongtienRepository.findAll(pageable);
		}

		@Override
		public List<Phuongtien> findAll(Sort sort) {
			return phuongtienRepository.findAll(sort);
		}

		@Override
		public List<Phuongtien> findAllById(Iterable<Long> ids) {
			return phuongtienRepository.findAllById(ids);
		}

		@Override
		public Optional<Phuongtien> findById(Long id) {
			return phuongtienRepository.findById(id);
		}

		@Override
		public <S extends Phuongtien> List<S> saveAll(Iterable<S> entities) {
			return phuongtienRepository.saveAll(entities);
		}

		@Override
		public void flush() {
			phuongtienRepository.flush();
		}

		@Override
		public <S extends Phuongtien> S saveAndFlush(S entity) {
			return phuongtienRepository.saveAndFlush(entity);
		}

		@Override
		public boolean existsById(Long id) {
			return phuongtienRepository.existsById(id);
		}

		@Override
		public <S extends Phuongtien> List<S> saveAllAndFlush(Iterable<S> entities) {
			return phuongtienRepository.saveAllAndFlush(entities);
		}

		@Override
		public <S extends Phuongtien> Page<S> findAll(Example<S> example, Pageable pageable) {
			return phuongtienRepository.findAll(example, pageable);
		}

		@Override
		public void deleteInBatch(Iterable<Phuongtien> entities) {
			phuongtienRepository.deleteInBatch(entities);
		}

		@Override
		public <S extends Phuongtien> long count(Example<S> example) {
			return phuongtienRepository.count(example);
		}

		@Override
		public void deleteAllInBatch(Iterable<Phuongtien> entities) {
			phuongtienRepository.deleteAllInBatch(entities);
		}

		@Override
		public long count() {
			return phuongtienRepository.count();
		}

		@Override
		public <S extends Phuongtien> boolean exists(Example<S> example) {
			return phuongtienRepository.exists(example);
		}

		@Override
		public void deleteById(Long id) {
			phuongtienRepository.deleteById(id);
		}

		@Override
		public void deleteAllByIdInBatch(Iterable<Long> ids) {
			phuongtienRepository.deleteAllByIdInBatch(ids);
		}

		@Override
		public void delete(Phuongtien entity) {
			phuongtienRepository.delete(entity);
		}

		@Override
		public <S extends Phuongtien, R> R findBy(Example<S> example,
				Function<FetchableFluentQuery<S>, R> queryFunction) {
			return phuongtienRepository.findBy(example, queryFunction);
		}

		@Override
		public void deleteAllById(Iterable<? extends Long> ids) {
			phuongtienRepository.deleteAllById(ids);
		}

		@Override
		public void deleteAllInBatch() {
			phuongtienRepository.deleteAllInBatch();
		}

		@Override
		public Phuongtien getOne(Long id) {
			return phuongtienRepository.getOne(id);
		}

		@Override
		public void deleteAll(Iterable<? extends Phuongtien> entities) {
			phuongtienRepository.deleteAll(entities);
		}

		@Override
		public void deleteAll() {
			phuongtienRepository.deleteAll();
		}

		@Override
		public Phuongtien getById(Long id) {
			return phuongtienRepository.getById(id);
		}

		@Override
		public <S extends Phuongtien> List<S> findAll(Example<S> example) {
			return phuongtienRepository.findAll(example);
		}

		@Override
		public <S extends Phuongtien> List<S> findAll(Example<S> example, Sort sort) {
			return phuongtienRepository.findAll(example, sort);
		}
		
		
}
