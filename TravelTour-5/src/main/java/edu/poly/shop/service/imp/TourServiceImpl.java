package edu.poly.shop.service.imp;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import edu.poly.shop.domain.Tour;
import edu.poly.shop.repository.TourRepository;
import edu.poly.shop.service.TourService;
@Service
public class TourServiceImpl implements TourService {
	@Autowired
	TourRepository tourRepository;
	@Autowired
	SessionFactory sessionFactory;
	public TourServiceImpl(TourRepository tourRepository) {
		this.tourRepository = tourRepository;
	}
	

	@Override
	public List<Tour> findByTentour(String tentour) {
		return tourRepository.findByTentour(tentour);
	}


	@Override
	public List<Tour> findByIdtourlimit() {
		return tourRepository.findByIdtourlimit();
	}


	@Override
	public List<Tour> findByAllHinhanh() {
		return tourRepository.findByAllHinhanh();
	}


	@Override
	public List<Tour> findAllIddiadiem() {
		return tourRepository.findAllIddiadiem();
	}


	@Override
	public Tour findByIdtour(Long idtour) {
		return tourRepository.findByIdtour(idtour);
	}


	@Override
	public <S extends Tour> S save(S entity) {
		return tourRepository.save(entity);
	}

	@Override
	public List<Tour> findAll() {
		return tourRepository.findAll();
	}

	@Override
	public Page<Tour> findAll(Pageable pageable) {
		return tourRepository.findAll(pageable);
	}
	
	@Override
	public List<Tour> findAll(Sort sort) {
		return tourRepository.findAll(sort);
	}

	@Override
	public List<Tour> findAllById(Iterable<Long> ids) {
		return tourRepository.findAllById(ids);
	}

	@Override
	public Optional<Tour> findById(Long id) {
		return tourRepository.findById(id);
	}

	@Override
	public <S extends Tour> List<S> saveAll(Iterable<S> entities) {
		return tourRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		tourRepository.flush();
	}

	@Override
	public <S extends Tour> S saveAndFlush(S entity) {
		return tourRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return tourRepository.existsById(id);
	}

	@Override
	public <S extends Tour> List<S> saveAllAndFlush(Iterable<S> entities) {
		return tourRepository.saveAllAndFlush(entities);
	}

	@Override
	public void deleteInBatch(Iterable<Tour> entities) {
		tourRepository.deleteInBatch(entities);
	}

	@Override
	public void deleteAllInBatch(Iterable<Tour> entities) {
		tourRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return tourRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		tourRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		tourRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Tour entity) {
		tourRepository.delete(entity);
	}

	@Override
	public <S extends Tour, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return tourRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		tourRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		tourRepository.deleteAllInBatch();
	}

	@Override
	public Tour getOne(Long id) {
		return tourRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Tour> entities) {
		tourRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		tourRepository.deleteAll();
	}
//	@Override
//	public List<Tour> findByTourdId(Long id) {
//		return tourRepository.findByTourdId(id);
//	}


//	@Override
//	public List<Tour> findByIdchitiettour(Long idtour) {
//		return tourRepository.findByIdchitiettour(idtour);
//	}


//	public List<Tour> laysanphamLmit(Long sobatdau) {
//		
//		return tourRepository.laysanphamLmit(sobatdau);
//	}
	
	
	
	
}
