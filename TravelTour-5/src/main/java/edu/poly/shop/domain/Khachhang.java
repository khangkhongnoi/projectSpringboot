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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "khachhang")
public class Khachhang implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idkhachhang;
	@Column(length = 100)
	private String ten;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngaysinh;
	@Column(length = 15 , unique = true)
	private int cmnd;
	@Column(length = 500)
	private String diachi;
	@Column(length = 15, unique = true)
	private int sdt;
	@Column(length = 100, unique = true)
	private String email;
	@Column 
	private String gioitinh;
	
	@OneToMany(mappedBy = "khachhang",
			cascade = CascadeType.ALL,
	        orphanRemoval = true)
	private List<Phieudat> phieudats = new ArrayList<>();
	
	@OneToMany(mappedBy = "tour",
			cascade = CascadeType.ALL,
	        orphanRemoval = true)
	 private List<Binhluan> binhluans  = new ArrayList<>();
	
	@OneToMany(mappedBy = "khachhang", cascade = CascadeType.ALL,
	        orphanRemoval = true)
	private List<AppUser> taikhoans = new ArrayList<>();
	
	
}
