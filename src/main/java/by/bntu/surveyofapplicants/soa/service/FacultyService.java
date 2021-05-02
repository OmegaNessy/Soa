package by.bntu.surveyofapplicants.soa.service;

import by.bntu.surveyofapplicants.soa.dto.FacultyDto;
import by.bntu.surveyofapplicants.soa.entity.Faculty;
import by.bntu.surveyofapplicants.soa.mapper.FacultyMapper;
import by.bntu.surveyofapplicants.soa.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacultyService {
    @Autowired
    FacultyRepository repository;
    @Autowired
    FacultyMapper mapper;

    public FacultyDto getFacultyById(Long id){
        return mapper.toDto(repository.findById(id).orElseThrow(NullPointerException::new));
    }

    public void saveFaculty(FacultyDto dto){
        repository.save(mapper.toEntity(dto));
    }

    public List<FacultyDto> getAllFaculties(){
        List<Faculty> facultyList = repository.findAll();
        List<FacultyDto> facultyDtoList = new ArrayList<>();
        for(Faculty faculty:facultyList){
            facultyDtoList.add(mapper.toDto(faculty));
        }
        return facultyDtoList;
    }
}
