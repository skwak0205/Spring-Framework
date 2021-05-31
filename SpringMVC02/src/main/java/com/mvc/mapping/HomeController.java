package com.mvc.mapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.mapping.dto.AddressDto;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	// 넘어오는 변수 이름이 dto의 setter의 이름과 같으면 자동으로 넣음 (command object)
	@RequestMapping(value="/command.do", method=RequestMethod.GET)
	public String getCommand(Model model, String name, @RequestParam("addr")String address, String phone) {
		
		model.addAttribute("dto", new AddressDto(name, address, phone));
		
		return "getcommand";
	}
	
	@RequestMapping(value="/command.do", method=RequestMethod.POST)
	public String postcommand(Model model, @ModelAttribute AddressDto dto) { // @ModelAttribute 생략가능
		
		model.addAttribute("dto", dto);
		
		return "postcommand";
	}
}
