package edu.poly.shop.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.poly.shop.domain.Giatour;
import edu.poly.shop.domain.Tour;
import edu.poly.shop.repository.GiatourRepository;
import edu.poly.shop.service.GiatourService;
import edu.poly.shop.service.PhieudatService;
import edu.poly.shop.service.TourService;

@Controller
@RequestMapping("view/hoadon")
public class HDController {
		@Autowired
		TourService tourService;
		@Autowired
		GiatourRepository giatourRepository;
		@Autowired
		PhieudatService phieudatService;
	@RequestMapping("/{idtour}")
	public String loadchitiet(ModelMap model, @PathVariable("idtour") Long idtour) {
		Tour item = tourService.findByIdtour(idtour);
		model.addAttribute("item" , item);
		
//		List<Chitiettour> items = chitiettourService.findAll();
//		model.addAttribute("items", items);
		Giatour pro = giatourRepository.finbyIdtour(idtour);
		model.addAttribute("pro", pro);
		
		
		return "view/hoadon";
}
}