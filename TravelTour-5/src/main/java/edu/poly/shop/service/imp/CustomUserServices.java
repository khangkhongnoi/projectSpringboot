package edu.poly.shop.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.poly.shop.domain.AppUser;
import edu.poly.shop.domain.UserRole;
import edu.poly.shop.domain.AppRole;
import edu.poly.shop.repository.AppUserRepository;
import edu.poly.shop.repository.TaikhoanRepository;

import edu.poly.shop.repository.UserRoleRopository;
import edu.poly.shop.service.TaikhoanService;

@Service
public class CustomUserServices implements UserDetailsService{
	@Autowired
	TaikhoanService taikhoanService;

//	@Autowired 
//	UserRoleRepository userRoleRepository;
	@Autowired
	AppUserRepository appUserRepository;
	@Autowired
	UserRoleRopository userRoleRopository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser tentaikhoan = this.appUserRepository.findByTentaikhoan(username);
		System.out.println("not uesname roi" + tentaikhoan);
		if(tentaikhoan == null) {
			System.out.println("not uesname roi" + username);
			 throw new UsernameNotFoundException("User " + username + " was not found in the database");

		}
		System.out.println("Found User: " + tentaikhoan);
		List<UserRole> userRoles = this.userRoleRopository.findByAppUser(tentaikhoan);
		 List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		 System.out.println("Found ss: " + userRoles);
	        if (userRoles != null) {
	            for (UserRole userRole : userRoles) {
	                // ROLE_USER, ROLE_ADMIN,..
	                GrantedAuthority authority = new SimpleGrantedAuthority(userRole.getAppRole().getRoleName());
	                grantList.add(authority);
	                System.out.println("Found ss: " + userRole);
	            }
	            
	        }
	        else {
            	System.out.println("loi ban khong thuoc roiel nao");
            }
//		if(listuser.size() > 0) {
//			Taikhoan taikhoan = listuser.get(0);
//			
//
//		        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
//		        
//		                GrantedAuthority authority = new SimpleGrantedAuthority("admin");
//		                grantList.add(authority);
//
//			UserDetails userDetails = new User(taikhoan.getTentaikhoan(), taikhoan.getPassword(), grantList);
//			return userDetails;
//		}else {
//			new UsernameNotFoundException("dm");
//		}
//		return null;
	 //     UserDetails userDetails = new User(taikhoan.getTentaikhoan(), taikhoan.getPassword(), grantList);
	        UserDetails userDetails = (UserDetails) new User(tentaikhoan.getTentaikhoan(), //
	        		tentaikhoan.getPassword(), grantList);

	     
	        return userDetails;
	}

}
