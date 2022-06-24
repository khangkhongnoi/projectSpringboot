package edu.poly.shop.controller.admin;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import edu.poly.shop.domain.Diadiem;
import edu.poly.shop.domain.Loaitour;
import edu.poly.shop.domain.Phuongtien;
import edu.poly.shop.domain.Tinh;
import edu.poly.shop.domain.Tour;
import edu.poly.shop.model.DiadiemDto;
import edu.poly.shop.model.LoaitourDto;
import edu.poly.shop.model.PhuongtienDto;
import edu.poly.shop.model.TinhDto;
import edu.poly.shop.model.TourDto;
import edu.poly.shop.repository.PhuongtienRepository;
import edu.poly.shop.service.DiadiemService;
import edu.poly.shop.service.LoaitourService;
import edu.poly.shop.service.PhuongtienService;
import edu.poly.shop.service.TinhService;
import edu.poly.shop.service.TourService;

@Controller
@RequestMapping("admin/phuongtien")
public class PhuongtienController {
	@Autowired
	TourService tourService;
	@Autowired
	LoaitourService loaitourService;
	@Autowired
	DiadiemService diadiemService;
	@Autowired
	TinhService tinhService;
	@Autowired
	PhuongtienService phuongtienService;
	// load ten loai tour
//	@ModelAttribute("loaitour")
//	public List<LoaitourDto> getLoaitour(){
//		
//		return loaitourService.findAll().stream().map(item->{
//			LoaitourDto dto = new LoaitourDto();
//			BeanUtils.copyProperties(item, dto);
//			return dto;
//			
//		}).toList();
//	}
//	//load dia diem
//	@ModelAttribute("diadiem")
//	public List<DiadiemDto> getDiadiem(){
//		return diadiemService.findAll().stream().map(item->{
//			DiadiemDto dto = new DiadiemDto();
//			BeanUtils.copyProperties(item, dto);
//			return dto;
//		}).toList();
//	}
	//load tinh
//	@ModelAttribute("tinh")
//	public List<TinhDto> getTinh(){
//		return tinhService.findAll().stream().map(item->{
//			TinhDto dto = new TinhDto();
//			BeanUtils.copyProperties(item, dto);
//			return dto;
//		}).toList();
//	}
	
	@GetMapping("add")
	public String add( Model model) {
	model.addAttribute("phuongtien", new PhuongtienDto());
		return "admin/phuongtien/addOrEdit";
	}
	
	@GetMapping("edit/{idphuongtien}")
	public ModelAndView edit(ModelMap model ,@PathVariable("idphuongtien") Long idphuongtien) {
		Optional<Phuongtien> opt = phuongtienService.findById(idphuongtien);
		PhuongtienDto dto = new PhuongtienDto();
		
		if(opt.isPresent()) {
			Phuongtien entity = opt.get();
			BeanUtils.copyProperties(entity, dto);
		
//			//hien thi ten loai tour
//			dto.setIdtour(entity.getLoaitour().getIdloaitour());
//			//hine thi dia diem tour
//			dto.setIddiadiem(entity.getDiadiem().getIddiadiem());
//			// hien thi tinh
			dto.setIsEdit(true);
			model.addAttribute("phuongtien", dto);
			return new ModelAndView("admin/tour/addOrEdit", model);
			
		}
		
			model.addAttribute("message", "phuong tien is not existed");
			return new ModelAndView("forward:/admin/tour/addOrEdit", model) ;
		}
	@GetMapping("delete/{idtour}")
	public ModelAndView delete(ModelMap model, @PathVariable("idtour") Long idtour) {
		tourService.deleteById(idtour);
		model.addAttribute("message", "tour is delete!");
		return new ModelAndView("redirect:/admin/tour", model) ;
	}
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model,
		@Valid @ModelAttribute("phuongtien") PhuongtienDto dto, BindingResult result) {
		if(result.hasErrors()) {
			return new ModelAndView("admin/phuongtien/addOrEdit");
		}

		Phuongtien entity = new Phuongtien();
		BeanUtils.copyProperties(dto, entity);
//		// luu loai tour
//		Loaitour loaitour = new Loaitour();
//		loaitour.setIdloaitour(dto.getIdloaitour());
//		entity.setLoaitour(loaitour);
//		// luu dia diem
//		Diadiem diadiem = new Diadiem()	;
//		diadiem.setIddiadiem(dto.getIddiadiem());
//		entity.setDiadiem(diadiem);
		phuongtienService.save(entity);
		// lu tinh
	
		model.addAttribute("message", "phuong tien is");
		return new ModelAndView("forward:/admin/phuongtien", model) ;

	}
	@RequestMapping("")
	public String list(ModelMap model) {
		List<Phuongtien> list = phuongtienService.findAll();
		model.addAttribute("phuongtien",list);
		return "admin/phuongtien/list";
	}
	@GetMapping("search")
	public String seach() {
		return "admin/tour/search";
	}
}
