package course_work_isbd.blade_runner.dto.responses;

import lombok.Data;

import java.time.LocalDate;

@Data
public class VoightKampfTestResponse {

    private Long id;
    private Long entity_id;
    private Boolean eyeMovement;
    private Boolean brainReaction;
    private LocalDate localDate;
    private Boolean result;

}
