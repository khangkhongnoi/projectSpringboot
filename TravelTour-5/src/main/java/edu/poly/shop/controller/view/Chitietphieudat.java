package edu.poly.shop.controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.poly.shop.domain.Tour;
import edu.poly.shop.repository.GiatourRepository;
import edu.poly.shop.repository.TourRepository;
import edu.poly.shop.service.GiatourService;
import edu.poly.shop.service.PhieudatService;
import edu.poly.shop.service.TourService;

@Controller
@RequestMapping("view/chitiets")
public class Chitietphieudat {
	@Autowired
	PhieudatService phieudatService;
	@Autowired
	TourService tourService;
	@Autowired
	GiatourRepository giatourRepository;
	@Autowired
	GiatourService giatourService;
	@Autowired
	TourRepository tourRepository;
	
	@GetMapping("{idtour}")
	public String deafault(ModelMap model ,@PathVariable("idtour") Long idtour) {
		Tour item = tourService.findByIdtour(idtour);
		model.addAttribute("itemk" , item);
		
		System.out.println("id tour " + item);
		return "view/chitiets";
	}
	
	
}
