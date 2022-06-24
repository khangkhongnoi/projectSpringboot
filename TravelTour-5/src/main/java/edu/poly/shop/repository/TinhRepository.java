package edu.poly.shop.repository;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.poly.shop.domain.Tinh;
import edu.poly.shop.domain.Tour;
@Repository
public interface TinhRepository extends JpaRepository<Tinh, Long > {
	List<Tinh> findByTentinhContaining(String tentinh);
	Page<Tinh> findByTentinhContaining(String tentinh, Pageable pageable );
	List<Tinh> findByTentinh(String tentinh);
	Tinh findByIdtinh(Long id);
	
	
}
