package course_work_isbd.blade_runner.dto.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.SqlResultSetMapping;
import java.time.LocalDate;

@Data
@SqlResultSetMapping(name = "entityResponse", entities = {
        @EntityResult(
                entityClass = EntityResponse.class,
                fields = {
                        @FieldResult(name = "humanId", column = "human_id"),
                        @FieldResult(name = "fullName", column = "full_name"),
                        @FieldResult(name = "birthDate", column = "birth_date"),
                        @FieldResult(name = "deathDate", column = "death_date"),
                        @FieldResult(name = "isHuman", column = "is_human"),
                        @FieldResult(name = "idLocation", column = "id_location"),
                        @FieldResult(name = "sex", column = "sex"),
                }
        )
})
@AllArgsConstructor
@NoArgsConstructor
public class EntityResponse {

    private Long entityId;
    private String fullName;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Boolean isHuman;
    private String location;
    private Boolean sex;

}

