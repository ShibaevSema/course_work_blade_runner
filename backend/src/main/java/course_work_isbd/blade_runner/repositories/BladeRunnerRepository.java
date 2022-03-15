package course_work_isbd.blade_runner.repositories;

import course_work_isbd.blade_runner.entities.BladeRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BladeRunnerRepository extends JpaRepository<BladeRunner, Long> {

    BladeRunner findByHuman_Id(long id);

    @Query(value = "select find_blade_runner(:id)", nativeQuery = true)
    Long findBladeRunner(@Param(value = "id") int id);

    @Query(value = "select * from BLADE_RUNNER where HQ_ID =:id limit 1", nativeQuery = true)
    Long findAnyBladeRunner(@Param(value = "id") int id);
}
