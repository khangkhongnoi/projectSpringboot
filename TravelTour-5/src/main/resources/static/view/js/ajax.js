		// then vao gio hang	
			$(document).ready(function(){
				$(".btn-giohang").click(function(){
						var tentour = $("#tent").text();
						var gianguoilon = $(this).closest("ul").find(".gianguoilon").text();
						var giatreem = $(this).closest("ul").find(".giatreem").text();
						var idtour = $(this).closest("ul").find(".tentour").attr("value");
						var idgiatour = $(this).closest("ul").find(".gianguoilon").attr("value");
						var soluongcon = $("#soluongcon").text();
						alert(tentour + "-" + gianguoilon +  "-" +giatreem +"-" + idtour + "soluongcon" + soluongcon + "-" + "idgia" + idgiatour );
						$.ajax({
							url:"/giohang/add",
							type: "GET",
							data:{
							idtour:idtour,
							tentour:tentour,
							idgiatour:idgiatour,
							gianguoilon:gianguoilon,
							giatreem:giatreem,
							soluongcon:soluongcon,
							soluong:soluongcon,
							soluongnguoilon:soluongcon,
							soluongtreem:soluongcon
							},
							success: function(value){
								
							}
						})
					.done(function(){
						$.ajax({
							url:"/giohang/LaySoLuongGioHang",
							type: "GET",
								
							success: function(value){
									$("#giohang").find("div").addClass("soluonggiohang");
									$("#giohang").find("div").html("<span>" + value + "</span>");
								}
						})
						})
					});
		
			});
			// thay doi so luong
	$(document).ready(function(){
			$(".soluong-nguoilon").change(function(){
				var soluongnguoilon =$(this).val();
				var idtour = $(this).closest("tr").find(".tentour").attr("value");
				var gianguoilon = $(this).closest("tr").find(".gianguoilon").attr("value");
				var tongtien = soluongnguoilon * parseFloat(gianguoilon);
				var format = tongtien.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString()
				var tongtiensp = 0
				$(this).closest("tr").find(".gianguoilon").html(format + "."+ "000");
				 $(".gianguoilon").each(function(){
					 var giatien1 = $(this).text();
					 
					 var format = parseFloat(giatien1).toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString();
					 tongtiensp = tongtiensp + parseFloat(format);
					 var formattongtien = tongtiensp.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString();
					
					
					 $("#tongtien").html(formattongtien +"." + "000" + " VNĐ");
					 
					 
					 
						$.ajax({
							url:"/giohang/CapSoLuongNguoiLon",
							type: "GET",
							data:{
							idtour:idtour,
							soluongnguoilon:soluongnguoilon,
							},
							success: function(value){
								
							}
						}) 	
						
				 })
	
			})
			$(".xoa-giohang").click(function(){
				var idtour = $(this).closest("tr").find(".tentour").attr("value");
				var self = $(this);
				$.ajax({
					url:"/giohang/XoaGioHang",
					type: "GET",
					data:{
					idtour:idtour,
					},
					success: function(value){
						self.closest("tr").remove();
						GTTGH();
					}
				}) 	
			})
			
	});	
	
	// cap nhat so luong tre em
	$(document).ready(function(){
			$(".soluong-treem").change(function(){
				var soluongtreem =$(this).val();
				var idtour = $(this).closest("tr").find(".tentour").attr("value");
				var gianguoilon = $(this).closest("tr").find(".giatreem").attr("value");
				var tongtien = soluongtreem * parseFloat(gianguoilon);
				var format = tongtien.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString()
				var tongtiensp = 0
				$(this).closest("tr").find(".giatreem").html(format + "."+ "000");
				 $(".gianguoilon").each(function(){
					 var giatien1 = $(this).text();
					 
					 var format = parseFloat(giatien1).toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString();
					 tongtiensp = tongtiensp + parseFloat(format);
					 var formattongtien = tongtiensp.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString();
					 $("#tongtien").html(formattongtien +"." + "000" + " VNĐ");
						$.ajax({
							url:"/giohang/CapNhatSoLuongTreEM",
							type: "GET",
							data:{
							idtour:idtour,
							soluongtreem:soluongtreem,
							},
							success: function(value){
								
							}
						}) 	
						
				 })
	
			})
			
	});	
	// cap nhat tong tien nguoi lon moi khi load len view	
		$(".gianguoilon").each(function(){
		var giatien = $(this).attr("value");
		var soluong = $(this).closest("tr").find(".soluong-nguoilon").attr("value");
		
		var tongtien = soluong * parseFloat(giatien);
		
		var format = parseFloat(giatien).toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString();
		var format1 = tongtien.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString()

		$(this).closest("tr").find(".gianguoilon").html(format1+ "."+ "000");
	})
	// cap nhat tong tien tre em kho moi load len view
	$(".giatreem").each(function(){
		var giatien = $(this).attr("value");
		var soluong = $(this).closest("tr").find(".soluong-treem").attr("value");
		var tongtien = soluong * parseFloat(giatien);
		var format1 = tongtien.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString()
		$(this).closest("tr").find(".giatreem").html(format1+ "."+ "000");
	})
	 GTTGH();
	 //thanh tien tien
	function GTTGH(){
		var tongtiensp = 0
		 $(".gianguoilon").each(function(){
			 var giatien1 = $(this).text();
			 var giatien2 =  $(this).closest("tr").find(".giatreem").text(); 
			 var format = parseFloat(giatien1).toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString();
			  var format1 = parseFloat(giatien2).toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString();
			 tongtiensp = tongtiensp + parseFloat(format) + parseFloat(format1);
			 var formattongtien = tongtiensp.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString();
			 $("#tongtien").html(formattongtien +"." + "000" + " VNĐ");
			 
		 })
		 $(".giatreem").each(function(){
		 	var giatien2 = $(this).text();
		 	
		 	var format1 = parseFloat(giatien2).toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1,").toString();
		 	thanhtien = tongtiensp + parseFloat(format1);
		 
		 })
	}

