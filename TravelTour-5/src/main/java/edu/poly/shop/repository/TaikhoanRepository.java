package edu.poly.shop.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.poly.shop.domain.AppUser;
@Repository
public interface TaikhoanRepository extends JpaRepository<AppUser, String> {
	
	Optional<AppUser> findByEmail(String email);
	@Query( value = "select tour.taikhoan.tentaikhoan from tour.taikhoan where tour.taikhoan.email=:email",nativeQuery = true)
	AppUser finByEmailtaikhoan(@Param("email")String email);
	AppUser findByTentaikhoan(String tentaikhoan);
	
	@Query( value = "select tour.taikhoan.role_name from tour.taikhoan where tentaikhoan = ?1",nativeQuery = true)
	List<AppUser> findByGetRole(AppUser tentaikhoan);
	
	// LAY RA ROLE CUA TAI KHOAN
	@Query(value = "select tour.taikhoan.role_name from tour.taikhoan where tentaikhoan = ?1", nativeQuery = true)
	List<String> findByRoleName(String tentaikhoan);

//	List<Taikhoan> findByGetRole(Taikhoan tentaikhoan);
}
