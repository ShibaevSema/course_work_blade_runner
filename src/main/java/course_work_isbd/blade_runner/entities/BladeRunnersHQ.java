package course_work_isbd.blade_runner.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "BLADE_RUNNERS_HQ")
@Data
@Getter
@Setter
@NoArgsConstructor
@Table(name = "BLADE_RUNNERS_HQ")
public class BladeRunnersHQ {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LOCATION_ID")
    private Location location;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "bladeRunnersHQ", fetch = FetchType.EAGER)
    private Set<BladeRunner> bladeRunner;
}
