//package edu.poly.shop.controller.admin;
//
//import javax.servlet.http.HttpSession;
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Service;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import edu.poly.shop.domain.Taikhoan;
//import edu.poly.shop.model.TaikhoanLoginDto;
//import edu.poly.shop.service.TaikhoanService;
//
//@Service
//@Controller
//public class AdminLoginController {
//		@Autowired
//		private TaikhoanService taikhoanService;
//		@Autowired
//		private HttpSession session;
//		
//		@RequestMapping("/alogin")
//		public String login(ModelMap model) {
//			model.addAttribute("taikhoan", new TaikhoanLoginDto());
//			return "admin/taikhoan/login";
//		}
//		@PostMapping("alogin")
//		public ModelAndView login(ModelMap model, @Valid @ModelAttribute("taikhoan") TaikhoanLoginDto dto, BindingResult result) {
//			if(result.hasErrors()) {
//				return new ModelAndView("admin/taikhoan/login", model);
//			}
//			Taikhoan taikhoan = taikhoanService.login(dto.getEmail(), dto.getPassword());
//			if(taikhoan == null) {
//				model.addAttribute("message", "Email va mat khau trong");
//				return new ModelAndView("admin/taikhoan/login", model);
//			}
//			model.addAttribute("taikhoan", taikhoan);
//			session.setAttribute("email", taikhoan.getEmail());
//			return new ModelAndView("forward:/admin/tour", model);
//		}
//}
