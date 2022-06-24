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
public class TaikhoanDto {
	@NotEmpty
	@Length(min = 6)
	private String tentaikhoan;
	@NotEmpty
	private String email;
	@NotEmpty
	@Length(min = 6)
	private String password;
	private Long idnhanvien;
	private Long idkhachhang;
	private Boolean rememberMe = false;
	private Boolean isEdit = false;
}
