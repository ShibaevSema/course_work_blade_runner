package course_work_isbd.blade_runner.entities;


import com.sun.istack.NotNull;

import javax.persistence.*;

import lombok.*;

@Entity(name = "VOIGHT_KAMPF_TEST_ANSWERS")
@Data
@NoArgsConstructor
@Table(name = "VOIGHT_KAMPF_TEST_ANSWERS")
public class VoightKampfTestAnswer {

    @EmbeddedId
    private VktaID vktAid;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("question_id")
    private Question question;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("voight_kampf_test_id")
    private VoightKampfTest voightKampfTest;

    @Column(name = "answer")
    private String answer;

    @NotNull
    @Column(name = "result")
    private boolean result;

}
