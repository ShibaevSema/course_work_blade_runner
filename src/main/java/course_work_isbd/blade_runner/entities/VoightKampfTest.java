package course_work_isbd.blade_runner.entities;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "VOIGHT_KAMPF_TEST")
@Data
@Getter
@Setter
@NoArgsConstructor
@Table(name = "VOIGHT_KAMPF_TEST")
public class VoightKampfTest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "entity_id")
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
