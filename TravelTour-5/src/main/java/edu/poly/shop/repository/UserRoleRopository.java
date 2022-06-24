package edu.poly.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.poly.shop.domain.AppUser;
import edu.poly.shop.domain.UserRole;

public interface UserRoleRopository extends JpaRepository<UserRole, Long> {
	List<UserRole> findByAppUser(AppUser appUser);
}
