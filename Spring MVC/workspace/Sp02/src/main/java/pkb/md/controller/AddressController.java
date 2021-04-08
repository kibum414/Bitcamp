package pkb.md.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pkb.md.domain.Address;
import pkb.md.service.AddressService;

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
	public String write(Address address) { // 폼에 집어 넣는 것
		
		addressService.insertS(address);
		
		return "redirect:list.do"; // 재호출. 디폴드 값 : forward
	}
	
	@GetMapping("del.do")
	public String delete(long seq) {
		addressService.deleteS(seq);
		
		return "redirect:list.do";
	}
}

/*
list.jsp -> View
list -> Model (데이터를 담고 있는 모델, 뒷단의 모델과는 다름)


ModelAndView mv = new ModelAndView();
mv.setViewName("address/list"); // View
mv.addObject("list", list); // Model

축약
ModelAndView mv = new ModelAndView("address/list", "list", list);
어디로 보내는지가 가장 중요하기 때문에 View 먼저. 

list.do : 세계적 표준
naver의 경우 : list.nhn 으로 씀

MVC의 핵심 : 모든 요청은 다 컨트롤러로 간다.

redirect: 재호출
forward: 요청 전이

요청이 하나인데 여러 페이지를 거치는 것 : forward
요청이 또다른 요청을 계속 생성하는 것 : redirect

Client -> A.jsp -> B.jsp -> C.jsp -> Client

view(servlet)와 server request 공간 공

page < requestscope

forward가 기본값
forward 새로고침 시 url 안 바뀜. insert 계속 들어감 







*/