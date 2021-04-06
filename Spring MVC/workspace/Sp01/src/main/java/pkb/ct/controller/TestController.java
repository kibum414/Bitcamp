package pkb.ct.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j;
import pkb.ct.domain.Human;

@Log4j
@Controller
@RequestMapping("/test/*")
public class TestController {

	@RequestMapping("/")
	public void m01() {
		System.out.println("m01()");
	}
	
	@RequestMapping("/base1")
	public void m02() {
		System.out.println("m02() - Get방식, Post방식, ...");
	}
	
	@RequestMapping(value = "/base2", method = RequestMethod.GET)
	public void m03() {
		System.out.println("m03() - only Get방식");
	}
	
	@RequestMapping(value = "/base3", method = {RequestMethod.GET, RequestMethod.POST})
	public void m04() {
		System.out.println("m04() - Get방식, Post방식");
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form() {
		return "test/form";
	}
	
	@RequestMapping("/param1")
	public void m05(@RequestParam String name, @RequestParam int age) {
		// public void m05(@RequestParam("na") String name, @RequestParam int age) {
		// public void m05(String name, int age) {
		log.info("m05() name: " + name + ", age: " + age);
	}
	
	@RequestMapping("/param2")
	public void m05(Human dto) {
		log.info("m06() name: " + dto.getName() + ", age: " + dto.getAge());
	}
}
