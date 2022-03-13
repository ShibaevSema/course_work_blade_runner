package course_work_isbd.blade_runner.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;

import lombok.*;

import java.util.Set;

@Entity(name = "LOCATION")
@Data
@NoArgsConstructor
@Table(name = "LOCATION")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "planet")
    private String planet;

    @NotNull
    @Column(name = "latitude")
    private float latitude;

    @NotNull
    @Column(name = "longitude")
    private float longitude;

    @OneToOne(mappedBy = "location")
    private BladeRunnersHQ bladeRunnersHQ;

    @OneToMany(mappedBy = "humanLocation")
    private Set<Human> human;
}
