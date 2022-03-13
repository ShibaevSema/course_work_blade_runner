package course_work_isbd.blade_runner.repositories;

import course_work_isbd.blade_runner.entities.Location;
import course_work_isbd.blade_runner.entities.VoightKampfTest;
import course_work_isbd.blade_runner.entities.VoightKampfTestAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VKTestRepository extends JpaRepository<VoightKampfTest, Long> {
    List<VoightKampfTest> findAllByHuman_Id(long id);
}
