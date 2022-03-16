package course_work_isbd.blade_runner.controller;


import course_work_isbd.blade_runner.services.VoightKampfTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vkt")
@RequiredArgsConstructor
public class VoightKampfTestController {
    private final VoightKampfTestService vktService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllTest() {
        return ResponseEntity.ok(vktService.getAllTest());
    }


}
