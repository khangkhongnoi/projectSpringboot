package edu.poly.shop.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "binhluan")
public class Binhluan implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idbinhluan;

	@Column(length = 50)
	private String ten;
	@Column(length = 200)
	private String noidung;
	@Column(nullable = false)
	private Date ngaygio;
	@Column(nullable = false)
	private int trangthai;
	
	@ManyToOne
	@JoinColumn(name = "idtour")
	private Tour tour;
	@ManyToOne
	@JoinColumn(name = "idkhachhang")
	private Khachhang khachhang;
//	@ManyToOne
//	@JoinColumn(name ="idchitiettour")
//	private Chitiettour chitiettour;
}
