package course_work_isbd.blade_runner.dto.responses.relatives;

import course_work_isbd.blade_runner.dto.responses.EntityResponse;
import lombok.Data;

@Data
public class DescendantResponse {
    private EntityResponse entity;
    private Family family;
}
