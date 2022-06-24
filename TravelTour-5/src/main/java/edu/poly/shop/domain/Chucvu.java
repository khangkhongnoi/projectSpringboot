package edu.poly.shop.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
@Table(name = "chucvu")
public class Chucvu implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idchucvu;
	@Column
	private String tenchucvu;
	
	@OneToMany(mappedBy = "chucvu",cascade = CascadeType.ALL,
	        orphanRemoval = true)
	private List<Nhanvien> nhanviens = new ArrayList<>();
}
