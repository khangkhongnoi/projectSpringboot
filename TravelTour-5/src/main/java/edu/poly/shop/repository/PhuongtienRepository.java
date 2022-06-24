package edu.poly.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.poly.shop.domain.Phuongtien;
@Repository
public interface PhuongtienRepository extends JpaRepository<Phuongtien, Long> {

}
