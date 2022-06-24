package edu.poly.shop.controller.admin;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;
import org.springframework.util.StringUtils;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.poly.shop.domain.Diadiem;
import edu.poly.shop.domain.Tinh;
import edu.poly.shop.domain.Tour;
import edu.poly.shop.model.TinhDto;
import edu.poly.shop.service.TinhService;


@Service
@Controller
@RequestMapping("admin/tinh")
public class TinhController {
	@Autowired
	TinhService tinhService;
	
	@GetMapping("add")
	public String add(Model model) {
			model.addAttribute("tinh", new TinhDto());
			List<Tinh> list = tinhService.findAll();
			model.addAttribute("tinhs", list);
		return "admin/tinh/addOrEdit";
	}
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model,
		@Valid @ModelAttribute("tinh")
		 TinhDto dto , BindingResult result    ) {
		List<Tinh> foundTentinhs = tinhService.findByTentinh(dto.getTentinh().trim());
		if(result.hasErrors() || foundTentinhs.size() > 0) {
			model.addAttribute("message", "Tỉnh " + dto.getTentinh() + " Đã tồn tại!");
			List<Tinh> list = tinhService.findAll();
			model.addAttribute("tinhs", list);
			return new ModelAndView("admin/tinh/addOrEdit", model);
		}
		Tinh entity = new Tinh();
		BeanUtils.copyProperties(dto, entity);
		Diadiem diadiem = new Diadiem();
		
		tinhService.save(entity);
		model.addAttribute("message", "Them tinh " + dto.getTentinh() +  " thanh cong!");
		List<Tinh> list = tinhService.findAll();
		model.addAttribute("tinhs", list);
		
		return new ModelAndView("admin/tinh/addOrEdit", model) ;
		
	}
	@RequestMapping("")
		public String list(ModelMap model) {
			List<Tinh> list = tinhService.findAll();
			model.addAttribute("tinh", list);
			return "admin/tinh/list";
		}
	
	@GetMapping("edit/{idtinh}")
		public ModelAndView edit(ModelMap model, @PathVariable("idtinh") Long idtinh) {
		Optional<Tinh> opt = tinhService.findById(idtinh);
		TinhDto dto = new TinhDto();
		if(opt.isPresent()) {
			Tinh entity = opt.get();
			
			BeanUtils.copyProperties(entity, dto);
			dto.setIsEdit(true);
			model.addAttribute("tinh", dto);
			List<Tinh> list = tinhService.findAll();
			model.addAttribute("tinhs", list);
			return new ModelAndView("admin/tinh/addOrEdit", model) ;
		}
		
		model.addAttribute("meeage", "tinh is not extied");
		return new ModelAndView("forward:/admin/tinh", model);
	}
	
	@GetMapping("delete/{idtinh}")
		public ModelAndView delete(ModelMap model  ,@PathVariable("idtinh") Long idtinh) {
		tinhService.deleteById(idtinh);
		model.addAttribute("message", "tinh is delete!");
		
		return new ModelAndView("forward:/admin/tinh", model) ;
	}
	
	@GetMapping("search")
	public String search(ModelMap model,
			@RequestParam(name="tentinh" , required = false ) String tentinh) {
		 List<Tinh> list = null;
		if(StringUtils.hasText(tentinh)) {
			list = tinhService.findByTentinhContaining(tentinh);
		}else {
			list = tinhService.findAll();
		}
		
		
		model.addAttribute("tinh", list);
		
		return "admin/tinh/list";
	}
	
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
