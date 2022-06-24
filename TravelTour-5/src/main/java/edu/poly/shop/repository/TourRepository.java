package edu.poly.shop.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import edu.poly.shop.domain.Tour;

@Repository
public interface TourRepository  extends JpaRepository<Tour, Long>{
	Optional<Tour> findById(Long id);
	
	@Query("SELECT p FROM edu.poly.shop.domain.Tour p WHERE p.trangthai= 1")
	 List<Tour> findByTrangthai();
	Tour findByIdtour(Long idtour);
	
//	List<Tour> laychitietsanpham(Long idtour);
//	List<Tour> laysanphamLmit(Long sobatdau);
	@Query(value = "select * from tour.tour  , tour.giatour  where tour.idtour = ?1 and tour.idtour = giatour.idtour", nativeQuery = true)
	Tour findByIdchitiettour(Long idtour);
	
	@Query(value = "SELECT * FROM tour , diadiem", nativeQuery = true )
	List<Tour> findAllIddiadiem();
	
	@Query(value = "SELECT * FROM tour limit 0,6",nativeQuery = true)
	List<Tour> findByIdtourlimit();
	
	@Query(value = "SELECT * FROM tour, hinhanh", nativeQuery = true)
	List<Tour> findByAllHinhanh();
	
	List<Tour> findByTentour(String tentour);
}
