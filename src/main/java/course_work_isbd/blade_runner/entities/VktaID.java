package course_work_isbd.blade_runner.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class VktaID implements Serializable {

    @Column(name = "q_question_id")
    private Long question_id;

    @Column(name = "vktid_voight_kampf_test_id")
    private Long voight_kampf_test_id;

}
