package course_work_isbd.blade_runner.repositories;

import course_work_isbd.blade_runner.entities.Location;
import course_work_isbd.blade_runner.entities.Profession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfessionRepository extends JpaRepository<Profession, Long> {
    Optional<Profession> findProfessionById(long id);

}
