package edu.poly.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.poly.shop.domain.Phieudat;

@Repository
public interface PhieudatRepository extends JpaRepository<Phieudat, Long> {
	
}
