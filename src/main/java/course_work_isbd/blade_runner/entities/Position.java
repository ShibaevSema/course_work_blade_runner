package course_work_isbd.blade_runner.entities;

import javax.persistence.*;

import lombok.*;

import java.util.Set;

@Entity(name = "POSITION")
@Data
@NoArgsConstructor
@Table(name = "POSITION")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "position", fetch = FetchType.EAGER)
    private Set<BladeRunner> bladeRunner;
}
