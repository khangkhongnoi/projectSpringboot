package edu.poly.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.poly.shop.domain.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	AppUser  findByTentaikhoan(String tentaikhoan);
}
