package edu.poly.shop.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhuongtienDto implements Serializable {
	private Long idphuongtien;
	private String tenphuongtien;
	private int succhua;
	private String tinhtrang;
	private Boolean isEdit = false;
	public Long getIdphuongtien() {
		return idphuongtien;
	}
	public void setIdphuongtien(Long idphuongtien) {
		this.idphuongtien = idphuongtien;
	}
	public String getTenphuongtien() {
		return tenphuongtien;
	}
	public void setTenphuongtien(String tenphuongtien) {
		this.tenphuongtien = tenphuongtien;
	}
	public int getSucchua() {
		return succhua;
	}
	public void setSucchua(int succhua) {
		this.succhua = succhua;
	}
	public String getTinhtrang() {
		return tinhtrang;
	}
	public void setTinhtrang(String tinhtrang) {
		this.tinhtrang = tinhtrang;
	}
	
	
}
