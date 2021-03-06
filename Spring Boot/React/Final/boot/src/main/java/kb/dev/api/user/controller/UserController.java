package kb.dev.api.user.controller;

import io.swagger.annotations.*;
import kb.dev.api.user.domain.UserDto;
import kb.dev.api.user.domain.UserVo;
import kb.dev.api.user.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@Api(tags="users")
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;
    private final ModelMapper modelMapper;

    @PostMapping("/signup")
    // application.yml 에 해당 메시지 추가
    @ApiOperation(value = "${UserController.signup}")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access Denied"),
            @ApiResponse(code = 422, message = "Username is already in use")})
    public ResponseEntity<String> signup(@ApiParam("Signup User") @RequestBody UserDto user) {
        // 컴파일 이후 매핑하기 때문에 .class
        // React로 토큰 발급됨
        return ResponseEntity.ok(userService.signup(modelMapper.map(user, UserVo.class)));
    }

    @PostMapping("/signin")
    @ApiOperation(value = "${UserController.signin}")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 422, message = "Invalid Username / Password supplied")})
    public ResponseEntity<UserDto> signin(@RequestBody UserDto user) {
        return ResponseEntity.ok(userService.signin(modelMapper.map(user, UserVo.class)));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<UserVo>> list() {
        return ResponseEntity.ok(userService.findAll());
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
