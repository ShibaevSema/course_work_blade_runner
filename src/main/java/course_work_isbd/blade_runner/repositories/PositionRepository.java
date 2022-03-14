package course_work_isbd.blade_runner.repositories;

import course_work_isbd.blade_runner.entities.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
}
