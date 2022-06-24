package edu.poly.shop.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HinhanhDto implements Serializable {
	private Long idhinhanh;
	private Long idtour;
	private String hinhanh;
	private Boolean isEdit = false;
}
