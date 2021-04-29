package com.example.demo.controller.vue;

import com.example.demo.entity.vue.VueBoard;
import com.example.demo.service.vue.VueBoardService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

// default:true 해주어야 boards: 로 넘어갈 수 있음

@Log
@RestController
// axios가 spring vue 연결
// /boards는 axios가 사용하는 것
@RequestMapping("/boards")
// 스프링이 7777, 8080 포트(뷰)에서 들어오는 요청에 대해 허용해주겠냐 ? *(모든 요청을 승인하겠다)
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class VueBoardController {

    @Autowired
    private VueBoardService service;

    // read: 게시물 읽기
    @GetMapping("/{boardNo}")
    public ResponseEntity<VueBoard> read(
            // PathVariable: boardNo를 가져와서 변수에 저장
            // 동적으로 url을
            @PathVariable("boardNo") Long boardNo) throws Exception {

        log.info("VueBoard read()");

        VueBoard board = service.read(boardNo);

        // json으로 보낸다. board를 뽑아서
        return new ResponseEntity<VueBoard>(board, HttpStatus.OK);
    }

    // list: 게시물 목록 보기
    @GetMapping("")
    public ResponseEntity<List<VueBoard>> list() throws Exception {
        log.info("VueBoard list()");

        // return new ResponseEntity<List<VueBoard>>(service.list(), HttpStatus.OK);
        // 리스트 전체를 배열로 넘기는 것
        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    // register: 게시물 등록하기
    @PostMapping("")
    public ResponseEntity<VueBoard> register(
            @Validated @RequestBody VueBoard board,
            UriComponentsBuilder uriBuilder) throws Exception {

        log.info("VueBoard POST register()");

        service.register(board);

        log.info("Register board.getBoardNo() = " + board.getBoardNo());

        // 강제로 할당해 주는 게 없으므로 ?
        /*
        URI resourceURI = uriBuilder.path("boards/{boardNo}")
                .buildAndExpand(board.getBoardNo())
                .encode()
                .toUri();

        return ResponseEntity.created(resourceURI).build();
         */

        // 등록한 board 정보를 확인하기 위함
        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    // remove: 게시물 삭제하기
    // delete는 DeleteMapping
    @DeleteMapping("/{boardNo}")
    public ResponseEntity<Void> remove(
            @PathVariable("boardNo") Long boardNo) throws Exception {
        log.info("remove");

        service.remove(boardNo);

        // 지우기만 하면 되므로 void
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    // modify: 게시물 수정하기
    // 수정은 PutMapping
    @PutMapping("/{boardNo}")
    public ResponseEntity<VueBoard> modify(
            @PathVariable("boardNo") Long boardNo,
            @Validated @RequestBody VueBoard board) throws Exception {

        log.info("Put - modify");
        System.out.println(board);

        board.setBoardNo(boardNo);
        service.modify(board);

        // 수정 후 보드 정보를 가져와서(service.modify(board))
        // ResponseEntity로 board 정보를 날려준 후 OK 때림

        // 적용하고 나서 read 페이지에 뿌려야 하므로 어떤 정보를 읽어야 할지
        return new ResponseEntity<>(board, HttpStatus.OK);
    }
}
