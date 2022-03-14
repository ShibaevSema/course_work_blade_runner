package course_work_isbd.blade_runner.entities;

import lombok.*;

import javax.persistence.*;

@Entity(name = "WORKERS")
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "WORKERS")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ENTITY_ID")
    private Human human;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROFESSION_ID")
    private Profession profession;

}
