package course_work_isbd.blade_runner.repositories;

import course_work_isbd.blade_runner.entities.BladeRunner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BladeRunnerRepository extends JpaRepository<BladeRunner, Long> {

    BladeRunner findByHuman_Id(long id);


}
