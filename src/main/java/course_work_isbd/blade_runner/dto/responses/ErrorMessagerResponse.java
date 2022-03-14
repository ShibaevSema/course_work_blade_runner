package course_work_isbd.blade_runner.dto.responses;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorMessagerResponse {
        private Integer statusCode;
        private Date timestamp;
        private String message;
        private String description;
}
