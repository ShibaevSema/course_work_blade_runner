package course_work_isbd.blade_runner.dto.responses;

import course_work_isbd.blade_runner.entities.BladeRunner;
import course_work_isbd.blade_runner.entities.Replicant;
import lombok.Data;

@Data
public class ReplicantSearchResponse {
    private Long task_id;
    private BladeRunnerResponse bladeRunner;
    private ReplicantResponse replicant;
    private Boolean result;
}
