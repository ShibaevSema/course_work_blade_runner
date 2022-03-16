package course_work_isbd.blade_runner.dto.responses;


import lombok.Data;

@Data
public class BladeRunnerResponse {
    private Long br_id;
    private EntityResponse entity;
    private String position;
    private String pos_description;
    private HQResponse hq;
    private Boolean status;
}
