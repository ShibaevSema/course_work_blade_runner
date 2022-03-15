package course_work_isbd.blade_runner.dto.request;

import lombok.Data;

@Data
public class DescendantRequest {
    private Long motherId;
    private Long fatherId;
    private Long childId;
}
