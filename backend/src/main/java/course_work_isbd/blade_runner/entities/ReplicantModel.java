package course_work_isbd.blade_runner.entities;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "REPLICANT_MODEL")
@Getter
@Setter
@NoArgsConstructor
@Table(name = "REPLICANT_MODEL")
public class ReplicantModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "NAME", unique = true)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CORPORATION_ID")
    private Corporation corporation;

    @OneToMany(mappedBy = "replicantModel", fetch = FetchType.LAZY)
    private Set<Replicant> replicants;
}
