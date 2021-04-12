package pkb.md.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j;
import pkb.md.domain.Address;
import pkb.md.filesetting.Path;
import pkb.md.service.AddressService;

@Log4j
@Controller
@RequestMapping("/address/*")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@GetMapping("list.do")
	public ModelAndView list() {
		List<Address> list = addressService.listS();
		
		/*
		ModelAndView mv = new ModelAndView();
		mv.setViewName("address/list"); // View
		mv.addObject("list", list); // Model
		*/
		ModelAndView mv = new ModelAndView("address/list", "list", list); // forward
		
		return mv;
	}

	@GetMapping("write.do")
	public String write() { // 폼으로 이동
		return "address/write";
	}
	
	@PostMapping("write.do")
	/*
	public String write(HttpServletRequest request) {
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		Address address = new Address(-1, name, addr, null);
	*/
	public String write(Address address, @RequestParam ArrayList<MultipartFile> files) { // 폼에 집어 넣는 것
		log.info("#name: " + address.getName() + ", addr: " + address.getAddr());
		
		addressService.insertS(address);
		
		for (MultipartFile file: files) {
			String ofname = file.getOriginalFilename();
			
			log.info("#ofname: " + ofname);
			log.info("#size: " + file.getSize());
			
			if (ofname != null) ofname.trim();
			if (ofname.length() != 0) {
				addressService.saveStore(file);
			}
		}
		
		return "redirect:list.do"; // 재호출. 디폴드 값 : forward
	}
	
	@GetMapping("del.do")
	public String delete(long seq) {
		addressService.deleteS(seq);
		
		return "redirect:list.do";
	}
}
