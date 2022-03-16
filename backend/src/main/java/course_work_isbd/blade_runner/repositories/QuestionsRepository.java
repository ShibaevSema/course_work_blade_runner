package course_work_isbd.blade_runner.repositories;

import course_work_isbd.blade_runner.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionsRepository extends JpaRepository<Question,Long> {
}
