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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "phuongtien")
public class Phuongtien implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idphuongtien;
	@Column(name ="tenphuongtien")
	private String tenphuongtien;
	@Column(name = "succhua")
	private int succhua;
	@Column(name = "tinhtrang")
	private String tinhtrang;
	

	private Boolean isEdit = false;
	
	@OneToMany(mappedBy = "phuongtien",
			cascade = CascadeType.ALL,
	        orphanRemoval = true)
	 private List<Tour> tour = new ArrayList<>();
//	@ManyToMany(mappedBy = "phuongtiens")
//	Set<Tour> tours;
}
