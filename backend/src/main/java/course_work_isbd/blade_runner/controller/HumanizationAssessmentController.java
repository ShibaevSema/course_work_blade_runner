package course_work_isbd.blade_runner.controller;

import course_work_isbd.blade_runner.services.HumanizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rating")
@RequiredArgsConstructor
public class HumanizationAssessmentController {
    private final HumanizationService humanizationService;

    @PostMapping("/humanization")
    public ResponseEntity<?> getReplicantRating(@RequestParam Long id) {
        return ResponseEntity.ok(humanizationService.getReplicantRating(id));
    }

}
