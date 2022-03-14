package course_work_isbd.blade_runner.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;

import lombok.*;

import java.util.Set;

@Entity(name = "CORPORATION")
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "CORPORATION")
public class Corporation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "NAME", unique = true)
    private String name;

    @Column(name = "description")
    private String description;


    @OneToMany(mappedBy = "corporation", fetch = FetchType.EAGER)
    private Set<ReplicantModel> replicantModel;
}
