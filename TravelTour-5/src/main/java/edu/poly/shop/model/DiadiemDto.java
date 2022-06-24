package edu.poly.shop.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class DiadiemDto implements Serializable {
	private Long iddiadiem;
	private Long idtinh;
	private String diemden;
	private String mota;
	private Boolean isEdit = false;
	public DiadiemDto() {
		this.iddiadiem = null;
		this.diemden = null;
		this.mota = null;
		this.isEdit = false;
	}
	
	public DiadiemDto(Long iddiiadiem2, String diemden2) {
		this.iddiadiem = iddiiadiem2;
		this.diemden = diemden2;
	}
	
	public Long getIddiadiem() {
		return iddiadiem;
	}
	public void setIddiadiem(Long iddiadiem) {
		this.iddiadiem = iddiadiem;
	}
	public String getDiemden() {
		return diemden;
	}
	public void setDiemden(String diemden) {
		this.diemden = diemden;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public Boolean getIsEdit() {
		return isEdit;
	}
	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}
	
	
	
}
