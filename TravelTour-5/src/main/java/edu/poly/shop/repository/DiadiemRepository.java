package edu.poly.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.poly.shop.domain.Diadiem;
@Repository
public interface DiadiemRepository  extends JpaRepository<Diadiem, Long>{
	@Query("SELECT p FROM edu.poly.shop.model.DiadiemDto p WHERE p.idtinh=?1")
	List<Diadiem> findByIdtinh(Long idtinh);
}
