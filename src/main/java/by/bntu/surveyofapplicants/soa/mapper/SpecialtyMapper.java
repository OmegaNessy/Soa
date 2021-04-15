package by.bntu.surveyofapplicants.soa.mapper;

import by.bntu.surveyofapplicants.soa.dto.SpecialtyDto;
import by.bntu.surveyofapplicants.soa.entity.Faculty;
import by.bntu.surveyofapplicants.soa.entity.Specialty;
import by.bntu.surveyofapplicants.soa.repository.FacultyRepository;
import by.bntu.surveyofapplicants.soa.repository.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SpecialtyMapper{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    FacultyRepository facultyRepository;

    @Autowired
    SubjectRepository subjectRepository;

    public Specialty toEntity(SpecialtyDto dto) {
        return new Specialty(obtainFaculty(dto.getFacultyName()),
                             dto.getName(),
                             dto.getInformation(),
                             obtainSubject(dto.getThirdSubjectName()),
                             obtainSubject(dto.getFirstSubjectName()),
                             obtainSubject(dto.getSecondSubjectName()),
                             Integer.valueOf(dto.getPassingScore()));
    }

    public SpecialtyDto toDto(Specialty entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, SpecialtyDto.class);
    }

    private Long obtainSubject(String subjectName) {
        return Objects.nonNull(subjectName) ? subjectRepository.findByName(subjectName).getId() : null;
    }

    private Long obtainFaculty(String facultyName) {
        return Objects.nonNull(facultyName) ? facultyRepository.findByName(facultyName).getId(): null;
    }
}
