package course_work_isbd.blade_runner.dto.request;
import lombok.Data;

@Data
public class ProfessionRequest {
    private Long entity_id;
    private Long id;
    private String name;
    private String description;

}
