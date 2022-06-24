package edu.poly.shop.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tour")
public class Tour implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idtour;
	
	@Column
	private String tentour;
	@Column(nullable = false)
	private int songay;
	@Column(nullable = false)
	private int sodem;
	@Column
	private String bando;
	@Column
	private String mota;
	@Column
	private String lichtrinh;
	@Column(nullable = false)
	@NonNull
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	private LocalDateTime ngaydi;
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	private LocalDateTime ngayve;
	@Column(nullable =  false)
	private int soluongcon;
	@Column(length = 500)
	private String ghichu;
	@Column(length = 500)
	private String hinhanh;
	
	private int trangthai;
	
	@ManyToOne
	@JoinColumn(name = "idloaitour")
	private Loaitour loaitour; 
	
	@ManyToOne
	@JoinColumn(name = "iddiadiem")
	private Diadiem diadiem;
	private Boolean isEdit = false;
	@ManyToOne
	@JoinColumn(name = "idphuongtien")
	private Phuongtien phuongtien;
	
	@OneToMany(mappedBy = "tour",
			cascade = CascadeType.ALL,
	        orphanRemoval = true)
	private List<Giatour> giatours  = new ArrayList<>();
	@OneToMany(mappedBy = "tour",
			cascade = CascadeType.ALL,
	        orphanRemoval = true)
	 private List<Hinhanh> hinhanhs  = new ArrayList<>();
	@OneToMany(mappedBy = "tour",
			cascade = CascadeType.ALL,
	        orphanRemoval = true)
	 private List<Binhluan> binhluans  = new ArrayList<>();
	@OneToMany(mappedBy = "tour",
			cascade = CascadeType.ALL,
	        orphanRemoval = true)
	 private List<Phieudat> phieudats   = new ArrayList<>();
//	@ManyToMany
//	@JoinTable(
//	  name = "tourphuongtien", 
//	  joinColumns = @JoinColumn(name = "idtour"), 
//	  inverseJoinColumns = @JoinColumn(name = "idphuongtien"))
//	Set<Phuongtien> phuongtiens ;
}
