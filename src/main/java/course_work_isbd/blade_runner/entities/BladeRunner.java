package course_work_isbd.blade_runner.entities;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "BLADE_RUNNER")
@Data
@Getter
@Setter
@NoArgsConstructor
@Table(name = "BLADE_RUNNER")
public class BladeRunner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ENTITY_ID")
    private Human human;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "HQ_ID")
    private BladeRunnersHQ bladeRunnersHQ;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "POSITION_ID")
    private Position position;

    @NotNull
    @Column(name = "FREE")
    private boolean free;

    /*
     * табличка ReplicantSearch
     */
    @OneToMany(mappedBy = "bladeRunner")
    private Set<ReplicantSearch> replicantSearches;


}
