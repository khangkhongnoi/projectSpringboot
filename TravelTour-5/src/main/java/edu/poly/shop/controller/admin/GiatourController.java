package edu.poly.shop.controller.admin;

import java.util.List;
import java.util.Optional;

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
import edu.poly.shop.domain.Tour;
import edu.poly.shop.model.GiatourDto;
import edu.poly.shop.model.TinhDto;
import edu.poly.shop.model.TourDto;
import edu.poly.shop.service.GiatourService;
import edu.poly.shop.service.TourService;

@Controller
@RequestMapping("admin/giatour")
public class GiatourController {
	@Autowired
	GiatourService giatourService;
	@Autowired
	TourService tourService;
	//lod tour
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
		model.addAttribute("giatour", new GiatourDto());
		List<Tour> list = tourService.findAll();
		model.addAttribute("tour", list);
		return "admin/giatour/addOrEdit";
	}
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model,
		@Valid @ModelAttribute("giatour") GiatourDto dto, BindingResult result) {
//		Optional<Tour> founsTour = tourService.findById(dto.getIdtour());
		if(result.hasErrors() ){
			model.addAttribute("message","Tên tour du lịch đã tồn tại");
			return new ModelAndView("admin/giatour/addOrEdit");
		}

		
		Giatour entity = new Giatour();
		BeanUtils.copyProperties(dto, entity);
		//luu tour
		Tour tour = new Tour();
		tour.setIdtour(dto.getIdtour());
		entity.setTour(tour);
		dto.setThoidiem(entity.getThoidiem());
		entity.setThoidiem(dto.getThoidiem());
		dto.setCreateBy(entity.getCreateBy());
		entity.setCreateBy(dto.getCreateBy());
		giatourService.save(entity);
		model.addAttribute("message", "Thêm giá tour thành công");
		return new ModelAndView("forward:/admin/giatour", model) ;

	}
	@RequestMapping("")
	public String list(ModelMap model) {
		List<Giatour> list = giatourService.findAllIdgiatour();
		model.addAttribute("giatour", list);
		return "admin/giatour/list";
	}
	@GetMapping("delete/{idgiatour}")
	public ModelAndView delete(ModelMap model, @PathVariable("idgiatour") Long idgiatour) {
		giatourService.updateTrangthaiid(idgiatour);
		model.addAttribute("message","delete thành công");
		return new ModelAndView("redirect:/admin/giatour", model);
	}
	@GetMapping("edit/{idgiatour}")
	public ModelAndView edit(ModelMap model , @PathVariable("idgiatour") Long idgiatour) {
		Optional<Giatour> opt = giatourService.findById(idgiatour);
		GiatourDto dto = new GiatourDto();
			
		if (opt.isPresent()) {
			Giatour entity = opt.get();
			
			//hien thi ten tour
			dto.setIdtour(entity.getTour().getIdtour());
			// hien thi tinh
			dto.setIsEdit(true);
			dto.setTrangthai(1);
			entity.setTrangthai(1);
			BeanUtils.copyProperties(entity, dto);
			giatourService.save(entity);
			model.addAttribute("giatour", dto);
			
			return new ModelAndView("admin/giatour/addOrEdit", model);

		}
		return new ModelAndView("admin/giatour/addOrEdit");
	}
}
