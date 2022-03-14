package course_work_isbd.blade_runner.services;

import course_work_isbd.blade_runner.dto.request.ReplicantSearchRequest;
import course_work_isbd.blade_runner.dto.request.TaskUpdateRequest;
import course_work_isbd.blade_runner.dto.responses.ReplicantSearchResponse;
import course_work_isbd.blade_runner.entities.*;
import course_work_isbd.blade_runner.repositories.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class BladeRunnerService {
    private final ReplicantSearchRepository replicantSearchRepository;
    private final BladeRunnerHQRepository bladeRunnerHQRepository;
    private final BladeRunnerRepository bladeRunnerRepository;
    private final HumanRepository humanRepository;
    private final ReplicantRepository replicantRepository;
    private final PositionRepository positionRepository;

    public List<ReplicantSearchResponse> getTasks() {
        List<ReplicantSearch> rs = replicantSearchRepository.findAll();
        List<ReplicantSearchResponse> tasks = new ArrayList<>();
        ReplicantSearchResponse task = new ReplicantSearchResponse();
        for (ReplicantSearch replicantSearch : rs) {
            // получаем имя репликанта
            Human human = humanRepository.findById(
                    replicantSearch.getReplicant().getEntity_id().getId()).orElse(new Human());
            task.setEntity_id(human.getId());
            task.setReplicant(human.getFullName());
            // получаем имя бегущего по лезвию
            human = humanRepository.findById(
                    replicantSearch.getBladeRunner().getHuman().getId()).orElse(new Human());
            task.setBladeRunner(human.getFullName());
            // получаем позицию бегущего по лезвию
            BladeRunner bladeRunner = bladeRunnerRepository.
                    findById(replicantSearch.getBladeRunner().getId()).orElse(new BladeRunner());
            Position position = positionRepository.
                    findById(bladeRunner.getPosition().getId()).orElse(new Position());
            task.setPosition(position.getName());
            // получаем штаб бегущего по лезвию
            BladeRunnersHQ bladeRunnersHQ = bladeRunnerHQRepository.
                    findById(bladeRunner.getBladeRunnersHQ().getId()).orElse(new BladeRunnersHQ());
            task.setBladeRunnerHQ(bladeRunnersHQ.getDescription());
            // получаем статус задания
            task.setStatus(replicantSearch.isResult());

            tasks.add(task);
        }
        return tasks;
    }

    public long createTask(ReplicantSearchRequest task) {
        ReplicantSearch replicantSearch = new ReplicantSearch();
        Replicant replicant = replicantRepository.findByEntity_id(task.getEntity_id());
        BladeRunner bladeRunner = bladeRunnerRepository.findById(task.getBlade_runner_id()).orElse(new BladeRunner());
        replicantSearch.setReplicant(replicant);
        replicantSearch.setBladeRunner(bladeRunner);

        replicantSearchRepository.save(replicantSearch);

        return replicantSearch.getId();
    }

    public long updateTask(TaskUpdateRequest task) {
        ReplicantSearch replicantSearch = new ReplicantSearch();
        Replicant replicant = replicantRepository.findByEntity_id(task.getEntity_id());
        BladeRunner bladeRunner = bladeRunnerRepository.findById(task.getBlade_runner_id()).orElse(new BladeRunner());
        replicantSearch.setId(task.getId());
        replicantSearch.setReplicant(replicant);
        replicantSearch.setBladeRunner(bladeRunner);
        replicantSearch.setResult(task.isResult());
        replicantSearchRepository.save(replicantSearch);
        return replicantSearch.getId();
    }


    public long deleteTask(TaskUpdateRequest task) {
        ReplicantSearch replicantSearch = new ReplicantSearch();
        Replicant replicant = replicantRepository.findByEntity_id(task.getEntity_id());
        BladeRunner bladeRunner = bladeRunnerRepository.findById(task.getBlade_runner_id()).orElse(new BladeRunner());
        replicantSearch.setId(task.getId());
        replicantSearch.setReplicant(replicant);
        replicantSearch.setBladeRunner(bladeRunner);
        replicantSearch.setResult(task.isResult());
        replicantSearchRepository.delete(replicantSearch);

        return replicantSearch.getId();
    }


}
