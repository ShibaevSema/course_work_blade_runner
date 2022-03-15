package course_work_isbd.blade_runner.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class HumanRequest {
    private String fullName;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Boolean isHuman;
    private Long idLocation;
    private Boolean sex;
}
