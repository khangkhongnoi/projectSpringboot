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

import edu.poly.shop.domain.Tinh;
import edu.poly.shop.repository.TinhRepository;
import edu.poly.shop.service.TinhService;
@Service
public class TinhServiceImpl implements TinhService {
	@Autowired
		TinhRepository tinhRepository;

		public TinhServiceImpl(TinhRepository tinhRepository) {
			this.tinhRepository = tinhRepository;
		}
		
		

		public Tinh findByIdtinh(Long id) {
			return tinhRepository.findByIdtinh(id);
		}



		@Override
		public List<Tinh> findByTentinhContaining(String tentinh) {
			return tinhRepository.findByTentinhContaining(tentinh);
		}


		@Override
		public Page<Tinh> findByTentinhContaining(String tentinh, Pageable pageable) {
			return tinhRepository.findByTentinhContaining(tentinh, pageable);
		}

		@Override
		public <S extends Tinh> S save(S entity) {
			return tinhRepository.save(entity);
		}

		@Override
		public List<Tinh> findAll() {
			return tinhRepository.findAll();
		}

		@Override
		public Page<Tinh> findAll(Pageable pageable) {
			return tinhRepository.findAll(pageable);
		}

		@Override
		public List<Tinh> findAll(Sort sort) {
			return tinhRepository.findAll(sort);
		}

		@Override
		public List<Tinh> findAllById(Iterable<Long> ids) {
			return tinhRepository.findAllById(ids);
		}

		@Override
		public Optional<Tinh> findById(Long id) {
			return tinhRepository.findById(id);
		}

		@Override
		public <S extends Tinh> List<S> saveAll(Iterable<S> entities) {
			return tinhRepository.saveAll(entities);
		}

		@Override
		public void flush() {
			tinhRepository.flush();
		}

		@Override
		public <S extends Tinh> S saveAndFlush(S entity) {
			return tinhRepository.saveAndFlush(entity);
		}

		@Override
		public boolean existsById(Long id) {
			return tinhRepository.existsById(id);
		}

		@Override
		public <S extends Tinh> List<S> saveAllAndFlush(Iterable<S> entities) {
			return tinhRepository.saveAllAndFlush(entities);
		}

		@Override
		public void deleteInBatch(Iterable<Tinh> entities) {
			tinhRepository.deleteInBatch(entities);
		}

		@Override
		public long count() {
			return tinhRepository.count();
		}

		@Override
		public <S extends Tinh> boolean exists(Example<S> example) {
			return tinhRepository.exists(example);
		}

		@Override
		public void deleteById(Long id) {
			tinhRepository.deleteById(id);
		}

		@Override
		public void deleteAllByIdInBatch(Iterable<Long> ids) {
			tinhRepository.deleteAllByIdInBatch(ids);
		}

		@Override
		public void delete(Tinh entity) {
			tinhRepository.delete(entity);
		}

		@Override
		public <S extends Tinh, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
			return tinhRepository.findBy(example, queryFunction);
		}

		@Override
		public void deleteAllById(Iterable<? extends Long> ids) {
			tinhRepository.deleteAllById(ids);
		}

		@Override
		public void deleteAllInBatch() {
			tinhRepository.deleteAllInBatch();
		}

		@Override
		public void deleteAll() {
			tinhRepository.deleteAll();
		}

		@Override
		public List<Tinh> findByTentinh(String tentinh) {
			return tinhRepository.findByTentinh(tentinh);
		}

	
		
		
}
