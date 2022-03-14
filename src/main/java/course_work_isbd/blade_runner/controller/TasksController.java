package course_work_isbd.blade_runner.controller;

import course_work_isbd.blade_runner.dto.request.ReplicantSearchRequest;
import course_work_isbd.blade_runner.dto.request.TaskUpdateRequest;
import course_work_isbd.blade_runner.services.BladeRunnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blade_runners")
@RequiredArgsConstructor
public class TasksController {
    private final BladeRunnerService bladeRunnerService;

    @GetMapping("/get/tasks")
    public ResponseEntity<?> getAllTasks() {
        return ResponseEntity.ok(bladeRunnerService.getTasks());
    }

    @PostMapping("/register/task")
    public ResponseEntity<?> saveTasks(@RequestBody ReplicantSearchRequest search) {
        return ResponseEntity.ok(bladeRunnerService.createTask(search));
    }

    @PutMapping("/update/task")
    public ResponseEntity<?> updateTasks(@RequestBody TaskUpdateRequest task) {
        return ResponseEntity.ok(bladeRunnerService.updateTask(task));
    }

    @DeleteMapping("/delete/task")
    public ResponseEntity<?> deleteTasks(@RequestBody TaskUpdateRequest task) {
        return ResponseEntity.ok(bladeRunnerService.deleteTask(task));
    }


}
