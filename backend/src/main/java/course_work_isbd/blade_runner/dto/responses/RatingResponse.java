package course_work_isbd.blade_runner.dto.responses;

import lombok.Data;

@Data
public class RatingResponse {
    private String name;
    private Integer rating;   // оценка очеловечивания
    private Integer countPosAct; // количество положительных действий
    private Integer countNegAct; // количество отрицательных действий
    private Integer countGoodTest; // количество пройденных тестов
    private Integer countBadTest; // количество отрицательных тестов
}
