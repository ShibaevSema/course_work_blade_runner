package course_work_isbd.blade_runner.dto.responses;

import lombok.Data;

@Data
public class ActionResponse {
    private String name;
    private String description;
    private Boolean benefit_or_harm;
}
