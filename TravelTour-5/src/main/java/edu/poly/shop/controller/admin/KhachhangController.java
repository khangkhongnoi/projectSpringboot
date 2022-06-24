package edu.poly.shop.controller.admin;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.poly.shop.domain.Khachhang;
import edu.poly.shop.model.KhachhangDto;
import edu.poly.shop.service.KhachhangService;

@Controller
@RequestMapping("admin/khachhang")
public class KhachhangController {
	@Autowired
	KhachhangService khachhangService;
	
	@GetMapping("add")
	public String add(ModelMap model) {
		model.addAttribute("khachhang", new KhachhangDto() );
		return "admin/khachhang/addOrEdit";
	}
	
	@GetMapping("edit/{idkhachhang}")
	public ModelAndView edit(ModelMap model, @PathVariable("idkhachhang") Long idkhachhang) {
		Optional<Khachhang> opt = khachhangService.findById(idkhachhang);
		KhachhangDto dto = new KhachhangDto();

		if (opt.isPresent()) {
			Khachhang entity = opt.get();
			BeanUtils.copyProperties(entity, dto);
		    
			
//			// hien thi ten loai tournew
//			dto.setIdtour(entity.getLoaitour().getIdloaitour());
//			// hine thi dia diem tour
//			dto.setIddiadiem(entity.getDiadiem().getIddiadiem());
//			// hien thi tinh
			dto.setIsEdit(true);
			model.addAttribute("khachhang", dto);
			return new ModelAndView("admin/khachhang/addOrEdit", model);

		}

		model.addAttribute("message", "tour is not existed");
		return new ModelAndView("forward:/admin/khachhang/addOrEdit", model);
	}
//
	
//	@GetMapping("delete/{idtour}")
//	public ModelAndView delete(ModelMap model, @PathVariable("idtour") Long idtour) {
//		tourService.deleteById(idtour);
//		model.addAttribute("message", "tour is delete!");
//		return new ModelAndView("redirect:/admin/tour", model);
//	}

	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("khachhang") KhachhangDto dto, BindingResult result
		) {
		
		
		Khachhang entity = new Khachhang();
		BeanUtils.copyProperties(dto, entity);
		khachhangService.save(entity);
		model.addAttribute("message", "tour is");
		return new ModelAndView("forward:/admin/khachhang", model);

	}
	@RequestMapping("")
	public String list(ModelMap model) {
		List<Khachhang> list = khachhangService.findAll();
		model.addAttribute("khachhang", list);
		return "admin/khachhang/list";
	}
//
//	@GetMapping("search")
//	public String seach() {
//		return "admin/tour/search";
//	}
}
