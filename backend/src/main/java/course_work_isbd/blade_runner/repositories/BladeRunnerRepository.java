package course_work_isbd.blade_runner.repositories;

import course_work_isbd.blade_runner.entities.BladeRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BladeRunnerRepository extends JpaRepository<BladeRunner, Long> {

    BladeRunner findByHuman_Id(long id);

    @Query(value = "select find_blade_runner(:id)", nativeQuery = true)
    Long findBladeRunner(@Param(value = "id") Long id);

}
