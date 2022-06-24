package edu.poly.shop.controller.view;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.poly.shop.domain.Diadiem;
import edu.poly.shop.domain.Giatour;
import edu.poly.shop.domain.Phieudat;
import edu.poly.shop.domain.Tinh;
import edu.poly.shop.domain.Tour;
import edu.poly.shop.model.PhieudatDto;
import edu.poly.shop.model.TinhDto;
import edu.poly.shop.repository.GiatourRepository;
import edu.poly.shop.service.GiatourService;
import edu.poly.shop.service.PhieudatService;
import edu.poly.shop.service.TourService;

@Controller
@RequestMapping("view/phieudat")
public class PhieudatsController {
	@Autowired
	PhieudatService phieudatService;
	@Autowired
	TourService tourService;
	@Autowired
	GiatourRepository giatourRepository;
	@Autowired
	GiatourService giatourService;
//	@GetMapping("add")
//	public String add() {
//		
//		return "view/phieudat";
//	}
	@RequestMapping("/{idtour}")
	public String loadchitiet(ModelMap model, @PathVariable("idtour") Long idtour ,PhieudatDto dto) {
		Tour item = tourService.findByIdtour(idtour);
		model.addAttribute("item" , item);
		Phieudat entity = new Phieudat();
//		List<Chitiettour> items = chitiettourService.findAll();
//		model.addAttribute("items", items);
		Tour tour = new Tour();
		tour.setIdtour(dto.getIdtour());
		entity.setTour(tour);
		Giatour pro = giatourRepository.finbyIdtour(idtour);
		model.addAttribute("pro", pro);
		return "view/phieudat";
}
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model,
		@Valid @ModelAttribute("phieudat")
		 PhieudatDto dto , BindingResult result    ) {
		
//		if(result.hasErrors() ) {
//			model.addAttribute("message", "Tỉnh");
//			return new ModelAndView("admin/tinh/addOrEdit", model);
//		}
		Phieudat entity = new Phieudat();
		Tour tour = new Tour();
		tour.setIdtour(dto.getIdtour());
		entity.setTour(tour);
		Giatour gia = new Giatour();
		BeanUtils.copyProperties(dto, entity);
		
		entity.setNgaydat(dto.getNgaydat());
		dto.setNgaydat(entity.getNgaydat());
		
		phieudatService.save(entity);
		model.addAttribute("message", "Them phieu dat thanh cong!");
		return new ModelAndView("view/phieudat", model) ;
	}
}
