package course_work_isbd.blade_runner.repositories;

import course_work_isbd.blade_runner.entities.ImpactOnSociety;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImpactOnSocietyRepository extends JpaRepository<ImpactOnSociety, Long> {

    List<ImpactOnSociety> findAllByHuman_Id(Long id);
}
