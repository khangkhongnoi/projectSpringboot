package edu.poly.shop.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "chuongtrinhtour")
public class Chuongtrinhtour implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idchuongtrinhtour;
	@Column(nullable = false)
	private int idtour;
	@Column(nullable = false)
	private Date ngaythu;
	@Column(length = 1000)
	private String tieude;
	
	@Column(length = 1000)
	private String mota;
}
