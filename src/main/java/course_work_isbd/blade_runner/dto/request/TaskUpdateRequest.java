package course_work_isbd.blade_runner.dto.request;

import lombok.Data;

@Data
public class TaskUpdateRequest {
    private long id;
    private long entity_id;
    private long blade_runner_id;
    private boolean result;
}
