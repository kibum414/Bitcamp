package pkb.dev.api.pts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pkb.dev.api.pts.domain.Participant;
import pkb.dev.api.pts.service.ParticipantServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/participants")
@RequiredArgsConstructor
@CrossOrigin(origins="*")
public class ParticipantController {
	
	private final ParticipantServiceImpl service;
	
	@PostMapping("")
	public ResponseEntity<Participant> register(
			@Validated @RequestBody Participant participant) throws Exception {
		
		System.out.println("Participant register");
		
		service.save(participant);
		
		System.out.println("register ParticipantNo = "
				+ participant.getParticipantNo());
		
		return new ResponseEntity<>(participant, HttpStatus.OK);
	}
	
	@GetMapping("")
	public ResponseEntity<List<Participant>> list() throws Exception {
		
		System.out.println("Participant list");
		
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{participantNo}")
	public ResponseEntity<Optional<Participant>> detail(
			@PathVariable("participantNo") Long participantNo) throws Exception {
		
		System.out.println("Participant read");
		
		return new ResponseEntity<>(service.findById(participantNo), HttpStatus.OK);
	}
	
	@PutMapping("/{participantNo}")
	public ResponseEntity<Participant> modify(
			@PathVariable("participantNo") Long participantNo, 
			@Validated @RequestBody Participant participant) throws Exception {
		
		System.out.println("Participant modify");
		
		service.modify(participantNo, participant);
		
		return new ResponseEntity<>(participant, HttpStatus.OK);
	}
	
	@DeleteMapping("/{participantNo}")
	public ResponseEntity<Void> delete(
			@PathVariable("participantNo") Long participantNo) throws Exception {
		
		System.out.println("Participant delete");
		
		service.deleteById(participantNo);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
