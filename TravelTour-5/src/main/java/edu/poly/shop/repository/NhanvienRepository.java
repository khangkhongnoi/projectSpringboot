package edu.poly.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.poly.shop.domain.Nhanvien;

@Repository
public interface NhanvienRepository extends JpaRepository<Nhanvien, Long> {
	List<Nhanvien> findByTennhanvien(String tennhanvien);
}
