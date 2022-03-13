package course_work_isbd.blade_runner.repositories;

import course_work_isbd.blade_runner.entities.BladeRunner;
import course_work_isbd.blade_runner.entities.Descendant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BladeRunnerRepository extends JpaRepository<BladeRunner, Long> {
}
