package edu.poly.shop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.poly.shop.model.TinhDto;
@Controller
@RequestMapping("admin/khang")
public class testcontroller {
	@GetMapping("add")
	public String add() {
			
		return "admin/k/addOrEdit";
}
}
