package pkb.dev.api.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pkb.dev.api.user.domain.UserVo;
import pkb.dev.api.user.service.UserServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins="*")
@RequiredArgsConstructor
public class UserController {

	private final UserServiceImpl service;
	
	@PostMapping("")
	public ResponseEntity<?> register(@RequestBody UserVo userVo) throws Exception {
		
		System.out.println("User Register");
		
		service.save(userVo);
		
		return new ResponseEntity<>(userVo, HttpStatus.OK);
	}
	
	@GetMapping("")
	public ResponseEntity<List<UserVo>> list() throws Exception {
		
		System.out.println("User List");
		
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{userNo}")
	public ResponseEntity<Optional<UserVo>> read(
			@PathVariable("userNo") Long userNo) throws Exception {
		
		System.out.println("User Read");
		
		return new ResponseEntity<>(service.findById(userNo), HttpStatus.OK);
	}
	
	@PutMapping("/{userNo}")
	public ResponseEntity<UserVo> update(
			@PathVariable("userNo") Long userNo, @RequestBody UserVo userVo) {
		
		System.out.println("User Update");
		
		return new ResponseEntity<>(service.save(userVo), HttpStatus.OK);
	}
	
	@DeleteMapping("/{userNo}")
	public ResponseEntity<Void> delete(
			@PathVariable("userNo") Long userNo) {
		
		System.out.println("User Delete");
		
		service.deleteById(userNo);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UserVo userVo) {
		System.out.println("User Login");
		
		String username = service.login(userVo);
		
		if (username != null) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
}

/*
웹 서버 :

EC2 : IntelliJ
RDS : DB
S3 : VSCode

RDS - 데이터베이스 생성
데이터베이스 생성방식 선 표준 생성

vpc : virtual private cloud(amazon vpc)
아마존의 슬라이스 개념
계정별로 아마존의 기능을 조각조각 내주는 것
클라우드를 개인적으로 잘게 쪼개서 나누어준 것

 */