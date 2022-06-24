package edu.poly.shop.domain;

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

import org.hibernate.mapping.Array;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "loaitour")
public class Loaitour {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idloaitour;
	@Column(columnDefinition = "nvarchar(200)")
	private String tenloaitour;
	
	@OneToMany(mappedBy = "loaitour",
			cascade = CascadeType.ALL,
	        orphanRemoval = true)
		private List<Tour> tours = new ArrayList<>();
}
