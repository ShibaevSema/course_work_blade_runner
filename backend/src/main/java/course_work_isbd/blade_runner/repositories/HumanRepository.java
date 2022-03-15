package course_work_isbd.blade_runner.repositories;

import course_work_isbd.blade_runner.entities.Human;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HumanRepository extends JpaRepository<Human, Long> {
    @Query(value = "select e from ENTITY e where e.isHuman = true")
    List<Human> findAllByIsHumanIsTrue();

    @Query(value = "select e from ENTITY e where e.isHuman = false")
    List<Human> findAllByIsHumanIsFalse();

    @Query(value = "select e from ENTITY e where e.isHuman is NULL ")
    List<Human> findAllByIsHumanIsNull();


}
