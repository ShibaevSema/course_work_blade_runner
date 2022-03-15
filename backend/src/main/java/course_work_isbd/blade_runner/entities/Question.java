package course_work_isbd.blade_runner.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;

import lombok.*;

import java.util.Set;

@Entity(name = "QUESTIONS")
@Getter
@Setter
@NoArgsConstructor
@Table(name = "QUESTIONS")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "QUESTION_TEXT")
    private String questionText;

    @OneToMany(mappedBy = "question")
    private Set<VoightKampfTestAnswer> voightKampfTestAnswerSet;

}
