package by.bntu.surveyofapplicants.soa.mapper;

import by.bntu.surveyofapplicants.soa.dto.TestApiDto;
import by.bntu.surveyofapplicants.soa.dto.TestDto;
import by.bntu.surveyofapplicants.soa.entity.Faculty;
import by.bntu.surveyofapplicants.soa.entity.Test;
import by.bntu.surveyofapplicants.soa.repository.FacultyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class TestMapper {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    FacultyRepository facultyRepository;

    public Test toEntity(TestDto dto) {
        return new Test(dto.getId(), dto.getTestType(),
                obtainFaculty(dto.getFacultyName()));
    }

    public TestDto toDto(Test entity) {
        return Objects.nonNull(entity) ? new TestDto(entity.getId(),entity.getTestType(),obtainFacultyName(entity.getFacultyId())):null;
    }

    public TestApiDto toApiDto(Test entity){
        return Objects.nonNull(entity) ? modelMapper.map(entity,TestApiDto.class):null;
    }

    public Test toApiEntity(TestApiDto dto){
        return Objects.nonNull(dto) ? modelMapper.map(dto,Test.class):null;
    }

    private String obtainFacultyName(Long facultyId){
        Optional<Faculty> value = Objects.nonNull(facultyId) ? facultyRepository.findById(facultyId): Optional.empty();
        String facultyName = null;
        if (value.isPresent()){
            facultyName = value.get().getName();
        }
        return facultyName;

    }
    private Long obtainFaculty(String facultyName) {
        return Objects.nonNull(facultyName) ?  facultyRepository.findByName(facultyName).getId():null;
    }
}
