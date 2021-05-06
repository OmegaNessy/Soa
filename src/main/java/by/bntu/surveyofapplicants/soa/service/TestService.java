package by.bntu.surveyofapplicants.soa.service;

import by.bntu.surveyofapplicants.soa.dto.MobileDto;
import by.bntu.surveyofapplicants.soa.dto.ResultDto;
import by.bntu.surveyofapplicants.soa.dto.TestDto;
import by.bntu.surveyofapplicants.soa.entity.Answer;
import by.bntu.surveyofapplicants.soa.entity.Student;
import by.bntu.surveyofapplicants.soa.entity.Test;
import by.bntu.surveyofapplicants.soa.entity.TestResult;
import by.bntu.surveyofapplicants.soa.mapper.TestMapper;
import by.bntu.surveyofapplicants.soa.mapper.TestResultMapper;
import by.bntu.surveyofapplicants.soa.repository.AnswerRepository;
import by.bntu.surveyofapplicants.soa.repository.StudentRepository;
import by.bntu.surveyofapplicants.soa.repository.TestRepository;
import by.bntu.surveyofapplicants.soa.repository.TestResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TestService {

    @Autowired
    TestMapper mapper;
    @Autowired
    TestResultMapper resultMapper;

    @Autowired
    StudentService studentService;

    @Autowired
    TestRepository testRepository;
    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TestResultRepository testResultRepository;

    private final String DELIMITER = " ";

    public boolean saveTest(TestDto dto) {
        boolean flag = false;
        if (dto.getFacultyName().isEmpty() || Objects.isNull(dto.getFacultyName())) {
            dto.setFacultyName(null);
        }
        if(dto.getTestType().equals("Общий")) {
            if (Objects.isNull(testRepository.findTestByTestType("Общий"))) {
                testRepository.save(mapper.toEntity(dto));
                flag = true;
            }
        }
        else{
            testRepository.save(mapper.toEntity(dto));
            flag = true;
        }
        return flag;
    }

    public List<TestDto> getAllTests(){
        List<TestDto> testsListDto = new ArrayList<>();
        List<Test> testsList = testRepository.findAll();
        for (Test test:testsList) {
            testsListDto.add(mapper.toDto(test));
        }
        return testsListDto;
    }


    public TestDto getTestById(Long id){
        return mapper.toDto(testRepository.findById(id).orElseThrow(NullPointerException::new));
    }

    public ResultDto saveTestResult(MobileDto dto){
        Student student = null;
        if (dto.getStudent()!=null){
            student = studentService.saveStudent(dto.getStudent());
        }
        dto.setStudent(student);
        String result = Objects.requireNonNull(calculateResult(dto.getAnswersIds())).replace("="," , ").concat(" баллов");
        return resultMapper.toDto(testResultRepository.save(resultMapper.toEntity(dto,result)));
    }

    public List<TestResult> getAllResults(){
        List<TestResult> testResults = testResultRepository.findAll();
        for(TestResult result:testResults){
            result.setScore(result.getScore().split(DELIMITER)[0]);
        }
        return testResults;
    }

    public Map<Long,String> getAllTestsOfResults(List<TestResult> results){
        List<Long> ids = results.stream().map(s -> s.getTestId()).collect(Collectors.toList());
        List<Test> testList = testRepository.findByIdIn(ids);
        return testList.stream().collect(Collectors.toMap(Test::getId, Test::getTestType));
    }

    private String calculateResult(List<Long> answersIdList){
        Map<String,Integer> resultMap = new HashMap<>();
        List<Answer> answerList = answerRepository.findAllByIdIn(answersIdList);
        for(Answer answer:answerList){
//            fullScore += answer.getScore();
            resultMap.merge(answer.getMembership(),answer.getScore(), Integer::sum);
        }
        Optional<Map.Entry<String,Integer>> maxScore = resultMap.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());
        return maxScore.map(Object::toString).orElse(null);
    }

}