package pkb.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pkb.board.domain.Board;
import pkb.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("list.do")
	public ModelAndView list() {
		List<Board> list = boardService.listS();
		
		ModelAndView mv = new ModelAndView("board/list", "list", list);		
		
		return mv;
	}
	
	@GetMapping("write.do")
	public String write() {
		return "board/write";
	}
	
	@PostMapping("write.do")
	public String write(Board board) {
		boardService.insertS(board);
		
		return "redirect:list.do";
	}
	
	@GetMapping("read.do")
	public ModelAndView read(long seq) {
		Board board = boardService.selectS(seq);
		
		ModelAndView mv = new ModelAndView("board/content", "board", board);
		
		return mv;
	}
	
	@GetMapping("update.do")
	public ModelAndView update(long seq) {
		Board board = boardService.selectS(seq);
		
		ModelAndView mv = new ModelAndView("board/update", "board", board);
		
		return mv;
	}
	
	@PostMapping("update.do")
	public String update(Board board) {
		boardService.updateS(board);
		
		return "redirect:read.do";
	}
	
	@GetMapping("delete.do")
	public String delete(long seq) {
		boardService.deleteS(seq);
		
		return "redirect:list.do";
	}
	
}
