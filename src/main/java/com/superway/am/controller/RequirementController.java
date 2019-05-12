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

import com.superway.am.pojo.Requirement;
import com.superway.am.pojo.Visit;
import com.superway.am.service.RequirementService;
import com.superway.am.service.VisitService;

/**
 * 问题需求
 * @author SunTH
 *
 */
@Controller
public class RequirementController {
	
	@Resource
	private RequirementService reqServiceImpl;
	
	@RequestMapping("reqInfo")
	public String visit(Model model) {
		return "html/requirement.html";
	}
	
	@ResponseBody
	@RequestMapping(value="reqCommit",method=RequestMethod.POST)
	public int commitInfo(HttpServletRequest request) {
		String content = request.getParameter("content");
		
		Requirement req = new Requirement();
		req.setCompany_name("博界科技");
		req.setCustomer_name("王处长");
		req.setCustomer_phone("18500983838");
		req.setType(1);
		req.setContent(content);
		req.setCreate_date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		int index = reqServiceImpl.insertRequirement(req);
		System.out.println(index);
		return index;
	}

}
