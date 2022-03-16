package course_work_isbd.blade_runner.services;

import course_work_isbd.blade_runner.dto.request.BladeRunnerRequest;
import course_work_isbd.blade_runner.dto.request.ReplicantSearchRequest;
import course_work_isbd.blade_runner.dto.request.TaskUpdateRequest;
import course_work_isbd.blade_runner.dto.responses.*;
import course_work_isbd.blade_runner.entities.*;
import course_work_isbd.blade_runner.exceptions.ResourceNotFoundException;
import course_work_isbd.blade_runner.repositories.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
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
    private final LocationRepository locationRepository;
    private final ReplicantModelRepository replicantModelRepository;


    public List<ReplicantSearchResponse> getTasks() {
        List<ReplicantSearch> rs = replicantSearchRepository.findAll();
        List<ReplicantSearchResponse> tasks = new ArrayList<>();
        for (ReplicantSearch replicantSearch : rs) {
            ReplicantSearchResponse task = new ReplicantSearchResponse();
            // получаем id
            task.setTask_id(replicantSearch.getId());
            // получаем репликанта
            Human human = replicantSearch.getBladeRunner().getHuman();
            task.setReplicant(convertHumanDtoToReplicant(human));
            // получаем бегущего по лезвию
            task.setBladeRunner(convertBladeRunnerToDTO(replicantSearch.getBladeRunner()));
            // получаем статус задания
            task.setResult(replicantSearch.getResult());

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


    public long deleteTask(Long id) {
        ReplicantSearch replicantSearch = replicantSearchRepository.findById(id).orElse(new ReplicantSearch());
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

    public List<BladeRunnerResponse> getAllBR() {
        List<BladeRunner> bladeRunners = bladeRunnerRepository.findAll();
        List<BladeRunnerResponse> list = new ArrayList<>();
        for (BladeRunner bladeRunner : bladeRunners) {
            BladeRunnerResponse brr = new BladeRunnerResponse();
            EntityResponse entity = convertHumanDto(bladeRunner.getHuman());
            Position position = positionRepository.
                    findById(bladeRunner.getPosition().getId()).orElse(new Position());

            brr.setBr_id(bladeRunner.getId());
            brr.setEntity(entity);
            brr.setPosition(position.getName());
            brr.setPos_description(position.getDescription());
            brr.setHq(convertHQtoDTO(bladeRunner.getBladeRunnersHQ()));
            brr.setStatus(bladeRunner.getFree());

            list.add(brr);
        }

        return list;
    }


    public Long saveBladeRunner(BladeRunnerRequest br) {
        BladeRunner bladeRunner = new BladeRunner();
        Human human = humanRepository.findById(br.getEntity_id()).orElse(new Human());
        bladeRunner.setHuman(human);
        BladeRunnersHQ bladeRunnersHQ = bladeRunnerHQRepository.findById(br.getHq_id()).orElse(new BladeRunnersHQ());
        bladeRunner.setBladeRunnersHQ(bladeRunnersHQ);
        Position position = positionRepository.findById(br.getPosition_id()).orElse(new Position());
        bladeRunner.setPosition(position);
        bladeRunner.setFree(true);
        bladeRunnerRepository.save(bladeRunner);
        return bladeRunner.getId();
    }

    private EntityResponse convertHumanDto(Human h) {
        Long location_id = null;
        String location = null;

        if (h.getHumanLocation() == null)
            location_id = null;
        else
            location_id = h.getHumanLocation().getId().longValue();
        if (location_id != null) {
            Location loc = locationRepository.findById(location_id)
                    .orElseThrow(() -> new ResourceNotFoundException("Error: Location is Not Found"));

            StringBuilder stringBuilder = new StringBuilder();
            location = stringBuilder.append("[").append(loc.getLatitude()).append(",").append(loc.getLongitude()).append("]").toString();
        }
        return new EntityResponse(
                h.getId().longValue(),
                h.getFullName(),
                h.getBirthDate(),
                h.getDeathDate(),
                h.getIsHuman(),
                location,
                h.getSex()
        );
    }

    private HQResponse convertHQtoDTO(BladeRunnersHQ hq) {
        HQResponse hqResponse = new HQResponse();
        StringBuilder stringBuilder = new StringBuilder();
        String location = stringBuilder.append("[").append(hq.getLocation().getLatitude()).
                append(",").append(hq.getLocation().getLongitude()).append("]").toString();
        hqResponse.setLocation(location);
        hqResponse.setDescription(hq.getDescription());
        return hqResponse;
    }


    private ReplicantResponse convertHumanDtoToReplicant(Human h) {
        Long location_id = null;
        String location = null;

        ReplicantResponse replicantResponse = new ReplicantResponse();

        if (h.getHumanLocation() == null)
            location_id = null;
        else
            location_id = h.getHumanLocation().getId().longValue();

        if (location_id != null) {
            Location loc = locationRepository.findById(location_id)
                    .orElseThrow(() -> new ResourceNotFoundException("Error: Location is Not Found"));

            StringBuilder stringBuilder = new StringBuilder();
            location = stringBuilder.append("[").append(loc.getLatitude()).append(",").append(loc.getLongitude()).append("]").toString();
        }

        replicantResponse.setEntityId(h.getId());
        replicantResponse.setFullName(h.getFullName());
        replicantResponse.setBirthDate(h.getBirthDate());
        replicantResponse.setDeathDate(h.getDeathDate());
        replicantResponse.setIsHuman(h.getIsHuman());
        replicantResponse.setLocation(location);
        replicantResponse.setSex(h.getSex());
        Integer model_id;

        if (h.getBirthDate() != null) {
            model_id = replicantModelRepository.define_replicant_model(Date.valueOf(h.getBirthDate()));
        } else
            model_id = null;

        String model_rep = null;
        String company = null;

        if (model_id != null) {
            ReplicantModel replicantModel = replicantModelRepository.findById(Long.valueOf(model_id)).orElse(new ReplicantModel());
            model_rep = replicantModel.getName();
            company = replicantModel.getCorporation().getName();
        }

        replicantResponse.setModel(model_rep);
        replicantResponse.setCorporation(company);

        return replicantResponse;
    }

    private BladeRunnerResponse convertBladeRunnerToDTO(BladeRunner bladeRunner) {
        BladeRunnerResponse brr = new BladeRunnerResponse();
        EntityResponse entity = convertHumanDto(bladeRunner.getHuman());
        Position position = positionRepository.
                findById(bladeRunner.getPosition().getId()).orElse(new Position());
        brr.setBr_id(bladeRunner.getId());
        brr.setEntity(entity);
        brr.setPosition(position.getName());
        brr.setPos_description(position.getDescription());
        brr.setHq(convertHQtoDTO(bladeRunner.getBladeRunnersHQ()));
        brr.setStatus(bladeRunner.getFree());
        return brr;
    }

}
