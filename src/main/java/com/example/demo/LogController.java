package com.example.demo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LogController {
	
	@Autowired
	LoggerRepository repo;
	
	@GetMapping("/checkIN")
	public void chIn(@RequestParam("name") String myname) {
		String Id = myname+LocalTime.now().toString().substring(0,8);
		Logger l = new Logger();
		l.setDate(LocalDate.now());
		l.setTime(LocalTime.now());
		l.setLogType("IN");
		l.setId(Id);
		repo.save(l);
	}
	
	@GetMapping("/checkOUT")
	public void chOut(@RequestParam("name") String myname) {
		String Id = myname+LocalTime.now().toString().substring(0,8);
		Logger l = new Logger();
		l.setDate(LocalDate.now());
		l.setTime(LocalTime.now());
		l.setLogType("OUT");
		l.setId(Id);
		repo.save(l);
	}
	@GetMapping("/getLog")
	@ResponseBody
	public List<Logger> getByDate(@RequestParam("date") Date date) {
		//System.out.println("Printing the date path variable "+date);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/d");
		LocalDate d = LocalDate.parse(date.toString(),format);
		//System.out.println("Printing the converted date "+d);
		List<Logger> l = new ArrayList<>(repo.findByDate(d));
		//System.out.println(l.get(0));
		return l;
	}
	@GetMapping("/getAllLog")
	@ResponseBody
	public List<Logger> getall(@RequestParam("date") Date date) {
		List<Logger> l = (List<Logger>) repo.findAll();
		return l;
	}
}
