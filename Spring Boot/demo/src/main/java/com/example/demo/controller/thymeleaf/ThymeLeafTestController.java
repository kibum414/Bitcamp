package com.example.demo.controller.thymeleaf;

import com.example.demo.entity.TestMember;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/thymeleaf")
public class ThymeLeafTestController {
    private static final Logger log =
            LoggerFactory.getLogger(ThymeLeafTestController.class);

    // 'TestMember' available as request attribute
    // 속성 설정이 안 되어 있다는 에러 메시지가 나타난다.
    @GetMapping("/registerForm001")
    public String registerForm001() {
        log.info("registerForm001()");

        return "spring/thymeleaf/registerForm";
    }

    @GetMapping("/registerForm002")
    public String registerForm002(Model model) {
        log.info("registerForm002()");

        /* 모델은 데이터를 제어하는 객체라고 설명했었음
           스프링에서 활용할 수 있는 데이터 속성 이름으로 testMember를 만들었음
           또한 이 testMember 속성은 new TestMember()에 의해 생성된 객체를 가짐 */
        /* 이름이 같으면 안 됨 첫 글자 소문자 규칙 */
        model.addAttribute("testMember", new TestMember());

        return "spring/thymeleaf/registerForm";
    }

    @PostMapping("/register")
    public String doRegister(TestMember testMember, Model model) {
        log.info("doRegister()");
        log.info("userId = " + testMember.getUserName());
        log.info("passwd = " + testMember.getPassword());
        log.info("introduction = " + testMember.getIntroduction());

        List<String> hobbyList = testMember.getHobbyList();

        if (hobbyList != null) {
            log.info("hobbyList != null = " + hobbyList.size());

            for (int i = 0; i < hobbyList.size(); i++) {
                log.info("hobbyList(" + i + ") = " + hobbyList.get(i));
            }
        } else {
            log.info("hobbyList == null");
        }

        model.addAttribute("hobbyList", hobbyList);

        return "spring/thymeleaf/result.html";
    }

    @GetMapping("/registerForm003")
    public String registerForm003(Model model) {
        log.info("registerForm003()");

        model.addAttribute("testMember", new TestMember());

        return "spring/thymeleaf/introductionForm";
    }

    @GetMapping("/registerForm004")
    public String registerForm004(Model model) {
        log.info("registerForm004()");

        Map<String, String> hobbyMap = new HashMap<String, String>();
        hobbyMap.put("01", "Sports");
        hobbyMap.put("02", "Programming");
        hobbyMap.put("03", "Music");
        hobbyMap.put("04", "Movie");
        hobbyMap.put("05", "D.I.Y");

        model.addAttribute("hobbyMap", hobbyMap);
        model.addAttribute("testMember", new TestMember());

        return "spring/thymeleaf/hobbyForm";
    }
}
