package edu.poly.shop.model;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TinhDto implements Serializable {
	private Long idtinh;
	@NotEmpty
	@Length(min = 5)
	private String tentinh;
	private Boolean isEdit = false;
	public Long getIdtinh() {
		return idtinh;
	}
	public void setIdtinh(Long idtinh) {
		this.idtinh = idtinh;
	}
	public String getTentinh() {
		return tentinh;
	}
	public void setTentinh(String tentinh) {
		this.tentinh = tentinh;
	}
	public Boolean getIsEdit() {
		return isEdit;
	}
	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}
	
	
}
