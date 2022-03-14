package course_work_isbd.blade_runner.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "DESCENDANTS")
@Data
@Getter
@Setter
@NoArgsConstructor
@Table(name = "DESCENDANTS")
public class Descendant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT1_ID")
    private Human mother;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT2_ID")
    private Human father;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CHILD_ID")
    private Human child;


}
