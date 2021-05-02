package by.bntu.surveyofapplicants.soa.mapper;

import by.bntu.surveyofapplicants.soa.dto.SpecialtyDto;
import by.bntu.surveyofapplicants.soa.entity.Faculty;
import by.bntu.surveyofapplicants.soa.entity.Specialty;
import by.bntu.surveyofapplicants.soa.entity.Subject;
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
        return Objects.nonNull(dto) ? new Specialty(dto.getId(),obtainFaculty(dto.getFacultyName()),
                             dto.getName(),
                             dto.getInformation(),
                             obtainSubject(dto.getThirdSubjectName()),
                             obtainSubject(dto.getFirstSubjectName()),
                             obtainSubject(dto.getSecondSubjectName()),
                             Integer.valueOf(dto.getPassingScore())): null;
    }

    public SpecialtyDto toDto(Specialty entity) {
        return Objects.nonNull(entity) ? new SpecialtyDto(entity.getId(),entity.getName(),
                convertIdToFaculty(entity.getParentId()).getName(),
                entity.getInformation(),entity.getPassingScore().toString(),
                convertIdToSubject(entity.getFirstSubjectId()).getName(),
                convertIdToSubject(entity.getSecondSubjectId()).getName(),
                convertIdToSubject(entity.getThirdSubjectId()).getName()) : null ;
    }

    private Long obtainSubject(String subjectName) {
        return Objects.nonNull(subjectName) ? subjectRepository.findByName(subjectName).getId() :null;
    }

    private Long obtainFaculty(String facultyName) {
        return Objects.nonNull(facultyName) ?  facultyRepository.findByName(facultyName).getId():null;

    }

    private Faculty convertIdToFaculty(Long id){
        return facultyRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    private Subject convertIdToSubject(Long id){
        return subjectRepository.findById(id).orElseThrow(NullPointerException::new);
    }
}
