package course_work_isbd.blade_runner.entities;

import lombok.*;

import javax.persistence.*;

@Entity(name = "IMPACT_ON_SOCIETY")
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "IMPACT_ON_SOCIETY")
public class ImpactOnSociety {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ACTION_ID")
    private Action action;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ENTITY_ID")
    private Human human;


}


