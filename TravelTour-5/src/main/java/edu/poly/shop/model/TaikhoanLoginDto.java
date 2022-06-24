package edu.poly.shop.model;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaikhoanLoginDto {
	@NotEmpty
	private String email;
	@NotEmpty
	private String password;
	private Long idnhanvien;
	private Long idkhachhang;
	private Boolean rememberMe = false;
	private Boolean isEdit = false;
}
