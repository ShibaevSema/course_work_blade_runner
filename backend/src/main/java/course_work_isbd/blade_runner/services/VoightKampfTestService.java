package course_work_isbd.blade_runner.services;

import course_work_isbd.blade_runner.dto.responses.AbsoluteVKTResponse;
import course_work_isbd.blade_runner.dto.responses.AnswerResponse;
import course_work_isbd.blade_runner.dto.responses.QuestionResponse;
import course_work_isbd.blade_runner.dto.responses.VoightKampfTestResponse;
import course_work_isbd.blade_runner.entities.Question;
import course_work_isbd.blade_runner.entities.VoightKampfTest;
import course_work_isbd.blade_runner.entities.VoightKampfTestAnswer;
import course_work_isbd.blade_runner.repositories.VKAnswersTestRepository;
import course_work_isbd.blade_runner.repositories.VKTestRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class VoightKampfTestService {
    private final VKTestRepository vkTestRepository;
    private final VKAnswersTestRepository vkAnswersTestRepository;


    public List<AbsoluteVKTResponse> getAllTest() {
        List<VoightKampfTest> lists = vkTestRepository.findAll();
        List<AbsoluteVKTResponse> vktLists = new ArrayList<>();
        for (VoightKampfTest test : lists) {
            List<VoightKampfTestAnswer> answers = vkAnswersTestRepository.findByVoightKampfTest(test);
            vktLists.add(convertAnswersToDTO(answers));
        }
        return vktLists;
    }


    private AbsoluteVKTResponse convertAnswersToDTO(List<VoightKampfTestAnswer> answers) {
        AbsoluteVKTResponse absoluteVKTResponse = new AbsoluteVKTResponse();
        List<AnswerResponse> list = new ArrayList<>();
        for (VoightKampfTestAnswer answer : answers) {
            AnswerResponse answerResponse = new AnswerResponse();
            QuestionResponse questionResponse = new QuestionResponse();
            VoightKampfTestResponse voightKampfTestResponse = new VoightKampfTestResponse();

            questionResponse.setId(answer.getQuestion().getId());
            questionResponse.setQuestionText(answer.getQuestion().getQuestionText());

            voightKampfTestResponse.setId(answer.getVoightKampfTest().getId());
            voightKampfTestResponse.setEntity_id(answer.getVoightKampfTest().getHuman().getId());
            voightKampfTestResponse.setEyeMovement(answer.getVoightKampfTest().getEyeMovement());
            voightKampfTestResponse.setBrainReaction(answer.getVoightKampfTest().getBrainReaction());
            voightKampfTestResponse.setLocalDate(answer.getVoightKampfTest().getLocalDate());
            voightKampfTestResponse.setResult(answer.getVoightKampfTest().getResult());

            answerResponse.setAnswer(answer.getAnswer());
            answerResponse.setQuestion(questionResponse);
            answerResponse.setVoightKampfTest(voightKampfTestResponse);

            list.add(answerResponse);
        }
        absoluteVKTResponse.setAnswers(list);
        return absoluteVKTResponse;
    }
}



