package edu.poly.shop.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tinh")
public class Tinh implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idtinh;
	@Column(name = "tentinh")
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



	public void setDiadiems(List<Diadiem> diadiems) {
		this.diadiems = diadiems;
	}

	@OneToMany(mappedBy = "tinh",
			cascade = CascadeType.ALL,
	        orphanRemoval = true)
	 private List<Diadiem> diadiems = new ArrayList<>();
	
//	@OneToMany(mappedBy = "tinh")
//	private List<Tour> tours = new ArrayList<>();
}
