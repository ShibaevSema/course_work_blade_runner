package course_work_isbd.blade_runner.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity(name = "WORKERS")
@Data
@NoArgsConstructor
@Table(name = "WORKERS")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "ENTITY_ID")
    private Human human;

    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "PROFESSION_ID")
    private Profession profession;

}
