package edu.poly.shop.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.poly.shop.domain.Phieudat;
import edu.poly.shop.model.PhieudatDto;
import edu.poly.shop.service.PhieudatService;

@Controller
@RequestMapping("admin/phieudat")
public class PhieudatController {
	@Autowired
	PhieudatService phieudatService;
	@GetMapping("add")
	public String add(ModelMap model) {
		model.addAttribute("phieudat", new PhieudatDto());
		return "admin/phieudat/addOrEdit";
	}
	@RequestMapping("")
	public String list(ModelMap model) {
		List<Phieudat> list = phieudatService.findAll();
		model.addAttribute("phieudat", list);
		return "admin/phieudat/list";
	}
}
