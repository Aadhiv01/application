package com.example.demo;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	

	@RequestMapping("/checkIn")
	public ModelAndView ChIn(@RequestParam("name") String myname) {
		
		ModelAndView mv = new ModelAndView();
		LocalDate d = LocalDate.now();
		LocalTime t = LocalTime.now();
		
		mv.addObject("type","IN");
		mv.addObject("date",d);
		mv.addObject("time",t);
		String id = myname + t;
		mv.addObject("id",id);
		mv.setViewName("home");
		System.out.println(id);
		return mv;
	}
	
	@RequestMapping("/checkOut")
	public ModelAndView ChOut(@RequestParam("name") String myname) {
		
		ModelAndView mv = new ModelAndView();
		LocalDate d = LocalDate.now();
		LocalTime t = LocalTime.now();
		
		mv.addObject("type","OUT");
		mv.addObject("date",d);
		mv.addObject("time",t);
		String id = myname + t;
		mv.addObject("id",id);
		mv.setViewName("home");
		return mv;
	}
}