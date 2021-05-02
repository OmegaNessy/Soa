package by.bntu.surveyofapplicants.soa.mapper;

import by.bntu.surveyofapplicants.soa.dto.QuestionDto;
import by.bntu.surveyofapplicants.soa.dto.TestDto;
import by.bntu.surveyofapplicants.soa.entity.Faculty;
import by.bntu.surveyofapplicants.soa.entity.Question;
import by.bntu.surveyofapplicants.soa.entity.Test;
import by.bntu.surveyofapplicants.soa.repository.FacultyRepository;
import by.bntu.surveyofapplicants.soa.repository.QuestionRepository;
import by.bntu.surveyofapplicants.soa.repository.TestRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class QuestionMapper {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    TestRepository testRepository;

    public Question toEntity(QuestionDto dto) {
        return Objects.nonNull(dto) ? new Question(dto.getId(),dto.getQuestionType(),
                dto.getQuestion(),obtainTest(dto.getTestId())): null;
    }

    public QuestionDto toDto(Question entity) {
        return Objects.nonNull(entity) ? new QuestionDto(entity.getId(),entity.getQuestype(),entity.getQuestionText(),entity.getTest().getId()):null;
    }

    private Test obtainTest(Long testId){
        Optional<Test> value = Objects.nonNull(testId) ? testRepository.findById(testId): Optional.empty();
        Test test = new Test();
        if (value.isPresent()){
            test = value.get();
        }
        return test;
    }
//    private Long obtainFaculty(String facultyName) {
//        return Objects.nonNull(facultyName) ?  facultyRepository.findByName(facultyName).getId():null;
//    }
}
