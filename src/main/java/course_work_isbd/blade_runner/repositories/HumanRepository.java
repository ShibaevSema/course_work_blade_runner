package course_work_isbd.blade_runner.repositories;

import course_work_isbd.blade_runner.entities.Human;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HumanRepository extends JpaRepository<Human, Long> {

    List<Human> findAllByHumanIsTrue();

    List<Human> findAllByHumanIsFalse();

    List<Human> findAllByHumanIsNull();



}
