package edu.poly.shop.controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import edu.poly.shop.domain.Tour;
import edu.poly.shop.repository.TourRepository;


@Controller
@RequestMapping("travl")
public class TrangChuController {
	@Autowired
	TourRepository tourRepository;

	@GetMapping("home")
	public String loadhome(ModelMap model) {
		
	
			 
		return "view/testpro";
	}
	
}
