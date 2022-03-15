package course_work_isbd.blade_runner.dto.request;

import lombok.Data;

@Data
public class TaskUpdateRequest {
    private Long id;
    private Long entity_id;
    private Long blade_runner_id;
    private Boolean result;

}
