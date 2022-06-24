package edu.poly.shop.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KhachhangDto implements Serializable {
	private Long idkhachhang;
	private Long idphieudat;
	private String tentaikhoan ;
	private String ten;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngaysinh;
	private int cmnd;
	private String diachi;
	private int sdt;
	private String email;
	private String gioitinh;
	private Boolean isEdit = false;
	
}
