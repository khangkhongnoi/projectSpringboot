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

import edu.poly.shop.domain.Loaitour;
import edu.poly.shop.domain.Phuongtien;
import edu.poly.shop.model.LoaitourDto;
import edu.poly.shop.model.PhuongtienDto;
import edu.poly.shop.service.LoaitourService;

@Controller
@RequestMapping("admin/loaitour")
public class LoaitourController {
	@Autowired
	LoaitourService loaitourService;
	
	@GetMapping("add")
	public String add(ModelMap model) {
		model.addAttribute("loaitour", new LoaitourDto());
		return "admin/loaitour/addOrEdit";
	}
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model,
		@Valid @ModelAttribute("loaitour") LoaitourDto dto, BindingResult result) {
		if(result.hasErrors()) {
			return new ModelAndView("admin/loaitour/addOrEdit");
		}

		Loaitour entity = new Loaitour();
		BeanUtils.copyProperties(dto, entity);
		loaitourService.save(entity);
		
	
		model.addAttribute("message", "phuong tien is");
		return new ModelAndView("forward:/admin/loaitour", model) ;

	}
	@RequestMapping("")
	public String list(ModelMap model) {
		List<Loaitour> list = loaitourService.findAll();
		model.addAttribute("loaitour", list);
		return "admin/loaitour/list";
	}
}
