package com.example.demo.controller.board;

import com.example.demo.entity.Board;
import com.example.demo.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/real_board")
public class BoardController {
    private static final Logger log =
            LoggerFactory.getLogger(BoardController.class);

    // new로 생성자를 만들어야 하는 것을 자동화 시켜줌
    @Autowired
    private BoardService service;

    @GetMapping("list")
    public String getList(Model model) throws Exception {
        log.info("getList()");

        model.addAttribute("list", service.list());

        return "spring/real_board/list";
    }

    // HTML 처리 시 board 정보를 가지고 처리하게 됨 (주의)
    @GetMapping("/register")
    public String getRegister(Board board) {
        log.info("getRegister()");

        return "spring/real_board/register";
    }

    @PostMapping("/register")
    /* DB 쓰기 때문에 Exception Handling 필요 */
    public String doRegister(Board board, Model model)
            throws Exception {

        log.info("doRegister()");

        service.register(board);

        model.addAttribute("msg",
                "등록이 완료되었습니다.");

        return "spring/real_board/success";
    }

    @GetMapping("/read")
    public String read(int boardNo, Model model)
            throws Exception {
        log.info("read()");

        // 해당 정보를 Attribute에 세팅
        model.addAttribute(service.read(boardNo));

        return "spring/real_board/read";
    }

    @PostMapping("/remove")
    public String doRemove(int boardNo, Model model) throws Exception {
        log.info("doRemove()");

        service.remove(boardNo);

        // success 에서 msg를 받아서 출력해주는 구조
        model.addAttribute("msg",
                "성공적으로 지워졌습니다 !");

        return "spring/real_board/success";
    }

    @GetMapping("/modify")
    public String getModify(int boardNo, Model model) throws Exception {
        log.info("getModify()");

        model.addAttribute(service.read(boardNo));

        return "spring/real_board/modify";
    }

    @PostMapping("/modify")
    public String doModify(Board board, Model model) throws Exception {
        log.info("doModify()");

        service.modify(board);

        // success 에서 msg를 받아서 출력해주는 구조
        model.addAttribute("msg",
                "성공적으로 변경되었습니다.");

        return "spring/real_board/success";
    }
}
