package edu.poly.shop.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class HoadonDto implements Serializable{
	private Long idhoadon;
	private Long idphieudat;
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	private LocalDateTime ngaythanhtoan;
	private float tongtien;
	private String tinhtrang;
}
