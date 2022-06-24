package edu.poly.shop.controller.admin;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
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
import edu.poly.shop.service.DiadiemService;
import edu.poly.shop.service.LoaitourService;
import edu.poly.shop.service.PhuongtienService;
import edu.poly.shop.service.StorageService;
import edu.poly.shop.service.TinhService;
import edu.poly.shop.service.TourService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import javax.validation.Valid;


@Controller
@RequestMapping("admin/tour")
public class TourController {
	 @Autowired
	 TourService tourService;
	 @Autowired
	 DiadiemService diadiemService;
	 @Autowired
	 TinhService tinhService;
	 @Autowired
	 LoaitourService loaitourService;
	 @Autowired
	 PhuongtienService phuongtienService;
	 @Autowired
	 StorageService storageService;
	@RequestMapping("add")
	public String add(Model model) {
		model.addAttribute("tour", new TourDto());
		return "admin/tour/addOrEdit";
	}
	// load tinh
	@ModelAttribute("tinh")
	public List<TinhDto> getTinh() {
		return tinhService.findAll().stream().map(item -> {
			TinhDto dto = new TinhDto();
			BeanUtils.copyProperties(item, dto);
			return dto;
		}).toList();
	}
	// load dia diem
	@ModelAttribute("diadiem")
	public List<DiadiemDto> getDiadiem() {
		return diadiemService.findAll().stream().map(item -> {
			DiadiemDto dto = new DiadiemDto();
			BeanUtils.copyProperties(item, dto);
			return dto;
		}).toList();
	}
	//load loai tour
	@ModelAttribute("loaitour")
	public List<LoaitourDto> getLoaitour(){
		return loaitourService.findAll().stream().map(item-> {
			LoaitourDto dto = new LoaitourDto();
			BeanUtils.copyProperties(item, dto);
			return dto;
		}).toList();
	}
	//load phuong tien
	@ModelAttribute("phuongtien")
	public List<PhuongtienDto> getPhuongtien(){
		return phuongtienService.findAll().stream().map(item->{
			PhuongtienDto dto = new PhuongtienDto();
			BeanUtils.copyProperties(item, dto);
			return dto;
		}).toList();
	}
	@GetMapping("edit/{idtour}")
	public ModelAndView edit(ModelMap model, @PathVariable("idtour") Long idtour) {
		Optional<Tour> opt = tourService.findById(idtour);
		TourDto dto = new TourDto();
		if(opt.isPresent()) {
			Tour entity = opt.get();
			// hien thi ten loai tour
			dto.setIdloaitour(entity.getLoaitour().getIdloaitour());
		// hine thi dia diem tour
			dto.setIddiadiem(entity.getDiadiem().getIddiadiem());
			//hien thi phuong tien
			dto.setIdphuongtien(entity.getPhuongtien().getIdphuongtien());
			BeanUtils.copyProperties(entity, dto);
			dto.setIsEdit(true);
			model.addAttribute("tour", dto);
			return new ModelAndView("admin/tour/addOrEdit", model) ;
		
//		Optional<Tour> opt = tourService.findById(idtour);
//		TourDto dto = new TourDto();
//
//		if (opt.isPresent()) {
//			Tour entity = opt.get();
//			BeanUtils.copyProperties(entity, dto);
//
//			// hien thi ten loai tour
//			dto.setIdtour(entity.getLoaitour().getIdloaitour());
//			// hine thi dia diem tour
//			dto.setIddiadiem(entity.getDiadiem().getIddiadiem());
//			// hien thi tinh
//			dto.setIsEdit(true);
//			model.addAttribute("tour", dto);
//			return new ModelAndView("admin/tour/addOrEdit", model);

		}

		model.addAttribute("message", "tour is not existed");
		return new ModelAndView("forward:/admin/tour/addOrEdit", model);
	}

	@GetMapping("delete/{idtour}")
	public ModelAndView delete(ModelMap model, @PathVariable("idtour") Long idtour) {
		tourService.deleteById(idtour);
		model.addAttribute("message", "tour is delete!");
		return new ModelAndView("redirect:/admin/tour", model);
	}

	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("tour") TourDto dto, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("admin/tour/addOrEdit");
		}
		
		Tour entity = new Tour();
		BeanUtils.copyProperties(dto, entity);
		// luu loai tour
		Loaitour loaitour = new Loaitour();
		loaitour.setIdloaitour(dto.getIdloaitour());
		entity.setLoaitour(loaitour);
		// luu dia diem
		Diadiem diadiem = new Diadiem();
		diadiem.setIddiadiem(dto.getIddiadiem());
		entity.setDiadiem(diadiem);
		// luu phuong tien
		Phuongtien phuongtien = new Phuongtien();
		phuongtien.setIdphuongtien(dto.getIdphuongtien());
		entity.setPhuongtien(phuongtien);
		
//		if(!dto.getImageFile().isEmpty()) {
//			UUID uuid = UUID.randomUUID();
//			String uuString = uuid.toString();
//			entity.setHinhanh(storageService.getStoredFilenmae(dto.getImageFile(), uuString));
//			storageService.store(dto.getImageFile(), entity.getHinhanh());
//		}
		tourService.save(entity);
		model.addAttribute("message", "tour is");
		return new ModelAndView("forward:/admin/tour", model);

	}
	
	@RequestMapping("")
	public String list(ModelMap model) {
		List<Tour> list = tourService.findAll();
		model.addAttribute("tour", list);
		return "admin/tour/list";
	}

//	@ModelAttribute("getDiadiemByIdtinh")
//	public String getDiadiemByIdtinh(@RequestParam("idtinh") Long idtinh) {
//		return diadiemService.findByTourdId(idtinh).stream().map(item -> {
//			String output = "";
//			DiadiemDto dto = new DiadiemDto();
//			BeanUtils.copyProperties(item, dto);
//			output+="<option th:each="+dto.getDiemden()+"th:value="+dto.getIddiadiem();
//			return output;
//		}).toString();
//	}
	
	@GetMapping("tinh/{idtinh}")
	public @ResponseBody List<DiadiemDto> listdiadiembytinh(@PathVariable(name = "idtinh") Long idtinh){
		List<DiadiemDto> listdiadiem = new ArrayList<>();
			Tinh tinh =  tinhService.findByIdtinh(idtinh);
			List<Diadiem> diadiems = tinh.getDiadiems();
			for( Diadiem diadiem : diadiems) {
				DiadiemDto dto = new DiadiemDto(diadiem.getIddiadiem(), diadiem.getDiemden());
				listdiadiem.add(dto);
			}
			return listdiadiem;
	}
//	@GetMapping("diadiem/{idtinh}")
//	@ResponseBody
//	public Tinh getTinh(@PathVariable(name = "idtinh") Long idtinh) {
//		return tinhService.findById(idtinh);
//	}

//		@ModelAttribute("diadiem")
//		public String getDiadiemByIdtinh(@PathVariable("idtinh") Long idtinh) {
//			return diadiemService.findByIdtinh(idtinh).stream().map(item -> {
//				DiadiemDto dto = new DiadiemDto();
//				BeanUtils.copyProperties(item, dto);
//				output+="<option th:each="+dto.getDiemden()+"th:value="+dto.getIddiadiem();
//				return output;
//			}).toString();
//		}
}
