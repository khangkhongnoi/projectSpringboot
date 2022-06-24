package edu.poly.shop.domain;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "diadiem")
public class Diadiem implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iddiadiem;
	
	@Column(name = "diemden")
	private String diemden;
	
	@Column(length = 2000 , name ="mota")
	private String mota;
	private Boolean isEdit = false;
		@ManyToOne
		@JoinColumn(name = "idtinh")
		private Tinh tinh;
		
		@OneToMany(mappedBy = "idtour", cascade = CascadeType.ALL,
		        orphanRemoval = true)
		private List<Tour> tour = new ArrayList<>();
		
}
