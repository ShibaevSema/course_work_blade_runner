package course_work_isbd.blade_runner.repositories;

import course_work_isbd.blade_runner.entities.Descendant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DescendantRepository extends JpaRepository<Descendant, Long> {
    List<Descendant> findAllByChild_Id(long id);

    List<Descendant> findAllByMother_Id(long id);

    List<Descendant> findAllByFather_Id(long id);

}
