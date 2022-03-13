package course_work_isbd.blade_runner.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;

import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity(name = "VOIGHT_KAMPF_TEST")
@Data
@NoArgsConstructor
@Table(name = "VOIGHT_KAMPF_TEST")
public class VoightKampfTest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "entity_id")
    private Human human;

    @Column(name = "eye_movement")
    private boolean eyeMovement;

    @Column(name = "brain_reaction")
    private boolean brainReaction;

    @Column(name = "completionDate")
    private LocalDate localDate;

    @NotNull
    @Column(name = "result")
    private boolean result;

    @OneToMany(mappedBy = "voightKampfTest")
    private Set<VoightKampfTestAnswer> voightKampfTestAnswers;

}
