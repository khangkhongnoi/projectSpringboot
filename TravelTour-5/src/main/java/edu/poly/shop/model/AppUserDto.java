package edu.poly.shop.model;


import edu.poly.shop.domain.AppUser;
import lombok.Data;

public class AppUserDto {
	private Long userid;
	private String tentaikhoan;
	private Integer sdt;
	private String email;
	private String password;
	private String confirmPassword;
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getTentaikhoan() {
		return tentaikhoan;
	}
	public void setTentaikhoan(String tentaikhoan) {
		this.tentaikhoan = tentaikhoan;
	}
	public Integer getSdt() {
		return sdt;
	}
	public void setSdt(Integer sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	
}
