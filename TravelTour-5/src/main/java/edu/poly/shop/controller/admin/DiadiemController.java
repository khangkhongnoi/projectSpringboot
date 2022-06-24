package edu.poly.shop.controller.admin;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.poly.shop.domain.Diadiem;
import edu.poly.shop.domain.Tinh;
import edu.poly.shop.model.DiadiemDto;
import edu.poly.shop.model.TinhDto;
import edu.poly.shop.service.DiadiemService;
import edu.poly.shop.service.TinhService;


@Service
@Controller
@RequestMapping("admin/diadiem")
public class DiadiemController {
	@Autowired
	DiadiemService diadiemService;
	
	@Autowired
	TinhService tinhService;
	// load id tinh 
	@ModelAttribute("tinh")
	public List<TinhDto> getTinh(){
		return tinhService.findAll().stream().map(item->{
			TinhDto dto = new TinhDto();

			BeanUtils.copyProperties(item, dto);
			return dto;
		}).toList();
	}

	@GetMapping("add")
	public String add(Model model) {
			model.addAttribute("diadiem", new DiadiemDto());
		return "admin/diadiem/addOrEdit";
	}
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model,
		@Valid @ModelAttribute("diadiem")
		 DiadiemDto dto , BindingResult result    ) {
		if(result.hasErrors()) {
			return new ModelAndView("admin/diadiem/addOrEdit");
		}
		Diadiem entity = new Diadiem();
		BeanUtils.copyProperties(dto, entity);
		// luu tinh
		Tinh tinh = new Tinh();
		tinh.setIdtinh(dto.getIdtinh());
		entity.setTinh(tinh);
		diadiemService.save(entity);
		model.addAttribute("message", "Them tinh thanh cong!");
		return new ModelAndView("forward:/admin/diadiem", model) ;
	}
	@RequestMapping("")
		public String list(ModelMap model) {
			List<Diadiem> list = diadiemService.findAll();
			model.addAttribute("diadiem", list);
			return "admin/diadiem/list";
		}
	
	@GetMapping("edit/{iddiadiem}")
		public ModelAndView edit(ModelMap model, @PathVariable("iddiadiem") Long iddiadiem) {
		Optional<Diadiem> opt = diadiemService.findById(iddiadiem);
		DiadiemDto dto = new DiadiemDto();
		if(opt.isPresent()) {
			Diadiem entity = opt.get();
			
			//load tinh
			dto.setIdtinh(entity.getTinh().getIdtinh());
			BeanUtils.copyProperties(entity, dto);
			dto.setIsEdit(true);
		
			model.addAttribute("diadiem", dto);
			return new ModelAndView("admin/diadiem/addOrEdit", model) ;
		}
		
		model.addAttribute("meeage", "thong báo thành công");
		return new ModelAndView("forward:/admin/diadiem", model);
	}
	
//	@GetMapping("delete/{idtinh}")
//		public ModelAndView delete(ModelMap model  ,@PathVariable("iddiadiem") Long iddiadiem) {
//		DiaDiemService.deleteById(iddiadiem);
//		model.addAttribute("message", "tinh is delete!");
//		
//		return new ModelAndView("forward:/admin/diadiem", model) ;
//	}
	
//	@GetMapping("search")
//	public String search(ModelMap model,
//			@RequestParam(name="tentinh" , required = false ) String tentinh) {
//		 List<Tinh> list = null;
//		if(StringUtils.hasText(tentinh)) {
//			list = tinhService.findByTentinhContaining(tentinh);
//		}else {
//			list = tinhService.findAll();
//		}
//		
//		
//		model.addAttribute("tinh", list);
//		
//		return "admin/tinh/list";
//	}
	
//	@GetMapping("search/paginated")
//	public String search(ModelMap model,
//			@RequestParam(name="tentinh" , required = false ) String tentinh,
//			@RequestParam("page") Optional<Integer> page,
//			@RequestParam("size") Optional<Integer> size) {
//		int currentPage = page.orElse(1);
//		int pageSize = size.orElse(6);
//		 
//		 Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.by("tentinh"));
//		 Page<Tinh> resultPage = null;
//		if(StringUtils.hasText(tentinh)) {
//			resultPage = tinhService.findByTentinhContaining(tentinh,pageable );
//			model.addAttribute("tentinh", tentinh);
//		}else {
//			resultPage = tinhService.findAll(pageable);
//		}
//		// tinh toan so trang hien thi
//		int totaPages = resultPage.getTotalPages();
//		if(totaPages > 0) {
//			int start = Math.max(1, currentPage - 2);
//			int end = Math.min(currentPage + 2, totaPages);
//			if(totaPages > 6) {
//				if(end == totaPages) start = end - 6;
//				else if (start == 1) end = start + 6;
//			}
//			List<Integer> pageNumbers = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
//			model.addAttribute("pageNumbers", pageNumbers);
//		}
//		
//		model.addAttribute("tinh", resultPage);
//		
//		return "admin/tinh/list";
//	}
}
