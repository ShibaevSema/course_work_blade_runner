package course_work_isbd.blade_runner.dto.responses;

import lombok.Data;

@Data
public class ReplicantSearchResponse {
    private Long task_id;
    private Long entity_id;
    private Long blade_runner_id;
    private String replicant;
    private String bladeRunner;
    private String position;
    private String bladeRunnerHQ;
    private Boolean status;


}
