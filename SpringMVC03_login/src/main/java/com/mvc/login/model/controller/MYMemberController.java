package com.mvc.login.model.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.login.model.biz.MYMemberBiz;
import com.mvc.login.model.dto.MYMemberDto;

@Controller
public class MYMemberController {
	
	@Autowired
	private MYMemberBiz biz;
	
	@RequestMapping("/loginform.do")
	public String loginForm() {
		return "login";
	}
	
	@RequestMapping("/registerform.do")
	public String registerForm() {
		return "registerform";
	}
	
	@RequestMapping("/idcheck.do")
	public String idCheck(Model model, String memberid) {
		
		MYMemberDto dto = biz.idCheck(memberid);
		boolean idnotused = true;
		
		if(dto != null) {
			idnotused = false;
		}
		
		model.addAttribute("idnotused", idnotused);
		
		return "idchk";
	}
	
	@RequestMapping("/register.do")
	public String register(MYMemberDto dto) {
		if(biz.register(dto) > 0) {
			return "redirect:loginform.do";
		}
		
		return "redirect:registerform.do";
	}
	
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request, MYMemberDto dto) {
		HttpSession session = request.getSession();
		MYMemberDto user = biz.login(dto);
		if(user != null) {
			session.setAttribute("dto", user);
			session.setMaxInactiveInterval(10 * 60);
			
			return "usermain";
		}
		
		return "redirect:loginform.do";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "redirect:loginform.do";
	}
	
	@RequestMapping("/userinfo.do")
	public String userinfo(Model model, int memberno) {
		MYMemberDto dto = biz.selectOne(memberno);
		model.addAttribute("dto", dto);
		return "userinfo";	
	}
	
	@RequestMapping("/updateinfoform.do")
	public String infoForm(Model model, int memberno) {
		MYMemberDto dto = biz.selectOne(memberno);
		model.addAttribute("dto", dto);
		return "updateinfoform";
	}
	
	@RequestMapping("/updateinfo.do")
	public String updateInfo(MYMemberDto dto) {
		if(biz.update(dto) > 0) {
			return "redirect:userinfo.do?memberno="+dto.getMemberno();
		}
		
		return "redirect:updateinfoform.do?memberno="+dto.getMemberno();
	}
	
	@RequestMapping("/deleteinfo.do")
	public String deleteInfo(int memberno) {
		if(biz.delete(memberno) > 0) {
			return "redirect:loginform.do";
		}
		
		return "redirect:userinfo.do?memberno="+memberno;
	}
}
