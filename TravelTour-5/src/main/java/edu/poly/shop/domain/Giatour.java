package edu.poly.shop.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity(name = "giatour")
public class Giatour implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idgiatour;
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	@LastModifiedDate
	private LocalDateTime thoidiem;
	@Column(nullable = false)
	private String gianguoilon;
	@Column(nullable = false)
	private String giatreem;
	@Column
	private int trangthai;
	private Boolean isEdit = false;
	@Column
	@CreatedBy
	private String createBy;
	@Column
	@LastModifiedBy
	private String modifieBy;
	@ManyToOne
	@JoinColumn(name = "idtour")
	private Tour tour;
}
