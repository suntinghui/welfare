package com.superway.am.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.superway.am.pojo.Visit;
import com.superway.am.service.VisitService;

/**
 * 客户回访
 * @author SunTH
 *
 */
@Controller
public class VisitController {
	
	@Resource
	private VisitService visitServiceImpl;
	
	@RequestMapping("visitInfo")
	public String visit(Model model) {
		
//		List<Visit> list = visitServiceImpl.queryAll();
//		model.addAttribute("list", list);
		
		return "html/visit.html";
	}
	
	@ResponseBody
	@RequestMapping(value="visitCommit",method=RequestMethod.POST)
	public int commitInfo(HttpServletRequest request) {
    	String totalScore = request.getParameter("totalScore");
		String sysImplScore = request.getParameter("sysImplScore");
		String serviceScore = request.getParameter("serviceScore");
		String opinion = request.getParameter("opinion");
		
		Visit visit = new Visit();
		visit.setCompany_name("闪付科技");
		visit.setCustomer_name("张处长");
		visit.setCustomer_phone("18500983838");
		visit.setTotal_score(Integer.parseInt(totalScore));
		visit.setSysImpl_score(Integer.parseInt(sysImplScore));
		visit.setService_score(Integer.parseInt(serviceScore));
		visit.setOpinion(opinion);
		visit.setCreate_date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		int index = visitServiceImpl.insertVisit(visit);
		System.out.println(index);
		return index;
	}

}
