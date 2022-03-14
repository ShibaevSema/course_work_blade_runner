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

    public void setEntity_id(long entity_id) {
        this.entity_id = entity_id;
    }

    public void setReplicant(String replicant) {
        this.replicant = replicant;
    }

    public void setBladeRunner(String bladeRunner) {
        this.bladeRunner = bladeRunner;
    }
}
