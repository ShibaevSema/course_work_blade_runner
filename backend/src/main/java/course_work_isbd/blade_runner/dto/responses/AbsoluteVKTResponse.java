package course_work_isbd.blade_runner.dto.responses;

import course_work_isbd.blade_runner.entities.Question;
import lombok.Data;

import java.util.List;

@Data
public class AbsoluteVKTResponse {
    private List<AnswerResponse> answers;
}
