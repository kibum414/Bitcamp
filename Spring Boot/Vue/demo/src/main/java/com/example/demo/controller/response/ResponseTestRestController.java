package com.example.demo.controller.response;

import com.example.demo.entity.TestMember;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/* RestController는 기본적으로 데이터 형식을 json으로 처리함 */
/* 데이터 처리할 경우 */
@RestController
public class ResponseTestRestController {
    private static final Logger log =
            LoggerFactory.getLogger(ResponseTestRestController.class);

    /* ResponseBody 필요 없음 */
    @GetMapping("/responseRestTestMember")
    public TestMember getTestMember() {
        log.info("getTestMember()");

        TestMember tm = new TestMember();

        return tm;
    }

    /* json 데이터 처리할 때 collection 자주 사용 (응답 속도 향상) */
    @GetMapping("/responseTestMemberMap")
    public Map<String, TestMember> getTestMemberMap() {
        log.info("getTestMemberMap()");

        Map<String, TestMember> map =
                new HashMap<String, TestMember>();

        TestMember tm1 = new TestMember();
        map.put("key1", tm1);

        TestMember tm2 = new TestMember();
        map.put("key2", tm2);

        return map;
    }
}
