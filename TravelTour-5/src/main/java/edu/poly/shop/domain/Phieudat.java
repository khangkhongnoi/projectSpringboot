package edu.poly.shop.domain;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "phieudat")
public class Phieudat implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idphieudat;
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")

	private Date ngaydat;
	@Column(nullable = false)
	private int treem;
	@Column(nullable = false)
	private int nguoilon;
	@Column(nullable = false)
	private int soluongdat;
	@Column(length = 20)
	private int trangthai;
	@Column(nullable = false)
	private float thanhtien;
	
	
//	@OneToMany(mappedBy = "phieudat",cascade = CascadeType.ALL,
//	        orphanRemoval = true)
//	private List<Hoadon> hoadons = new ArrayList<>();
	
//	@ManyToOne
//	@JoinColumn(name = "idchitiettour")
//	private Chitiettour chitiettour;
	
	@ManyToOne
	@JoinColumn(name = "idkhachhang")
	private Khachhang khachhang;
	
	@ManyToOne
	@JoinColumn(name = "idtour")
	private Tour tour;
}
