package course_work_isbd.blade_runner.dto.responses;

import course_work_isbd.blade_runner.entities.BladeRunner;
import course_work_isbd.blade_runner.entities.Location;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
public class HQResponse {
    private String location;
    private String description;
}
