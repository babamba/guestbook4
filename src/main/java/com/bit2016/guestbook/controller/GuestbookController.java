package com.bit2016.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit2016.guestbook.dao.GuestbookDao;
import com.bit2016.guestbook.vo.GuestBookVo;


@Controller	
public class GuestbookController {
	@Autowired
	private GuestbookDao GuestBookDao;
	
	@RequestMapping("/list")
	public String list(Model model){
		List<GuestBookVo> list = GuestBookDao.getList();
		model.addAttribute("list", list);
		return "/WEB-INF/views/list.jsp";
	}
	
	
	@RequestMapping("/deleteform/{no}")
	public String deleteform(@PathVariable("no") int no, Model model){
		
		model.addAttribute("no", no);
		return "/WEB-INF/views/deleteform.jsp";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(@ModelAttribute GuestBookVo vo){
		GuestBookDao.delete(vo);
	return "redirect:/list";

	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(@ModelAttribute GuestBookVo vo){
		GuestBookDao.insert(vo);
		return"redirect:/list";
		
	}
	
}
