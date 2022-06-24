package edu.poly.shop.controller.view;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.poly.shop.domain.Tour;

import edu.poly.shop.repository.TourRepository;

import edu.poly.shop.service.TourService;

@Controller
@RequestMapping("view")
public class HomeController {
//	@Autowired
//	ChitiettourService chitiettourService;
	@Autowired 
	TourService tourService;
	@Autowired 
	TourRepository tourRepository;
	@GetMapping("home")
	public String loadhome(ModelMap model , Principal principal) {
//		List<Chitiettour> list = chitiettourService.findAll();
//		model.addAttribute("chitiettours", list);
		List<Tour> tour = tourService.findByIdtourlimit();
		model.addAttribute("tour", tour);
//		String userName = principal.getName();
//		model.addAttribute("userName", userName);
//		System.out.println("User Name: " + userName);
//		
//
//		User loginedUser = (User) ((Authentication) principal).getPrincipal();
//
//		String userInfo = WebUtils.toString(loginedUser);
//		model.addAttribute("userInfo", userInfo);
		return "view/index";
	}
	@GetMapping("phieudat/add")
	public String add() {
		
		return "view/phieudat";
	}
	
}
