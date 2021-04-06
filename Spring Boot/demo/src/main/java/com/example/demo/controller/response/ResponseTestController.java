package com.example.demo.controller.response;

import com.example.demo.entity.TestMember;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/* URL 처리할 경우 */
@Controller
public class ResponseTestController {
    private static final Logger log =
            LoggerFactory.getLogger(ResponseTestController.class);

    /* ResponseBody는 json 타입으로 응답을 하겠다는 소리 */
    /* return tm;을 ResponseEntity로 만들어 줌 */
    @ResponseBody
    @GetMapping("/responseTestMember")
    public TestMember getTestMember() {
        log.info("getTestMember()");

        TestMember tm = new TestMember();

        return tm;
    }

    @ResponseBody
    @GetMapping("/responseTestMemberList")
    public List<TestMember> getTestMemberList() {
        log.info("getTestMemberList()");

        List<TestMember> list = new ArrayList<TestMember>();
        TestMember tm1 = new TestMember();
        list.add(tm1);

        TestMember tm2 = new TestMember();
        list.add(tm2);

        return list;
    }

    /* 꺽쇠 내부에 적는 코드는 모두 클래스 타입으로 맞춰주는 것이 좋다. */
    /* Void, Integer 같은 경우 void, int 와 다르게 클래스 타입 */
    @GetMapping("/responseVoidData")
    public ResponseEntity<Void> getVoidData() {
        log.info("getVoidData()");

        /* 결과 아무것도 안 뜸(void이기 때문)
           Network 들어가 보면 진행된 흔적은 남아 있음
           Network - General, Response

           Content-Length 개수 확인

           HttpStatus.OK: 요청 정상적으로 완료
         */
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    /* ResponseEntity 는 ResponseBody 포함 ? */
    @GetMapping("/responseOneData")
    public ResponseEntity<String> getOneData() {
        log.info("getOneData()");

        return new ResponseEntity<String>(
                "Success", HttpStatus.OK);
    }

    @GetMapping("/responseEntityTestMember")
    public ResponseEntity<TestMember> getTestMemberResponseEntity() {
        log.info("getTestmemberResponseEntity()");

        TestMember tm = new TestMember();

        return new ResponseEntity<TestMember>(tm, HttpStatus.OK);
    }

    @GetMapping("/responseEntityTestMemberList")
    public ResponseEntity<List<TestMember>>
    getTestMemberListResponseEntity() {
        log.info("getTestMemberListResponseEntity()");

        List<TestMember> list = new ArrayList<TestMember>();
        TestMember tm1 = new TestMember();
        list.add(tm1);

        TestMember tm2 = new TestMember();
        list.add(tm2);

        return new ResponseEntity<List<TestMember>>(
                list, HttpStatus.OK);
    }
}
