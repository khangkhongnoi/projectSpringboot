package edu.poly.shop.controller.admin;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.poly.shop.domain.AppUser;
import edu.poly.shop.model.TaikhoanDto;
import edu.poly.shop.service.TaikhoanService;

@Controller
@RequestMapping("admin/taikhoan")
public class TaikhoanController {
	@Autowired
	TaikhoanService taikhoanService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@GetMapping("add")
	public String add(ModelMap model) {
			model.addAttribute("taikhoan", new TaikhoanDto());
		return "admin/taikhoan/addOrEdit";
	}
	
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model,
		@Valid @ModelAttribute("taikhoan") TaikhoanDto dto, BindingResult result) {
		if(result.hasErrors()) {
			return new ModelAndView("admin/taikhoan/addOrEdit");
		}
		
		AppUser entity = new AppUser();
		BeanUtils.copyProperties(dto, entity);
		taikhoanService.save(entity);

		model.addAttribute("message", "Tai khoan is");
		return new ModelAndView("forward:/admin/taikhoan", model) ;
	}
	@RequestMapping("")
	public String list(ModelMap model) {
		List<AppUser> list = taikhoanService.findAll();
		model.addAttribute("taikhoan", list);
		return "admin/taikhoan/list";
	}
	@GetMapping("edit/{tentaikhoan}")
	public ModelAndView edit(ModelMap model , @PathVariable("tentaikhoan") String tentaikhoan) {
		Optional<AppUser> opt = taikhoanService.findById(tentaikhoan);
		TaikhoanDto dto = new TaikhoanDto();
		if(opt.isPresent()) {
			AppUser entity = opt.get();
			BeanUtils.copyProperties(entity, dto);
			dto.setIsEdit(true);
			dto.setPassword("");
			model.addAttribute("taikhoan", dto);
			return new ModelAndView("admin/taikhoan/addOrEdit", model);
		}
		model.addAttribute("message", "tai khoan not ");
		return new ModelAndView("forward:/admin/taikhoan", model);
	}
		
}
