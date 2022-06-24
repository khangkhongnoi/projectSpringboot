package edu.poly.shop.controller.admin;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.poly.shop.domain.Giatour;
import edu.poly.shop.domain.Hinhanh;
import edu.poly.shop.domain.Tour;
import edu.poly.shop.model.GiatourDto;
import edu.poly.shop.model.HinhanhDto;
import edu.poly.shop.model.TourDto;
import edu.poly.shop.service.HinhanhService;
import edu.poly.shop.service.TourService;

@Controller
@RequestMapping("admin/hinhanh")
public class HinhanhController {
	@Autowired
	HinhanhService hinhanhService;
	@Autowired 
	TourService tourService;
	@ModelAttribute("tour")
	public List<TourDto> getTinh() {
		return tourService.findAll().stream().map(item -> {
			TourDto dto = new TourDto();
			BeanUtils.copyProperties(item, dto);
			return dto;
		}).toList();
	}
	@GetMapping("add")
	public String add(ModelMap model) {
		model.addAttribute("hinhanh", new HinhanhDto());
		return "admin/hinhanh/addOrEdit";
	}
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model,
		@Valid @ModelAttribute("hinhanh") HinhanhDto dto, BindingResult result) {
		if(result.hasErrors()) {
			return new ModelAndView("admin/hinhanh/addOrEdit");
		}

		
		Hinhanh entity = new Hinhanh();
		BeanUtils.copyProperties(dto, entity);
		//luu tour
		Tour tour = new Tour();
		tour.setIdtour(dto.getIdtour());
		entity.setTour(tour);
		hinhanhService.save(entity);
		model.addAttribute("message", "gia tour tien is");
		return new ModelAndView("forward:/admin/hinhanh", model) ;

	}
}
