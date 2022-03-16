package course_work_isbd.blade_runner.dto.responses;

import lombok.Data;

@Data
public class ActionAbsResponse {
    private Long id;
    private String name;
    private String description;
    private Boolean benefit_or_harm;
}
