package edu.poly.shop.model;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoaitourDto implements Serializable {
	private Long idloaitour;
	private String tenloaitour;
	private Boolean isEdit = false;
	public Long getIdloaitour() {
		return idloaitour;
	}
	public void setIdloaitour(Long idloaitour) {
		this.idloaitour = idloaitour;
	}
	public String getTenloaitour() {
		return tenloaitour;
	}
	public void setTenloaitour(String tenloaitour) {
		this.tenloaitour = tenloaitour;
	}
	
	
}
