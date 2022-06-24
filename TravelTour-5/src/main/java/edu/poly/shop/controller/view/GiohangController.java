package edu.poly.shop.controller.view;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.poly.shop.domain.Giohang;

@Controller
@RequestMapping("giohang")
@SessionAttributes("giohang")
public class GiohangController {
	List<Giohang> giohangs = new ArrayList<>();
	
@RequestMapping("CapSoLuongNguoiLon")
@ResponseBody
public void CapSoLuongNguoiLon(HttpSession httpSession, Long idtour , int soluongnguoilon) {
	 if( null != httpSession.getAttribute("giohang")) {
		 List<Giohang> list = (List<Giohang>) httpSession.getAttribute("giohang"); 
		 int vitri = KiemTraTourDaTonTai(list, httpSession, idtour);
		 
//		 list.get(vitri).setSoluong(soluong);
		 list.get(vitri).setSoluongnguoilon(soluongnguoilon);
//		 list.get(vitri).setSoluongtreem(soluongtreem);
		 
		 System.out.println(list.get(vitri).getSoluongnguoilon());
	 }
}
@RequestMapping("CapNhatSoLuongTreEM")
@ResponseBody
public void CapNhatSoLuongTreEM(HttpSession httpSession , Long idtour, int soluongtreem) {
	if(null != httpSession.getAttribute("giohang")) {
		List<Giohang> list = (List<Giohang>) httpSession.getAttribute("giohang");
		int vitri = KiemTraTourDaTonTai(list, httpSession, idtour);
		list.get(vitri).setSoluongtreem(soluongtreem);
		 System.out.println(list.get(vitri).getSoluongtreem());
	}
}

@RequestMapping("XoaGioHang")
@ResponseBody
public void XoaGioHang(HttpSession httpSession, Long idtour) {
	if(null != httpSession.getAttribute("giohang")) {
		List<Giohang> list = (List<Giohang>) httpSession.getAttribute("giohang"); 
		int vitri = KiemTraTourDaTonTai(list, httpSession, idtour);
		list.remove(vitri);
	}
}
	
	
@GetMapping("add")
@ResponseBody
	public void Themgiohang(@RequestParam Long idtour, @RequestParam String tentour,@RequestParam Long idgiatour, @RequestParam String gianguoilon , @RequestParam String giatreem,@RequestParam Integer soluongcon,@RequestParam Integer soluong ,@RequestParam Integer soluongnguoilon,  @RequestParam Integer soluongtreem,  String tongtien, HttpSession httpSession) {

	if(null == httpSession.getAttribute("giohang")) {
		Giohang giohang = new Giohang();
		giohang.setIdtour(idtour);
		giohang.setTentour(tentour);
		giohang.setIdgiatour(idgiatour);
		giohang.setGianguoilon(gianguoilon);
		giohang.setGiatreem(giatreem);
		giohang.setSoluongcon(soluongcon);
		giohang.setSoluong(1);
		giohang.setSoluongnguoilon(1);
		giohang.setSoluongtreem(0);
//		giohang.setTongtien(Integer.valueOf(gianguoilon) * soluong);
//	//
//		int tongtiens = Integer.valueOf(gianguoilon) * soluong;
//		System.out.println(tongtiens);
		giohangs.add(giohang);	
		httpSession.setAttribute("giohang", giohangs);
		List<Giohang> list = (List<Giohang>) httpSession.getAttribute("giohang"); 
		System.out.println(giohang.getGiatreem() + "-"+ list.size());
	}else
	{
		int vitri = KiemTraTourDaTonTai(giohangs, httpSession, idtour);
		if(vitri == -1) {
			List<Giohang> list = (List<Giohang>) httpSession.getAttribute("giohang"); 
			Giohang giohang = new Giohang();
			giohang.setIdtour(idtour);
			giohang.setTentour(tentour);
			giohang.setGianguoilon(gianguoilon);
			giohang.setGiatreem(giatreem);
			giohang.setSoluongcon(soluongcon);
			giohang.setSoluong(1);
			giohang.setSoluongnguoilon(1);
			giohang.setSoluongtreem(1);
	
			list.add(giohang);
//			System.out.println(giohang.getTongtien());
		}else {
			
			int soluongmoi = giohangs.get(vitri).getSoluongcon() - 1;
			giohangs.get(vitri).setSoluongcon(soluongmoi);
			int soluongmoi1 = giohangs.get(vitri).getSoluong() + 1;
			giohangs.get(vitri).setSoluong(soluongmoi1);
			int songuoilon = giohangs.get(vitri).getSoluongnguoilon() + 1;
			giohangs.get(vitri).setSoluongnguoilon(songuoilon);
			int sotreem = giohangs.get(vitri).getSoluongtreem()+1;
			giohangs.get(vitri).setSoluongtreem(sotreem);
		}
		
	}		
	List<Giohang> list = (List<Giohang>) httpSession.getAttribute("giohang");
	 for (Giohang giohang : list) {
		 
		System.out.println("matour" + "-" + giohang.getIdtour() + "- " +"idgiatour" + "-"+ giohang.getGianguoilon() + "soluongcon"+ "-" + giohang.getSoluongcon() +"-" +giohang.getSoluong());
	 
}
}
	private int KiemTraTourDaTonTai(List<Giohang> giohangs, HttpSession httpSession, Long idtour ) {
	
		for(int i = 0; i< giohangs.size(); i++) {
			if(giohangs.get(i).getIdtour() == idtour) {
				return i;
			}
		}
		return -1;
	}
	@GetMapping("LaySoLuongGioHang")
	@ResponseBody
	public String LaySoLuongGioHang(HttpSession session) {
		if( null != session.getAttribute("giohang")) {
			List<Giohang> giohangs = (List<Giohang>) session.getAttribute("giohang");
			return giohangs.size()+ "";
			
		}
		return "";
	}
	@GetMapping("xemgiohang")
	public String XemGioHang(HttpSession session, ModelMap model) {
		if( null != session.getAttribute("giohang")) {
			List<Giohang> giohangs = (List<Giohang>) session.getAttribute("giohang");
			model.addAttribute("soluonggiohang", giohangs.size());
			model.addAttribute("giohang", giohangs);
			
		}
		return "view/giohang";
	}

}
