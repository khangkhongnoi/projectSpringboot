package edu.poly.shop.controller.view;

import java.security.Principal;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Cache.Connection;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


import edu.poly.shop.domain.Diadiem;
import edu.poly.shop.domain.Giatour;
import edu.poly.shop.domain.Giohang;
import edu.poly.shop.domain.Tinh;
import edu.poly.shop.domain.Tour;

import edu.poly.shop.model.DiadiemDto;
import edu.poly.shop.model.TourDto;
import edu.poly.shop.repository.GiatourRepository;
import edu.poly.shop.repository.TourRepository;

import edu.poly.shop.service.TourService;
@Controller
@RequestMapping("view/chitiet")
@SessionAttributes("giohang")
public class Tourcontroller {
//	@Autowired
//	ChitiettourService chitiettourService;
	@Autowired
	TourService tourService;
	@Autowired 
	SessionFactory sessionFactory;
	@Autowired
	TourRepository tourRepository;
	@Autowired
	GiatourRepository giatourRepository;
	@RequestMapping("/{idtour}")
	public String loadchitiet(ModelMap model, @PathVariable("idtour") Long idtour , HttpSession session, Principal principal) {
		Tour item = tourRepository.findByIdchitiettour(idtour);
		model.addAttribute("item" , item);
		if( null != session.getAttribute("giohang")) {
			List<Giohang> giohangs = (List<Giohang>) session.getAttribute("giohang");
			model.addAttribute("soluonggiohang", giohangs.size());
			System.out.println("soluongcotronggio" + "-"+ giohangs.size());
		}
//		List<Chitiettour> items = chitiettourService.findAll();
//		model.addAttribute("items", items);
		Giatour pro = giatourRepository.finbyIdtour(idtour);
		model.addAttribute("pro", pro);
		if(principal == null) {
			return "view/chitiet";
		}else {
		String userName = principal.getName();
		model.addAttribute("userName", userName);
		System.out.println("User Name tai chi tiet: " + userName);
		return "view/chitiet";
		}
	}
		
//	@RequestMapping("k/{idtour}")
//	public @ResponseBody List<Giatour> loadchitiets(ModelMap model, @PathVariable("idtour") Long idtour) {
//		
////		Chitiettour item = chitiettourService.findByIdchitiettour(idchitiettour);
////		model.addAttribute("item" , item);
////		List<Chitiettour> khang = chitiettourService.findByIdchitiettour(idchitiettour);
////		model.addAttribute("k", khang);
////		Tour tour = tourService.findByIdtour(item.get)
////		List<Chitiettour> items = chitiettourService.findAll();
////		model.addAttribute("items", items);
//		Giatour pro = giatourRepository.finbyIdtour(idtour);
//		model.addAttribute("pro", pro);
//		return pro;
//	}
//	@GetMapping("tour/{idtour}")
//	public @ResponseBody List<ChitiettourDto> listdiadiembytinh(@PathVariable(name = "idtour") Long idtour){
//		List<ChitiettourDto> listdiadiem = new ArrayList<>();
//			Tour tour =  tourService.findByIdtour(idtour);
//			List<Chitiettour> chitiettours = tour.getChitiettours();
//			for( Chitiettour chitiettour : chitiettours) {
//				ChitiettourDto dto = new ChitiettourDto(chitiettour.getIdchitiettour(), chitiettour.getGhichu());
//				listdiadiem.add(dto);
//			}
//			return listdiadiem;
//	}
//	@GetMapping("chitiet/{idchitiettour}")
//	public @ResponseBody List<TourDto> listdiadiembychi(@PathVariable(name = "idchitiettour") Long idchitiettour){
//		List<TourDto> listdiadiem = new ArrayList<>();
//			Chitiettour chitiettour =  chitiettourService.findByIdchitiettour(idchitiettour);
//			List<Tour> tours = chitiettour.getTour();
//			for( Chitiettour chitiettour : chitiettours) {
//				ChitiettourDto dto = new ChitiettourDto(chitiettour.getIdchitiettour(), chitiettour.getGhichu());
//				listdiadiem.add(dto);
//			}
//			return listdiadiem;
//	}
}
