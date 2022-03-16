package course_work_isbd.blade_runner.dto.responses;


import lombok.Data;

@Data
public class BladeRunnerResponse {
    private Long br_id;
    private String name;
    private String position;
    private Boolean status;
}
