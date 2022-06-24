package edu.poly.shop.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "nhanvien")
public class Nhanvien implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idnhanvien;
	@Column(length = 50)
	@NotBlank(message = "Nhập thiếu tên nhân viên")
		private String tennhanvien;
	@Column(length = 15 , unique = true)
	@javax.validation.constraints.NotNull
		private int cmnd;
	@Column(length = 20, unique = true)
	@javax.validation.constraints.NotNull(message = "khong dc")
		private int sdt;
	@Temporal(TemporalType.DATE)
		private Date ngaysinh;
	@Column
		private String gioitinh;
	@Column(unique = true)
	@javax.validation.constraints.Email
		private String email;
	@Column
		private String diachi;
	@ManyToOne
	@JoinColumn(name = "idchucvu")
	private Chucvu chucvu;
	
	@OneToMany(mappedBy = "nhanvien", cascade = CascadeType.ALL,
	        orphanRemoval = true)
	private List<AppUser> taikhoans = new ArrayList<>();
}
