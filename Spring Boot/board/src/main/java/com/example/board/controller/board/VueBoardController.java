package com.example.board.controller.board;

import com.example.board.entity.board.VueBoard;
import com.example.board.service.board.VueBoardService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

// static final Logger log =
// LoggerFactory.getLogger(VueBoardController.class); 와 같음
@Log
// @Controller: 전통적인 Spring MVC Controller
//              view(화면) 리턴하기 위함, @ResponseBody 사용해 객체 리턴 가능
// @RestController: Restful 웹서비스 컨트롤러
//                  데이터 리턴하기 위함, (=@Controller + @ResponseBody)
@RestController
@RequestMapping("/boards")
// 8080 포트에서 들어오는 모든(*) 요청(정보 등)을 승인하겠음
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class VueBoardController {
    // @Log 쓰면 없어도 됨
    // static final Logger log = LoggerFactory.getLogger(VueBoardController.class);

    @Autowired
    private VueBoardService service;

    @GetMapping("/{boardNo}")
    // RestController는 별도의 View를 제공하지 않는 형태로 서비스를 실행하기 때문에
    // 때로는 결과 데이터가 예외적인 상황에서 문제가 발생할 수 있음
    // ResponseEntity는 개발자가 직접
    // 결과 데이터와 HTTP 상태 코드를 제어할 수 있는 클래스로
    // 개발자는 404나 500 같은 HTTP 상태 코드를
    // 전송하고 싶은 데이터와 함께 전송할 수 있기 때문에
    // 좀 더 세밀한 제어가 필요한 경우 사용할 수 있음
    // ResponseEntity : 데이터 + HTTP Status Code
    //
    // Json으로 데이터 보내기 위해서 사용
    // board에 대한 정보, 리스트 하나 뽑아서 주겠다
    // 헤더와 바디, 상태 코드로 구성되어 있고 http 응답을 나타낼 때 사용
    // Http 응답을 편하게 구성하여 보낼 때 사용하는 클래스
    public ResponseEntity<VueBoard> read(
            // @PathVariable: URI를 동적으로 만들어서 동적인 것을 받기 위해서 사용
            //                URI의 경로에서 원하는 데이터를 추출하는 용도로 사용
            //                URI의 일부를 변수로 전달(boardNo 변수를 URI에 활용)
            @PathVariable("boardNo") Long boardNo) throws Exception {
        log.info("read()");

        // boardNo를 인자로 한 service의 read 메서드의 리턴 값을
        // VueBoard 형식의 board 변수에 저장
        VueBoard board = service.read(boardNo);
        System.out.println("VueBoardController: " + board);

        return new ResponseEntity<VueBoard>(board, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<VueBoard>> list() throws Exception {
        log.info("list()");

        // 리스트 전체를 통째로 보내는 것
        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    // web에서 받은 data를 java에서 사용 시 : web -> ( java Object 로 변환 ) -> java에서 활용
    // java에서 web으로 data 보낼 시  : java -> ( json Object 로 변환 ) ->  web
    //
    // @RequestBody: HTTP 요청의 body 내용을 java 객체로 매핑하는 역할
    //               POST 방식의 HTTP body 안에 JSON 으로 넘어온 값을 VO(데이타 객체)에 바인딩
    //               전송된 JSON 데이터를 객체로 변환해주는 어노테이션
    //               @RestController와 사용
    // @RestController는 @Controller와 다르게
    // return 값에 자동으로 @ResponseBody를 붙여
    // HTTP 응답 데이터(Body)에 자바 객체가 매핑되어 전달
    //
    // @ResponseBody: java 객체를 HTTP 요청의 body 내용으로 매핑하는 역할
    //                VO 객체를 JSON으로 바꿔서 HTTP body에 담는 스프링 어노테이션
    //                메서드의 return 값을 HTTP Response의 body에 담는 역할
    //                @Controller와 사용
    @PostMapping("")
    public ResponseEntity<VueBoard> register(
            // @Validated: 유효성 검증
            // HTTP 요청 내용을 VueBoard 객체에 매핑
            @Validated @RequestBody VueBoard board,
            // UriComponentsBuilder: 여러 개의 파라미터들을 연결하여 URL 형태로 만들어 줌
            UriComponentsBuilder uriBuilder) throws Exception {
        log.info("POST register()");

        service.register(board);

        log.info("register board.getBoardNo() = " + board.getBoardNo());

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

    // Vue axios에서 delete로 보냄
    @DeleteMapping("/{boardNo}")
    // 삭제는 지우기만 하면 되므로 void
    public ResponseEntity<Void> remove(
            @PathVariable("boardNo") Long boardNo) throws Exception {
        log.info("remove");

        service.remove(boardNo);

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    // Vue axios에서 put으로 요청
    // 같은 URL이어도 Put, Get, Post 등 어떻게 요청하냐에 따라 동작을 다르게 할 수 있음
    // 수정은 PutMapping
    @PutMapping("/{boardNo}")
    public ResponseEntity<VueBoard> modify(
            @PathVariable("boardNo") Long boardNo,
            @Validated @RequestBody VueBoard board) throws Exception {
        log.info("Put - modify()");
        System.out.println(board);

        // axios.put으로 수정한 정보가 전달되고
        // 게시글 번호 세팅하고 나서
        board.setBoardNo(boardNo);
        // 수정하고 수정한 형태를 service를 통해 DB에 적용
        service.modify(board);

        // 적용하고 나서 read 페이지에 뿌려야 하므로 어떤 것을 읽어야 할지 필요한 board 정보를 넘김
        return new ResponseEntity<>(board, HttpStatus.OK);
    }
}

/*
RequestMapping 관련 상세 어노테이션
1. @GetMapping: Get 방식의 Http(s) 요청 처리를 위한 어노테이션
 - Get 방식은 Header에 정보를 담아 보내므로 용량에 한계가 있어 정보를 호출할 때 주로 사용
2. @PostMapping: Post 방식의 Http(s) 요청 처리를 위한 어노테이션
 - Post 방식은 Http Body에 정보를 담아 보내므로 Get 방식보다 안전하여 새로운 정보를 등록할 때 주로 사용
3. @DeleteMapping: Delete를 위한 Http(s) 요청 처리 어노테이션
 - 기존의 정보를 삭제할 때 주로 사용
4. @PutMapping : Put 을 위한 Http(s) 요청 처리 어노테이션
 - 기존의 정보를 수정할 때 주로 사용
5. @PatchMapping : Patch 를 위한 Http(s) 요청 처리 어노테이션
 - 일부 정보를 수정할 때 사용


ResponseEntity
1) @ResponseBody 어노테이션 대신 사용
2) 오버로딩 된 메서드 ResponseEntity<List<리턴 타입>>(body, status)
 - body는 리턴 타입과 같은 타입이 들어가야 함
 - status는 HttpStatus의 상태를 지정하는 것
    1xx (정보): 요청을 받았으며 프로세스를 계속한다
    2xx (성공): 요청을 성공적으로 받았으며 인식했고 수용하였다
    3xx (리다이렉션): 요청 완료를 위해 추가 작업 조치가 필요하다
    4xx (클라이언트 오류): 요청의 문법이 잘못되었거나 요청을 처리할 수 없다
    5xx (서버 오류): 서버가 명백히 유효한 요청에 대해 충족을 실패했다

   HttpStatus.OK : 200 OK
     요청이 성공적으로 되었습니다. 성공의 의미는 HTTP 메소드에 따라 달라집니다.
     GET: 리소스를 불러와서 메시지 바디에 전송되었습니다.
     HEAD: 개체 해더가 메시지 바디에 있습니다.
     POST: 수행 결과에 대한 리소스가 메시지 바디에 전송되었습니다.
     TRACE: 메시지 바디는 서버에서 수신한 요청 메시지를 포함하고 있습니다.
     PUT 또는 DELETE의 성공 결과는 종종 200 OK가 아니라
     204 No Content (리소스를 새로 생성한 경우 201 Created) 입니다.

   HttpStatus.NO_CONTENT : 204 No Content
     HTTP 204 No Content 성공 상태 응답 코드는
     요청이 성공했으나 클라이언트가 현재 페이지에서 벗어나지 않아도 된다는 것을 나타냅니다.
     기본값에서 204 응답은 캐시에 저장할 수 있습니다.
     캐시에서 가져온 응답인 경우 ETag 헤더를 포함합니다.
     흔히 204를 반환하는 경우는 PUT 요청에 대한 응답으로,
     사용자에게 보여지는 페이지를 바꾸지 않고 리소스를 업데이트할 때 쓰입니다.
     리소스를 생성한 경우엔 201 Created를 대신 반환합니다.
     새롭게 업데이트한 페이지를 보여줘야 할 경우 200을 사용해야 합니다.

     204로 응답하는 예시다. 절대적이진 않다.
      PUT
       자원 수정 요청의 결과가 기존의 자원 내용과 동일하여 변경된 내용이 없을 때 204로 응답할 수 있다.
       만약 수정 요청으로 자원의 내용이 변경된다면 201로 응답할 것이다.
      DELETE
       삭제 요청으로 자원을 삭제하여 더이상 존재하지 않고 그 자원을 참조하는 모든 자원도 삭제되어
       더이상 HTTP body를 응답하는 것이 무의미해졌을 때 사용한다.

   HttpStatus.NOT_FOUND : 404 Not Found
     HTTP 404 Not Found 클라이언트 오류 응답 코드는
     서버가 요청받은 리소스를 찾을 수 없다는 것을 의미합니다.
     404 페이지를 띄우는 링크는 대체로 브로큰 링크(broken link) 또는 데드 링크(dead link)라고 부르며,
     link rot 대상일 수도 있습니다.
     404 상태 코드는 리소스가 일시적, 또는 영구적으로 사라졌다는 것을 의미하지는 않습니다.
     리소스가 영구적으로 삭제되었다면 404 상태 코드 대신 410 (Gone) 상태 코드가 쓰여야 합니다.

   HttpStatus.INTERNAL_SERVER_ERROR : 500 Internal Server Error
     하이퍼텍스트 전송 프로토콜 (HTTP) 500 Internal Server Error 서버 에러 응답 코드는
     요청을 처리하는 과정에서 서버가 예상하지 못한 상황에 놓였다는 것을 나타냅니다.
     이 에러 응답은 "서버 에러를 총칭하는"(catch-all) 구체적이지 않은 응답입니다.
     종종, 서버 관리자들은 미래에 같은 에러를 발생하는 것을 방지하기 위해
     500 상태 코드 같은 에러 응답들에 더 많은 자세한 내용을 남겨 둡니다.
 */