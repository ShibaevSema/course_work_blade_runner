package course_work_isbd.blade_runner.services;

import course_work_isbd.blade_runner.dto.responses.ReplicantSearchResponse;
import course_work_isbd.blade_runner.entities.Human;
import course_work_isbd.blade_runner.entities.ReplicantSearch;
import course_work_isbd.blade_runner.repositories.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class BladeRunnerService {
    private final ReplicantSearchRepository replicantSearchRepository;
    private final BladeRunnerHQRepository bladeRunnerHQRepository;
    private final BladeRunnerRepository bladeRunnerRepository;
    private final ReplicantRepository replicantRepository;
    private final HumanRepository humanRepository;


    public List<ReplicantSearchResponse> getTasks() {
        List<ReplicantSearch> rs = replicantSearchRepository.findAll();
        List<ReplicantSearchResponse> tasks = new ArrayList<>();
        ReplicantSearchResponse task = new ReplicantSearchResponse();
        for (ReplicantSearch replicantSearch : rs) {
            Human human = humanRepository.findById(
                    replicantSearch.getReplicant().getHuman_id().getId()).orElse(new Human());
            task.setEntity_id(human.getId());
            task.setReplicant(human.getFullName());
            human = humanRepository.findById(
                    replicantSearch.getBladeRunner().getHuman().getId()).orElse(new Human());
            task.setBladeRunner(human.getFullName());

        }
    }
}
