package course_work_isbd.blade_runner.dto.responses;

import course_work_isbd.blade_runner.entities.Question;
import course_work_isbd.blade_runner.entities.VoightKampfTest;
import lombok.Data;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Data
public class AnswerResponse {
    private QuestionResponse question;
    private VoightKampfTestResponse voightKampfTest;
    private String answer;
}
