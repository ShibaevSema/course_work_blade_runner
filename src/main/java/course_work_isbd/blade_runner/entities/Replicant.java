package course_work_isbd.blade_runner.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "REPLICANT")
@Data
@NoArgsConstructor
@Table(name = "REPLICANT")
public class Replicant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ENTITY_ID")
    private Human human_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "REPLICANT_MODEL_ID")
    private ReplicantModel replicantModel;

    @Check(constraints = "lifespan > 0")
    @Column(name = "LIFESPAN")
    private Integer lifespan;


    /*
     * табличка ReplicantSearch
     */
    @OneToMany(mappedBy = "replicant")
    private Set<ReplicantSearch> replicantSearches;
}
