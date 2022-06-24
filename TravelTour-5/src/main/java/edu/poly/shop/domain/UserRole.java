package edu.poly.shop.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
@Table(name = "User_Role")
public class UserRole {
	@Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long id;
	
	  @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "User_Id", nullable = false)
	    private AppUser appUser;

	    @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "Role_Id", nullable = false)
	    private AppRole appRole;

		



}
