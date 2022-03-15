package course_work_isbd.blade_runner.entities;

import lombok.*;

import javax.persistence.*;

@Entity(name = "REPLICANT_SEARCH")
@Getter
@Setter
@NoArgsConstructor
@Table(name = "REPLICANT_SEARCH")
public class ReplicantSearch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BLADE_RUNNER_ID")
    private BladeRunner bladeRunner;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "REPLICANT_ID")
    private Replicant replicant;

    @Column(name = "RESULT")
    private Boolean result;


}
