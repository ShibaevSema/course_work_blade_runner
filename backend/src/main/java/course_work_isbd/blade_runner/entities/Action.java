package course_work_isbd.blade_runner.entities;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "ACTION")
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ACTION")
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "benefitorharm")
    private Boolean benefitOrHarm;

    /*
     * Для таблицы Impact_on_society - связь человека/репликанта и его действий
     */

    @OneToMany(mappedBy = "action", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ImpactOnSociety> impactsOnSociety;

}
