package course_work_isbd.blade_runner.repositories;

import course_work_isbd.blade_runner.entities.Location;
import course_work_isbd.blade_runner.entities.VoightKampfTest;
import course_work_isbd.blade_runner.entities.VoightKampfTestAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VKTestRepository extends JpaRepository<VoightKampfTest, Long> {
    List<VoightKampfTest> findAllByHuman_Id(long id);

    @Query(value = "select select calculate_test_result(:voight_kampf_test_id)", nativeQuery = true)
    boolean calculateVKTresult(@Param(value = "voight_kampf_test_id") long id);
}
