package com.mvc.upgrade.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.upgrade.model.biz.MYBoardBiz;
import com.mvc.upgrade.model.dto.MYBoardDto;

@Controller
public class MYBoardController {
	
	@Autowired
	private MYBoardBiz biz;
	
	@RequestMapping("/list.do")
	public String selectList(Model model) {
		
		List<MYBoardDto> list = biz.selectList();
		
		model.addAttribute("list", list);
		
		return "myboardlist";
	}
	
	@RequestMapping("/insertform.do")
	public String insertForm() {
		return "myboardinsert";
	}
	
	@RequestMapping("/insertres.do")
	public String insertRes(MYBoardDto dto) {
		
		if(biz.insert(dto) > 0) {
			return "redirect:list.do";
		}
		
		return "redirect:inserform.do";
	}
	
	@RequestMapping("/select.do")
	public String selectOne(Model model, int myno) {
		
		MYBoardDto dto = biz.selectOne(myno);
		
		model.addAttribute("dto", dto);
		
		return "myboardselect";
	}
	
	@RequestMapping("/updateform.do")
	public String updateForm(Model model, int myno) {
		MYBoardDto dto = biz.selectOne(myno);
		
		model.addAttribute("dto", dto);
		
		return "myboardupdate";
	}
	
	@RequestMapping("/updateres.do")
	public String updateRes(MYBoardDto dto) {
		if(biz.update(dto) > 0) {
			return "redirect:select.do?myno="+dto.getMyno();
		}
		
		return "redirect:updateform.do?myno="+dto.getMyno();
	}
	
	@RequestMapping("/delete.do") 
	public String deleteOne(int myno) {
		if(biz.delete(myno) > 0) {
			return "redirect:list.do";
		}
		
		return "select.do?myno="+myno;
	}
	
	@RequestMapping("/test.do")
	public String test() {
		biz.test();
		
		return "redirect:list.do";
	}
}
