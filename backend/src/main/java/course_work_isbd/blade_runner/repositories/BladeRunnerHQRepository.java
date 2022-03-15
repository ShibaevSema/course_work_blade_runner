package course_work_isbd.blade_runner.repositories;

import course_work_isbd.blade_runner.entities.BladeRunnersHQ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BladeRunnerHQRepository extends JpaRepository<BladeRunnersHQ, Long> {
    @Query(value = "select nearest_hq(:id)", nativeQuery = true)
    Long findNearestHQ(@Param(value = "id") int id);

    @Query(value = "select id from blade_runners_hq limit 1", nativeQuery = true)
    Long reserveHQ();
}
