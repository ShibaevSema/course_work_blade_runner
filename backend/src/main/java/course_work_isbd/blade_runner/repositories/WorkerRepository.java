package course_work_isbd.blade_runner.repositories;

import course_work_isbd.blade_runner.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
    Optional<Worker> findWorkerByHuman_Id(Long id);
}
