package course_work_isbd.blade_runner.controller;

import course_work_isbd.blade_runner.dto.request.*;
import course_work_isbd.blade_runner.services.EntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/main")
@RequiredArgsConstructor
public class EntityController {
    @Autowired
    private final EntityService entityService;

    @PostMapping("/register/entity")
    @Transactional
    public ResponseEntity<?> saveEntity(@RequestBody HumanRequest human) {
        return ResponseEntity.ok(entityService.createEntity(human));
    }

    @PostMapping("/register/child")
    public ResponseEntity<?> saveChild(@RequestBody DescendantRequest descendant) {
        return ResponseEntity.ok(entityService.createChild(descendant));
    }

    @GetMapping("/get/all_entities")
    public ResponseEntity<?> getAllEntities() {
        return ResponseEntity.ok(entityService.getAllEntities());
    }

    @GetMapping("/get/people")
    public ResponseEntity<?> getPeople() {
        return ResponseEntity.ok(entityService.getPeople());
    }

    @GetMapping("/get/replicants")
    public ResponseEntity<?> getReplicants() {
        return ResponseEntity.ok(entityService.getReplicants());
    }

    @GetMapping("/get/unknown_entities")
    public ResponseEntity<?> getUnknownEntities() {
        return ResponseEntity.ok(entityService.getUnknownEntities());
    }

    @GetMapping("/get/entity_prof")
    public ResponseEntity<?> getEntityProfession(@RequestParam Long id) {
        return ResponseEntity.ok(entityService.getEntityProfession(id));
    }

    @GetMapping("/get/relatives")
    public ResponseEntity<?> getEntityRelatives(@RequestParam Long id) {
        return ResponseEntity.ok(entityService.getEntityRelatives(id));
    }

    @GetMapping("/get/vk_test")
    public ResponseEntity<?> getEntityVKTest(@RequestParam Long id) {
        return ResponseEntity.ok(entityService.findEntityVKTest(id));
    }


}
