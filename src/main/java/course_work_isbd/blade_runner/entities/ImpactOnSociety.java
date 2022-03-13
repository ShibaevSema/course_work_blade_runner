package course_work_isbd.blade_runner.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "IMPACT_ON_SOCIETY")
@Data
@NoArgsConstructor
@Table(name = "IMPACT_ON_SOCIETY")
public class ImpactOnSociety {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "ACTION_ID")
    private Action action;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "ENTITY_ID")
    private Human human;



}


