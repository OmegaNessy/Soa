package by.bntu.surveyofapplicants.soa.service;

import by.bntu.surveyofapplicants.soa.dto.MobileDto;
import by.bntu.surveyofapplicants.soa.dto.ResultDto;
import by.bntu.surveyofapplicants.soa.dto.TestApiDto;
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

    public boolean saveTest(TestDto dto) {
        boolean flag = false;
        if (dto.getFacultyName().isEmpty() || Objects.isNull(dto.getFacultyName())) {
            dto.setFacultyName(null);
        }
        if("Общий".equals(dto.getTestType())) {
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

    public TestApiDto getGeneralTest(String value){
        return mapper.toApiDto(testRepository.findTestByTestType(value));
    }
    public List<TestDto> getAllTests(){
        List<TestDto> testsListDto = new ArrayList<>();
        List<Test> testsList = testRepository.findAll();
        for (Test test:testsList) {
            testsListDto.add(mapper.toDto(test));
        }
        return testsListDto;
    }

    public List<TestApiDto> getAllApiTests(){
        List<TestApiDto> testsListDto = new ArrayList<>();
        List<Test> testsList = testRepository.findAll();
        for (Test test:testsList) {
            testsListDto.add(mapper.toApiDto(test));
        }
        return testsListDto;
    }

    public TestDto getTestById(Long id){
        return mapper.toDto(testRepository.findById(id).orElseThrow(NullPointerException::new));
    }

    public TestApiDto getTestApiById(Long id){
        return mapper.toApiDto(testRepository.findById(id).orElseThrow(NullPointerException::new));
    }

    public ResultDto saveTestResult(MobileDto dto){
        Student student = null;
        if (dto.getStudent()!=null){
            student = studentService.saveStudent(dto.getStudent());
        }
        dto.setStudent(student);
        String result = Objects.requireNonNull(calculateResult(dto.getAnswersIds())).replace("="," , ").concat(" баллов");
        TestResult testResult = testResultRepository.save(resultMapper.toEntity(dto,result));
        testResult.setScore(result.split(" ")[0]);
        return resultMapper.toDto(testResult);
    }

    public List<TestResult> getAllResults(){
        return testResultRepository.findAll();

    }

    public Map<Long,String> getAllTestsOfResults(List<TestResult> results){
        List<Long> ids = results.stream().map(TestResult::getTestId).collect(Collectors.toList());
        List<Test> testList = testRepository.findByIdIn(ids);
        return testList.stream().collect(Collectors.toMap(Test::getId, Test::getTestType));
    }

    public void deleteTest(Long id){
        testRepository.deleteById(id);
    }
    private String calculateResult(List<Long> answersIdList){
        Map<String,Integer> resultMap = new HashMap<>();
        int fullScore = 0;
        List<Answer> answerList = answerRepository.findAllByIdIn(answersIdList);
        for(Answer answer:answerList){
            fullScore += answer.getScore();
            resultMap.merge(answer.getMembership(),answer.getScore(), Integer::sum);
        }
        Optional<Map.Entry<String,Integer>> maxScore = resultMap.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());
        return maxScore.map(Object::toString).orElse(null)+" из " + fullScore;
    }
}