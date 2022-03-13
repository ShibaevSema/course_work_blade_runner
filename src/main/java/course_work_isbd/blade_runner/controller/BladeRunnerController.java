package course_work_isbd.blade_runner.controller;

import course_work_isbd.blade_runner.dto.request.HumanRequest;
import course_work_isbd.blade_runner.entities.ReplicantSearch;
import course_work_isbd.blade_runner.services.BladeRunnerService;
import course_work_isbd.blade_runner.services.EntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/blade_runners")
@RequiredArgsConstructor
public class BladeRunnerController {
    private final BladeRunnerService bladeRunnerService;


    @GetMapping("/get/br_tasks")
    public ResponseEntity<?> getAllEntities() {
        return ResponseEntity.ok(bladeRunnerService.getTasks());
    }


//    @PostMapping("/register/entity")
//    public ResponseEntity<?> saveEntity(@RequestBody ReplicantSearchRequest search) {
//        return ResponseEntity.ok(bladeRunnerService.createEntity(human));
//    }
}
