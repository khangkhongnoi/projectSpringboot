package edu.poly.shop.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.poly.shop.domain.Hoadon;
import edu.poly.shop.model.HoadonDto;
import edu.poly.shop.service.HoadonService;

@Controller
@RequestMapping("admin/hoadon")
public class HoadonController {
		@Autowired
		HoadonService hoadonService;
	
	@GetMapping("")
	public String list(ModelMap model) {
		List<Hoadon> list = hoadonService.findAll();
		model.addAttribute("hoadon", list);
		return "admin/hoadon/list";
	}
}
