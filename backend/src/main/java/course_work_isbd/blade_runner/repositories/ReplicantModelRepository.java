package course_work_isbd.blade_runner.repositories;

import course_work_isbd.blade_runner.entities.ReplicantModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;

public interface ReplicantModelRepository extends JpaRepository<ReplicantModel, Long> {
    @Query(value = "select define_replicant_model(:data)", nativeQuery = true)
    Integer define_replicant_model(@Param(value = "data") Date date);
}
