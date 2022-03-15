package course_work_isbd.blade_runner.entities;


import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "ENTITY")
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ENTITY")
public class Human {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "full_name")
    private String fullName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "death_date")
    private LocalDate deathDate;

    @Column(name = "is_human")
    private Boolean isHuman;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location humanLocation;

    @NotNull
    @Column(name = "sex")
    private Boolean sex;

    /*
     * Для таблицы Impact_on_society - связь человека/репликанта и его действий
     */

    @OneToMany(mappedBy = "human", fetch = FetchType.LAZY)
    private Set<ImpactOnSociety> impactsOnSociety;

    /*
     * Для таблицы Workers - связь человека/репликанта и его профессии
     */

    @OneToMany(mappedBy = "human", fetch = FetchType.LAZY)
    private Set<Worker> workers;


    /*
     * Для таблицы Descendants
     */

    @OneToMany(mappedBy = "mother", fetch = FetchType.LAZY)
    private Set<Descendant> mothers;

    @OneToMany(mappedBy = "father", fetch = FetchType.LAZY)
    private Set<Descendant> fathers;

    @OneToMany(mappedBy = "child", fetch = FetchType.LAZY)
    private Set<Descendant> children;

    /*
     * Для таблицы BladeRunner
     */

    @OneToMany(mappedBy = "human", fetch = FetchType.EAGER)
    private Set<BladeRunner> bladeRunners;

    /*
     * Для таблицы Replicant
     */

    @OneToOne(mappedBy = "entity_id")
    private Replicant replicant;

    /*
     * Для таблицы Voight_Kampf_test
     */

    @OneToMany(mappedBy = "human", fetch = FetchType.EAGER)
    private Set<VoightKampfTest> voightKampfTests;


}


