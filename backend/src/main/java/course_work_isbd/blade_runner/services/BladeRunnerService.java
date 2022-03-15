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
        for (ReplicantSearch replicantSearch : rs) {
            // получаем имя репликанта
            ReplicantSearchResponse task = new ReplicantSearchResponse();

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
            task.setStatus(replicantSearch.getResult());

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
        replicantSearch.setResult(task.getResult());
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
        replicantSearch.setResult(task.getResult());
        replicantSearchRepository.delete(replicantSearch);

        return replicantSearch.getId();
    }

    public long findChild(Long id) {
        if (replicantRepository.findByEntity_id(id) == null) {
            Human human = humanRepository.findById(id).orElse(new Human());
            human.setIsHuman(null);
            humanRepository.save(human);
            Replicant replicant = new Replicant();
            replicant.setEntity_id(human);
            replicant.setReplicantModel(null);
            replicant.setLifespan(100);
            replicantRepository.save(replicant);
            Long IdNearestHQ;
            //ищем ближайший штаб

            if (human.getHumanLocation() == null)
                IdNearestHQ = bladeRunnerHQRepository.reserveHQ();
            else
                IdNearestHQ = bladeRunnerHQRepository.findNearestHQ(Math.toIntExact(human.getHumanLocation().getId()));


            //ищем бегущего по лезвию
            Long IdBladeRunner = bladeRunnerRepository.findBladeRunner(Math.toIntExact(IdNearestHQ));

            if (IdBladeRunner == null) {
                IdBladeRunner = bladeRunnerRepository.findAnyBladeRunner(Math.toIntExact(IdNearestHQ));
            }

            BladeRunner bladeRunner = bladeRunnerRepository.findById(IdBladeRunner).orElse(new BladeRunner());
            ReplicantSearch replicantSearch = new ReplicantSearch();
            replicantSearch.setBladeRunner(bladeRunner);
            replicantSearch.setReplicant(replicant);
            replicantSearch.setResult(null);

            replicantSearchRepository.save(replicantSearch);

        } else {
            Replicant replicant = replicantRepository.findByEntity_id(id);
            if (replicantSearchRepository.findByReplicant(replicant) == null) {
                Human human = humanRepository.findById(id).orElse(new Human());
                human.setIsHuman(null);
                humanRepository.save(human);

                //ищем ближайший штаб
                Long IdNearestHQ;
                if (human.getHumanLocation() == null)
                    IdNearestHQ = bladeRunnerHQRepository.reserveHQ();
                else
                    IdNearestHQ = bladeRunnerHQRepository.findNearestHQ(Math.toIntExact(human.getHumanLocation().getId()));

                //ищем бегущего по лезвию
                Long IdBladeRunner = bladeRunnerRepository.findBladeRunner(Math.toIntExact(IdNearestHQ));

                if (IdBladeRunner == null) {
                    IdBladeRunner = bladeRunnerRepository.findAnyBladeRunner(Math.toIntExact(IdNearestHQ));
                }

                BladeRunner bladeRunner = bladeRunnerRepository.findById(IdBladeRunner).orElse(new BladeRunner());
                ReplicantSearch replicantSearch = new ReplicantSearch();
                replicantSearch.setBladeRunner(bladeRunner);
                replicantSearch.setReplicant(replicant);
                replicantSearch.setResult(null);
                replicantSearchRepository.save(replicantSearch);
                return replicantSearch.getId();

            }
        }
        return 0;
    }

}
