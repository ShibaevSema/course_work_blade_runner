package course_work_isbd.blade_runner.repositories;

import course_work_isbd.blade_runner.entities.Replicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReplicantRepository extends JpaRepository<Replicant, Long> {
    @Query(value = "select * from REPLICANT r where r.entity_id = :e_id", nativeQuery = true)
    Replicant findByEntity_id(@Param(value = "e_id") long id);
}
