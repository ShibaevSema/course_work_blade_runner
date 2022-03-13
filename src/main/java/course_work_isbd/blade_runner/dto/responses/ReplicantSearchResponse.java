package course_work_isbd.blade_runner.dto.responses;

import lombok.Data;

@Data
public class ReplicantSearchResponse {
    private long entity_id;
    private String replicant;
    private String bladeRunner;
    private String position;
    private String bladeRunnerHQ;
    private boolean status;
}
