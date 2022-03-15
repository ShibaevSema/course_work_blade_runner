package course_work_isbd.blade_runner.controller;

import course_work_isbd.blade_runner.dto.request.*;
import course_work_isbd.blade_runner.services.EntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/main")
@RequiredArgsConstructor
public class EntityGodController {
    private final EntityService entityService;

    @PostMapping("/register/entity")
    public ResponseEntity<?> saveEntity(@RequestBody HumanRequest human) {
        return ResponseEntity.ok(entityService.createEntity(human));
    }

    @PostMapping("/register/child")
    @Transactional
    public ResponseEntity<?> saveChild(@RequestBody DescendantRequest descendant) {
        return ResponseEntity.ok(entityService.createChild(descendant));
    }

    @PostMapping("/add/profession")
    public ResponseEntity<?> saveProfession(@RequestBody ProfessionRequest profession) {
        return ResponseEntity.ok(entityService.addProfession(profession));
    }

    @GetMapping("/get/entity_prof")
    public ResponseEntity<?> getEntityProfession(@RequestParam Long id) {
        return ResponseEntity.ok(entityService.getEntityProfession(id));
    }

    @PostMapping("/add/action")
    public ResponseEntity<?> saveAction(@RequestBody ActionRequest action) {
        return ResponseEntity.ok(entityService.addAction(action));
    }

    @GetMapping("/get/entity_actions")
    public ResponseEntity<?> getEntityActions(@RequestParam Long id) {
        return ResponseEntity.ok(entityService.getAllActions(id));
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


    @GetMapping("/get/relatives")
    public ResponseEntity<?> getEntityRelatives(@RequestParam Long id) {
        return ResponseEntity.ok(entityService.getEntityRelatives(id));
    }

    @GetMapping("/get/vk_test")
    public ResponseEntity<?> getEntityVKTest(@RequestParam Long id) {
        return ResponseEntity.ok(entityService.findEntityVKTest(id));
    }


}
