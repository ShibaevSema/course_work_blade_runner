package course_work_isbd.blade_runner.entities;
import com.sun.istack.NotNull;

import javax.persistence.*;

import lombok.*;

import java.util.Set;

@Entity(name = "PROFESSION")
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "PROFESSION")
public class Profession {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    /*
     * Для таблицы Workers - связь человека/репликанта и его профессии
     */

    @OneToMany(mappedBy = "profession", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Worker> workers;

}
