package edu.poly.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import edu.poly.shop.domain.Giatour;

public interface GiatourRepository extends JpaRepository<Giatour, Long>{
	@Query(value = "select * from giatour where idtour=?1 and trangthai = 0", nativeQuery = true)
	Giatour finbyIdtour(Long id);
	
	@Query(value = "select max(idgiatour) from tour.giatour", nativeQuery = true)
	Giatour finbyIdMaxgiatour(int idgiatour);
	
	@Query(value = "select * from giatour where trangthai = 0", nativeQuery = true)
	List<Giatour> findAllIdgiatour();
	
	@Modifying
	@Transactional
	@Query(value = "update giatour set trangthai = 2 where idgiatour=?1",nativeQuery = true)
	int updateTrangthaiid(Long id);
}
