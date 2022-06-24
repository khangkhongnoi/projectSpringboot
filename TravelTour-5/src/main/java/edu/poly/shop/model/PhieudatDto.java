package edu.poly.shop.model;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhieudatDto implements Serializable {
	private Long idphieudat;
	private Long idkhachhang;
	private Long idtour;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngaydat;
	private int treem;
	private int nguoilon;
	private int soluongdat;
	private String trangthai;
	private float thanhtien;
	private Boolean isEdit = false;
}
