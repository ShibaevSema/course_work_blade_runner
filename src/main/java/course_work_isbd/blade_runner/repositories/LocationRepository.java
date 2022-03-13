package course_work_isbd.blade_runner.repositories;


import course_work_isbd.blade_runner.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
