package kb.dev.api.user.controller;

import kb.dev.api.user.domain.UserVo;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
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

    @GetMapping("/all")
    public ResponseEntity<List<UserVo>> all() {
        log.info("로그인 하지 않은 사용자도 접근 가능한 URI");

        return ResponseEntity.ok(null);
    }

    @PostMapping("/{username}")
    public ResponseEntity<?> auth(@PathVariable String username) {
        log.info("로그인 한 사용자만 접근 가능한 URI");

        return ResponseEntity.ok(null);
    }

    @PostMapping("/admin")
    public ResponseEntity<?> admin() {
        log.info("관리자만 접근 가능한 URI");

        return ResponseEntity.ok(null);
    }
}
