package edu.poly.shop.model;

import edu.poly.shop.domain.AppRole;
import edu.poly.shop.domain.AppUser;
import lombok.Data;

@Data
public class UserRoleDto {
	  private Long id;
	    private AppUser appUser;
	    private AppRole appRole;
}
