package course_work_isbd.blade_runner.services;

import course_work_isbd.blade_runner.dto.request.*;
import course_work_isbd.blade_runner.dto.responses.EntityResponse;
import course_work_isbd.blade_runner.dto.responses.ProfessionResponse;
import course_work_isbd.blade_runner.dto.responses.VoightKampfTestResponse;
import course_work_isbd.blade_runner.dto.responses.relatives.DescendantResponse;
import course_work_isbd.blade_runner.dto.responses.relatives.Family;
import course_work_isbd.blade_runner.entities.*;
import course_work_isbd.blade_runner.exceptions.ResourceNotFoundException;
import course_work_isbd.blade_runner.repositories.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class EntityService {
    private final HumanRepository humanRepository;
    private final DescendantRepository descendantRepository;
    private final LocationRepository locationRepository;
    private final WorkerRepository workerRepository;
    private final ProfessionRepository professionRepository;
    private final VKTestRepository vkTestRepository;
    private final BladeRunnerService bladeRunnerService;

    public long createEntity(HumanRequest entity) {
        Human human = new Human();
        human.setFullName(entity.getFullName());
        human.setBirthDate(entity.getBirthDate());
        human.setDeathDate(entity.getDeathDate());
        human.setIsHuman(entity.getIsHuman());
        human.setHumanLocation(locationRepository.findById(entity.getIdLocation())
                .orElseThrow(() -> new ResourceNotFoundException("Error: Location is Not Found"))); // тут подправить
        human.setSex(entity.getSex());

        humanRepository.save(human);

        return human.getId();
    }

    public long createChild(DescendantRequest child) {
        Descendant descendant = new Descendant();
        Human mother = humanRepository.findById(child.getMotherId())
                .orElseThrow(() -> new ResourceNotFoundException("Error: Location is Not Found"));
        Human father = humanRepository.findById(child.getFatherId())
                .orElseThrow(() -> new ResourceNotFoundException("Error: Location is Not Found"));

        descendant.setMother(mother);

        descendant.setFather(father);

        descendant.setChild(humanRepository.findById(child.getChildId())
                .orElseThrow(() -> new ResourceNotFoundException("Error: Location is Not Found")));
        descendantRepository.save(descendant);

        if (mother.getIsHuman() || father.getIsHuman() || mother.getIsHuman() == null || father.getIsHuman() == null) {
            bladeRunnerService.findChild(child.getChildId());
        }

        return descendant.getId();
    }

    public List<EntityResponse> getAllEntities() {
        List<Human> entities = humanRepository.findAll();
        return convertHumanDto(entities);
    }

    public List<EntityResponse> getPeople() {
        List<Human> people = humanRepository.findAllByIsHumanIsTrue();
        return convertHumanDto(people);
    }

    public List<EntityResponse> getReplicants() {
        List<Human> replicants = humanRepository.findAllByIsHumanIsFalse();
        return convertHumanDto(replicants);
    }

    public List<EntityResponse> getUnknownEntities() {
        List<Human> unknownEntities = humanRepository.findAllByIsHumanIsNull();
        return convertHumanDto(unknownEntities);
    }

    public ProfessionResponse getEntityProfession(long id) {
        Worker worker = workerRepository.findWorkerByHuman_Id(id).orElse(new Worker());
        Profession profession = professionRepository.findProfessionById(worker.getId()).orElse(new Profession());
        ProfessionResponse professionResponse = new ProfessionResponse();
        professionResponse.setId(profession.getId());
        professionResponse.setName(profession.getName());
        professionResponse.setDescription(profession.getDescription());
        return professionResponse;
    }

    public List<DescendantResponse> getEntityRelatives(long id) {
        Human human = humanRepository.findById(id).orElse(new Human());
        List<DescendantResponse> relatives = new ArrayList<>();
        DescendantResponse descendantResponse;

        if (human.getSex()) {
            //ищем всех жен и детей
            List<Descendant> fathers = descendantRepository.findAllByFather_Id(id);
            for (Descendant descendant : fathers) {
                descendantResponse = findRelativeById(descendant.getMother().getId(), Family.WIFE);
                relatives.add(descendantResponse);

                descendantResponse = findRelativeById(descendant.getChild().getId(), Family.CHILD);
                relatives.add(descendantResponse);
            }
        } else {
            //ищем всех мужей и детей
            List<Descendant> fathers = descendantRepository.findAllByMother_Id(id);
            for (Descendant descendant : fathers) {
                descendantResponse = findRelativeById(descendant.getFather().getId(), Family.HUSBAND);
                relatives.add(descendantResponse);

                descendantResponse = findRelativeById(descendant.getChild().getId(), Family.CHILD);
                relatives.add(descendantResponse);
            }
        }

        //ищем родителей
        List<Descendant> parents = descendantRepository.findAllByChild_Id(id);
        for (Descendant descendant : parents) {
            descendantResponse = findRelativeById(descendant.getMother().getId(), Family.MOTHER);
            relatives.add(descendantResponse);

            descendantResponse = findRelativeById(descendant.getFather().getId(), Family.FATHER);
            relatives.add(descendantResponse);
        }
        return relatives;
    }

    public List<VoightKampfTestResponse> findEntityVKTest(long id) {
        List<VoightKampfTest> list = vkTestRepository.findAllByHuman_Id(id);
        List<VoightKampfTestResponse> vktResponse = new ArrayList<>();
        VoightKampfTestResponse voightKampfTestResponse = new VoightKampfTestResponse();
        for (VoightKampfTest vkt : list) {
            voightKampfTestResponse.setId(vkt.getId());
            voightKampfTestResponse.setEntity_id(id);
            voightKampfTestResponse.setEyeMovement(vkt.getEyeMovement());
            voightKampfTestResponse.setBrainReaction(vkt.getBrainReaction());
            voightKampfTestResponse.setLocalDate(vkt.getLocalDate());
            //считаем результат теста
            voightKampfTestResponse.setResult(vkTestRepository.calculateVKTresult(Math.toIntExact(vkt.getId())));
            vktResponse.add(voightKampfTestResponse);
        }
        return vktResponse;
    }


    private DescendantResponse findRelativeById(long id, Family type) {
        DescendantResponse descendantResponse = new DescendantResponse();
        Human entity = humanRepository.findById(id).orElse(new Human());
        EntityResponse entityResponse = convertHumanDto(Collections.singletonList(entity)).get(0);

        descendantResponse.setEntity(entityResponse);
        descendantResponse.setFamily(type);
        return descendantResponse;
    }

    private List<EntityResponse> convertHumanDto(List<Human> list) {
        List<EntityResponse> entityResponsesList = new ArrayList<>();
        Long location_id;
        for (Human h : list) {
            if (h.getHumanLocation() == null)
                location_id = null;
            else
                location_id = h.getHumanLocation().getId().longValue();
            entityResponsesList.add(new EntityResponse(
                    h.getId().longValue(),
                    h.getFullName(),
                    h.getBirthDate(),
                    h.getDeathDate(),
                    h.getIsHuman(),
                    location_id,
                    h.getSex()
            ));
        }
        return entityResponsesList;
    }

    public Long addProfession(ProfessionRequest profession) {
        Profession prof = professionRepository.findProfessionById(profession.getId())
                .orElse(new Profession());
        Human human = humanRepository.findById(profession.getEntity_id()).orElse(new Human());
        Worker worker = workerRepository.findWorkerByHuman_Id(human.getId()).orElse(new Worker());
        worker.setProfession(prof);
        worker.setHuman(human);
        workerRepository.save(worker);
        return worker.getId();
    }

}
