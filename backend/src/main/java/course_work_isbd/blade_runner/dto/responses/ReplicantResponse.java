package course_work_isbd.blade_runner.dto.responses;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReplicantResponse {
    private Long entityId;
    private String fullName;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Boolean isHuman;
    private String location;
    private Boolean sex;
    private String model;
    private String corporation;
}
