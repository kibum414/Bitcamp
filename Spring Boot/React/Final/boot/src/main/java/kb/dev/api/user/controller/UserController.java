package kb.dev.api.user.controller;

import kb.dev.api.user.domain.UserVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping("")
    public ResponseEntity<Long> join(@RequestBody UserVo userVo) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("")
    public ResponseEntity<List<UserVo>> fetch(@RequestBody UserVo userVo) {
        return ResponseEntity.ok(null);
    }

    @PutMapping("")
    public ResponseEntity<Long> update(@RequestBody UserVo userVo) {
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("")
    public ResponseEntity<Long> delete(@RequestBody UserVo userVo) {
        return ResponseEntity.ok(null);
    }
}
