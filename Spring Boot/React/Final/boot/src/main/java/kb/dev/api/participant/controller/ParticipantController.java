package kb.dev.api.participant.controller;

import kb.dev.api.common.controller.AbstractController;
import kb.dev.api.participant.domain.Participant;
import kb.dev.api.participant.service.ParticipantServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/participants")
public class ParticipantController/* extends AbstractController<Participant>*/ {

    private final ParticipantServiceImpl service;

    @PostMapping("")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(service.count());
    }

//    @PostMapping("")
//    public ResponseEntity<Boolean> existsById(long id) {
//        return ResponseEntity.ok(service.existsById(id));
//    }
//
//    @PostMapping("")
//    public ResponseEntity<List<Participant>> findAll() {
//        return ResponseEntity.ok(service.findAll());
//    }
//
//    @PostMapping("")
//    public ResponseEntity<Optional<Participant>> findById(long id) {
//        return ResponseEntity.ok(service.findById(id));
//    }
//
//    @PostMapping("")
//    public ResponseEntity<Optional<Participant>> getOne(long id) {
//        return ResponseEntity.ok(service.getOne(id));
//    }
//
//    @PostMapping("")
//    public ResponseEntity<Long> save(Participant participant) {
//        return ResponseEntity.ok(service.save(participant));
//    }
//
//    @PostMapping("")
//    public ResponseEntity<Long> delete(Participant participant) {
//        return ResponseEntity.ok(service.delete(participant));
//    }
}
