package edu.poly.shop.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TourDto  implements Serializable {
	private Long idtour;
	private Long iddiadiem;
	private Long idloaitour;
	private Long idphuongtien;
	private Long idgiatour;
	private String tentour;
	private String idhinhanh;
	private int songay;
	private int sodem;
	private String mota;
	private String lichtrinh;
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	private LocalDateTime ngaydi;
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	private LocalDateTime ngayve;
	private int soluongcon;
	private String ghichu;
	private int trangthai;
	private String hinhanh;
	private MultipartFile imageFile;
	private Boolean isEdit = false;
	
	
}
