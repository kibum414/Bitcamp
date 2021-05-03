package kb.dev.api.user.controller;

import io.swagger.annotations.*;
import kb.dev.api.user.domain.UserDto;
import kb.dev.api.user.domain.UserVo;
import kb.dev.api.user.service.UserServiceImpl;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@Api(tags="users")
@RestController
@RequestMapping("/users")
public class UserController {

    private UserServiceImpl userService;

    @PostMapping("/signup")
    @ApiOperation(value = "${UserController.signin}")
    @ApiResponses(value={@ApiResponse(code=400, message="Something went wrong"),
            @ApiResponse(code=403, message="Access Denied"),
            @ApiResponse(code=422, message="Username is already in use")})
    public ResponseEntity<Long> signup(@ApiParam("Signup User") @RequestBody UserDto user) {
        return ResponseEntity.ok(userService.signup(user));
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
