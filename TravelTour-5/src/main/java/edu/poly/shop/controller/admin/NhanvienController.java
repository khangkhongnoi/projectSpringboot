package edu.poly.shop.controller.admin;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.poly.shop.domain.Khachhang;
import edu.poly.shop.domain.Nhanvien;
import edu.poly.shop.domain.Phuongtien;
import edu.poly.shop.model.KhachhangDto;
import edu.poly.shop.model.NhanvienDto;
import edu.poly.shop.model.PhuongtienDto;
import edu.poly.shop.repository.NhanvienRepository;
import edu.poly.shop.service.NhanvienService;

@Controller
@RequestMapping("admin/nhanvien")
public class NhanvienController {
	@Autowired
	NhanvienService nhanvienService;
	
	@GetMapping("add")
	public String add( ModelMap model) {
	model.addAttribute("nhanvien", new NhanvienDto());
		return "admin/nhanvien/addOrEdit";
	}
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model,@Valid @ModelAttribute("nhanvien") NhanvienDto dto, BindingResult result) {
		List<Nhanvien> foundNhanvien = nhanvienService.findByTennhanvien(dto.getTennhanvien().trim());
		if(result.hasErrors() || foundNhanvien.size() > 0) {
			model.addAttribute("message", "Tên nhân viên " + dto.getTennhanvien() + " đã tồn tại !");
			return new ModelAndView("admin/nhanvien/addOrEdit");
		}
		Nhanvien entity = new Nhanvien();
		BeanUtils.copyProperties(dto, entity);
		nhanvienService.save(entity);
		model.addAttribute("message", "Thêm nhân viên " + dto.getTennhanvien() + " thành công");
		
		return new ModelAndView("forward:/admin/nhanvien", model);
	}
	@RequestMapping("")
	public String list(ModelMap model) {
		List<Nhanvien> list = nhanvienService.findAll();
		model.addAttribute("nhanvien",list);
		return "admin/nhanvien/list";
	}
	@GetMapping("edit/{idnhanvien}")
	public ModelAndView edit(ModelMap model, @PathVariable("idnhanvien") Long idnhanvien) {
		Optional<Nhanvien> opt = nhanvienService.findById(idnhanvien);
		NhanvienDto dto = new NhanvienDto();

		if (opt.isPresent()) {
			Nhanvien entity = opt.get();
			BeanUtils.copyProperties(entity, dto);
		    
			
//			// hien thi ten loai tournew
//			dto.setIdtour(entity.getLoaitour().getIdloaitour());
//			// hine thi dia diem tour
//			dto.setIddiadiem(entity.getDiadiem().getIddiadiem());
//			// hien thi tinh
			dto.setIsEdit(true);
			model.addAttribute("khachhang", dto);
			return new ModelAndView("admin/nhanvien/addOrEdit", model);
			
		}

		model.addAttribute("message", "tour is not existed");
		return new ModelAndView("forward:/admin/khachhang/addOrEdit", model);
	}
}
