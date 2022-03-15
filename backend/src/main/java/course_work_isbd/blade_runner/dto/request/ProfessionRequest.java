package course_work_isbd.blade_runner.dto.request;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class ProfessionRequest {
    private Long entity_id;
    private Long id;
    private String name;
    private String description;

}
