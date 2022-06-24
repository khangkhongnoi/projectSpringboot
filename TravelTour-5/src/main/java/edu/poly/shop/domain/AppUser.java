package edu.poly.shop.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Proxy;
import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Proxy(lazy=false)
@Table(name = "App_User")
public class AppUser implements Serializable {
//	public Taikhoan(String tentaikhoan2, String password2, List<GrantedAuthority> grantList) {
//		this.tentaikhoan = tentaikhoan2;
//		this.password = password2;
//	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "User_id")
	private Long userid;
	@Column(name="tentaikhoan")
	private String tentaikhoan;
	@Column(name = "sdt",unique = true)
	private Integer sdt;
	@Column( length= 45)
	private String email;
	@Column(nullable = false, length = 64)
	private String password;
	@Transient
	private String confirmPassword;
//	@OneToOne
//	@JoinColumn(name = "idkhachhang")
//    private Khachhang khachhang;
	@ManyToOne
	@JoinColumn(name = "idkhachhang")
	private Khachhang khachhang;
	
	@ManyToOne
	@JoinColumn(name = "idnhanvien")
	private Nhanvien nhanvien;
	
//	@ManyToMany
//	@JoinTable(
//	  name = "User_role", 
//	  joinColumns = @JoinColumn(name = "User_id"), 
//	  inverseJoinColumns = @JoinColumn(name = "Role_id"))
//	Set<AppRole> appRoles;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "appUser")
	Set<UserRole> roles;
}
