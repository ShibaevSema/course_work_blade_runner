package course_work_isbd.blade_runner.dto.request;

import lombok.Data;

@Data
public class ActionRequest {
    private Long entity_id;
    private String name;
    private String description;
    private Boolean benefit_or_harm;
}
