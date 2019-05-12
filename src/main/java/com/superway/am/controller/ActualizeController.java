package com.superway.am.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.superway.am.pojo.Actualize;
import com.superway.am.service.ActualizeService;

/**
 * 系统实施评价服务
 * @author SunTH
 *
 */
@Controller
public class ActualizeController {
	
	@Resource
	private ActualizeService actualizeServiceImpl;
	
	@RequestMapping("actualizeInfo")
	public String actualize(Model model) {
		
//		List<Actualize> list = actualizeServiceImpl.queryAll();
//		model.addAttribute("list", list);
		
		return "html/actualize.html";
	}
	
	@ResponseBody
	@RequestMapping(value="actualizeCommit",method=RequestMethod.POST)
	public int commitInfo(HttpServletRequest request) {
    	String totalScore = request.getParameter("totalScore");
		String mannerScore = request.getParameter("mannerScore");
		String timeScore = request.getParameter("timeScore");
		String delayScore = request.getParameter("delayScore");
		String opinion = request.getParameter("opinion");
		
		Actualize act = new Actualize();
		act.setCompany_name("瑞银科技");
		act.setCustomer_name("李处长");
		act.setCustomer_phone("18500983838");
		act.setTotal_score(Integer.parseInt(totalScore));
		act.setManner_score(Integer.parseInt(mannerScore));
		act.setTime_score(Integer.parseInt(timeScore));
		act.setDelay_score(Integer.parseInt(delayScore));
		act.setOpinion(opinion);
		act.setCreate_date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		int index = actualizeServiceImpl.insertActualize(act);
		System.out.println(index);
		return index;
	}

}
