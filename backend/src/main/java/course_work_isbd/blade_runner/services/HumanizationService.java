package course_work_isbd.blade_runner.services;
import course_work_isbd.blade_runner.entities.Action;
import course_work_isbd.blade_runner.entities.ImpactOnSociety;
import course_work_isbd.blade_runner.entities.VoightKampfTest;
import course_work_isbd.blade_runner.repositories.ActionRepository;
import course_work_isbd.blade_runner.repositories.ImpactOnSocietyRepository;
import course_work_isbd.blade_runner.repositories.VKTestRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class HumanizationService {
    private final VKTestRepository vkTestRepository;
    private final ActionRepository actionRepository;
    private final ImpactOnSocietyRepository impactOnSocietyRepository;

    /*
     * Получения критерия очеловечивания
     */

    public int getReplicantRating(Long id) {
        int countPosAct = 0;
        int countNegAct = 0;
        int countGoodTest = 0;

        // достаем действия
        List<ImpactOnSociety> list = impactOnSocietyRepository.findAllByHuman_Id(id);
        List<Action> actions = new ArrayList<>();
        for (ImpactOnSociety impact : list) {
            Action action = actionRepository.findById(impact.getAction().getId()).orElse(new Action());

            if (action.getBenefitOrHarm() != null && action.getBenefitOrHarm())
                countPosAct++;
            if (action.getBenefitOrHarm() != null && !action.getBenefitOrHarm())
                countNegAct++;

            actions.add(action);
        }
        // достаем тесты и считаем для них результаты
        List<VoightKampfTest> tests = vkTestRepository.findAllByHuman_Id(id);
        List<Boolean> results = new ArrayList<>();
        for (VoightKampfTest test : tests) {
            Boolean res = vkTestRepository.calculateVKTresult(Math.toIntExact(test.getId()));

            if (res)
                countGoodTest++;

            results.add(res);
        }

        //критерий очеловечивания: от 0 до 5 соответственно, где 0 - еще нельзя определить
        if (countPosAct > 0 && countNegAct == 0 && countGoodTest >= 1)
            return 5;

        if (countPosAct > 0 && countNegAct == 0 && countGoodTest == 0)
            return 4;

        if (countPosAct > countNegAct && countGoodTest >= 1)
            return 3;

        if (countPosAct >= countNegAct && countGoodTest >= 0)
            return 2;

        if (countPosAct <= countNegAct)
            return 1;

        return 0;
    }

}
