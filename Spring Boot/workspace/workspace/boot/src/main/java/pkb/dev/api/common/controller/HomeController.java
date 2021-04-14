package pkb.dev.api.common.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class HomeController {

    @GetMapping("/")
    public String init() {
        return new SimpleDateFormat("yyMMdd HH:mm").format(new Date());
    }
}
