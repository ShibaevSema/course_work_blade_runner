package course_work_isbd.blade_runner.dto.responses;

import lombok.Data;

import java.time.LocalDate;

@Data
public class VoightKampfTestResponse {

    private long id;
    private long entity_id;
    private boolean eyeMovement;
    private boolean brainReaction;
    private LocalDate localDate;
    private boolean result;

}
