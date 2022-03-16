package course_work_isbd.blade_runner.dto.responses;

import lombok.Data;

@Data
public class RatingResponse {
    private String name;
    private Integer rating;   // оценка очеловечивания
    private Integer countPosAct = 0; // количество положительных действий
    private Integer countNegAct = 0; // количество отрицательных действий
    private Integer countGoodTest = 0; // количество пройденных тестов
    private Integer countBadTest = 0; // количество отрицательных тестов
}
