package com.example.demo.controller.request;

import com.example.demo.entity.TestMember;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/* entity: 다뤄야 하는 최중요 데이터. 오염되면 절대 안 됨. */
@Controller
@RequestMapping(value = "/request")
public class RequestTestController {
    private static final Logger log =
            LoggerFactory.getLogger(RequestTestController.class);

    @GetMapping("/registerForm")
    public String registerForm() {
        log.info("registerForm()");

        return "spring/request/registerForm";
    }

    @GetMapping("/register")
    /* by: 파라미터가 들어와서 레지스터 */
    public String doRegisterByParameter(
            String userId, String passwd) {

        log.info("doRegisterByParameter()");
        log.info("userId = " + userId);
        log.info("passwd = " + passwd);

        return "html_css/success.html";
    }

    @PostMapping("/register")
    /* with: 파라미터가 보이지 않게 레지스터 */
    public String doRegisterWithVoidParameter(
            String userId, String passwd) {

        log.info("doRegisterWithVoidParameter()");
        log.info("userId = " + userId);
        log.info("passwd = " + passwd);

        return "html_css/success.html";
    }

    @GetMapping("/registerByEntity")
    /* by: 엔티티를 이용한다. */
    public String doRegisterByEntity(TestMember tm) {
        log.info("doRegisterByEntity()");
        log.info("userId = " + tm.getUserName());
        log.info("passwd = " + tm.getPassword());

        return "html_css/success.html";
    }

    @PostMapping("/registerWithEntity")
    public String doRegisterWithEntity(TestMember tm) {
        log.info("doRegisterWithEntity()");
        log.info("userId = " + tm.getUserName());
        log.info("passwd = " + tm.getPassword());

        return "html_css/success.html";
    }
}
