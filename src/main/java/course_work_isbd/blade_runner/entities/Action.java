package course_work_isbd.blade_runner.entities;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity(name = "ACTION")
@Data
@NoArgsConstructor
@Table(name = "ACTION")
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "benefitOrHarm")
    private boolean benefitOrHarm;

    /*
     * Для таблицы Impact_on_society - связь человека/репликанта и его действий
     */

    @OneToMany(mappedBy = "action", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ImpactOnSociety> impactsOnSociety;

}
