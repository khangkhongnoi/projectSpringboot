//package edu.poly.shop.controller.view;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//import javax.servlet.http.HttpSession;
//
//import edu.poly.shop.domain.Taikhoan;
//import edu.poly.shop.model.TaikhoanLoginDto;
//import edu.poly.shop.service.TaikhoanService;
//
//@Controller
//@RequestMapping("view")
//public class LoginController {
//	@Autowired
//	TaikhoanService taikhoanService;
//	@Autowired
//	private HttpSession session;
//	
//	@GetMapping("alogin")
//	public String login(ModelMap model) {
//		model.addAttribute("taikhoan", new TaikhoanLoginDto());
//		return "view/login";
//	}
//	
//	
//	@PostMapping("alogin")
//	public ModelAndView login(ModelMap model, @Valid @ModelAttribute("taikhoan") TaikhoanLoginDto dto, BindingResult result) {
//		if(result.hasErrors()) {
//			return new ModelAndView("view/login", model);
//		}
//		Taikhoan taikhoan = taikhoanService.login(dto.getEmail(), dto.getPassword());
//		if(taikhoan == null) {
//			model.addAttribute("message", "Email va mat khau trong");
//			return new ModelAndView("view/login", model);
//		}
//		session.setAttribute("email", taikhoan.getEmail());
//		return new ModelAndView("/view/index", model);
//	}
//}
