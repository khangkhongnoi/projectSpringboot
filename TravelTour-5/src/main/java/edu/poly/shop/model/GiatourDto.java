package edu.poly.shop.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GiatourDto implements Serializable {
	private Long idgiatour;
	private Long idtour;
	private String gianguoilon;
	private String giatreem;
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	@LastModifiedDate
	private LocalDateTime thoidiem;
	private String createBy;
	private String modifieBy;
	private int trangthai;
	private Boolean isEdit = false;
}
