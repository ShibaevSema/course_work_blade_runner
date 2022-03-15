package course_work_isbd.blade_runner.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "VOIGHT_KAMPF_TEST")
@Getter
@Setter
@NoArgsConstructor
@Table(name = "VOIGHT_KAMPF_TEST")
public class VoightKampfTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "entity_id")
    private Human human;

    @Column(name = "eye_movement")
    private Boolean eyeMovement;

    @Column(name = "brain_reaction")
    private Boolean brainReaction;

    @Column(name = "completionDate")
    private LocalDate localDate;

    @Column(name = "result")
    private Boolean result;

    @OneToMany(mappedBy = "voightKampfTest")
    private Set<VoightKampfTestAnswer> voightKampfTestAnswers;

}
