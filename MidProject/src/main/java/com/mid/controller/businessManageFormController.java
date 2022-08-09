package com.mid.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mid.common.Controller;
import com.mid.common.Utils;
import com.mid.service.AccommodationService;
import com.mid.service.BusinessService;
import com.mid.service.RoomService;
import com.mid.vo.Accommodation;
import com.mid.vo.Business;
import com.mid.vo.BusinessList;

public class businessManageFormController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memberId = (String) req.getSession().getAttribute("id");
		
		// 사업자 정보 가져오기
		BusinessService service = BusinessService.getInstance();
		List<Business> list = service.selectAll(memberId);
		Business business = list.get(0);
		
		// 해당 사업자의 숙소정보 가져오기
		AccommodationService service2 = AccommodationService.getInstance();
		List<Accommodation> acc = service2.selectAllForBusiness(business.getBusinessId());
		
		// 해당 숙소의 객실정보 가져오기
		RoomService service3 = RoomService.getInstance();
		List<BusinessList> resultList = new ArrayList<>();
		acc.forEach(x -> {
			BusinessList temp = new BusinessList();
			temp.setAcc(x);
			temp.setRoomList(service3.selectAllForBusiness(x.getAccId()));
			resultList.add(temp);
		});
		
		req.setAttribute("business", business);
		req.setAttribute("resultList", resultList);
		
		Utils.forward(req, resp, "business/businessManage.tiles");
	}
}
