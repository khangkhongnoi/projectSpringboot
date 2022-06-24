package edu.poly.shop.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NhanvienDto {
	private Long idnhanvien;
	private Long idchucvu;
	private String tennhanvien;
	private int cmnd;
	private int sdt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngaysinh;
	private String gioitinh;
	private String email;
	private String diachi;
	private Boolean isEdit = false;
}
