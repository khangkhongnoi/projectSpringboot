package edu.poly.shop.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import edu.poly.shop.domain.AppRole;
import edu.poly.shop.domain.AppUser;
import edu.poly.shop.domain.Giohang;
import edu.poly.shop.domain.Tour;
import edu.poly.shop.domain.UserRole;
import edu.poly.shop.model.AppUserDto;
import edu.poly.shop.service.AppRoleService;
import edu.poly.shop.service.AppUserService;
import edu.poly.shop.service.TourService;
import edu.poly.shop.utils.WebUtils;

@Controller
@SessionAttributes("giohang")
public class Main {
	List<Giohang> giohangs = new ArrayList<>();
	@Autowired 
	TourService tourService;
	@Autowired
	AppUserService appUserService;
	@Autowired
	AppRoleService appRoleService;
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(Model model, Principal principal) {
		
		User loginedUser = (User) ((Authentication) principal).getPrincipal();

		String userInfo = edu.poly.shop.utils.WebUtils.toString(loginedUser);
		model.addAttribute("userInfo", userInfo);
		System.out.println(userInfo);
		return "admin/tour/addOrEdit";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model) {
		
		return "admin/taikhoan/login";
	}
	@PostMapping("register")
	public ModelAndView login ( ModelMap model, @ModelAttribute(value = "user") AppUserDto dto ,BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return new ModelAndView("admin/taikhoan/dangky");
		}
		
		AppUser entity = new AppUser();
		AppRole appRole = new AppRole();
		appRole.setRoleName("khang");
		
		UserRole userRole = new UserRole();
		appRoleService.save(appRole);
		Set<AppRole> appRoles = new HashSet<>();
		appRoles.add(appRole);
		appRoleService.save(appRole);
		Long k = (long) 1;
		userRole.setAppRole(appRole.getReled());
//		userRole.setAppRole(dto.getUserid());
	//	userRole.setAppUser(dto.getUserid());
 		BeanUtils.copyProperties(dto, entity);
		
		appUserService.save(entity);
		System.out.println(entity);
		System.out.println(appRole);
		model.addAttribute("message","them tai khoan thanh cong");
		return new ModelAndView("admin/taikhoan/login", model);
	}
	@RequestMapping("/register")
	public String register(ModelMap model) {
		model.addAttribute("user", new AppUser());
		return "admin/taikhoan/dangky";
	}
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String userInfo(HttpSession session,Model model, Principal principal) {
		List<Tour> tour = tourService.findByIdtourlimit();
		model.addAttribute("tour", tour);
		// Sau khi user login thanh cong se co principal
		if(principal == null) {
			return "view/index";
		}
		else {
		String userName = principal.getName();
		model.addAttribute("userName", userName);
		System.out.println("User Name: " + userName);

		User loginedUser = (User) ((Authentication) principal).getPrincipal();

		String userInfo = WebUtils.toString(loginedUser);
		model.addAttribute("userInfo", userInfo);
		if( null != session.getAttribute("giohang")) {
			List<Giohang> giohangs = (List<Giohang>) session.getAttribute("giohang");
			model.addAttribute("soluonggiohang", giohangs.size());
			model.addAttribute("giohang", giohangs);
			
		}
		return "view/index";
		}
		
	}
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {

		if (principal != null) {
			User loginedUser = (User) ((Authentication) principal).getPrincipal();

			String userInfo = WebUtils.toString(loginedUser);

			model.addAttribute("userInfo", userInfo);

			String message = "Hi " + principal.getName() //
					+ "<br> You do not have permission to access this page!";
			model.addAttribute("message", message);

		}

		return "403Page";
	}
	@RequestMapping(value = "/loginmessageerror")
	public String loginmessageerror(Model model ) {
			
		return "admin/taikhoan/login";
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutSuccessfulPage(Model model) {
		List<Tour> tour = tourService.findByIdtourlimit();
		model.addAttribute("tour", tour);
		model.addAttribute("title", "Logout");
		return "view/index";
	}
}
