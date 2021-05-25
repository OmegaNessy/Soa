package by.bntu.surveyofapplicants.soa.service.impl;

import by.bntu.surveyofapplicants.soa.dto.FacultyDto;
import by.bntu.surveyofapplicants.soa.entity.Faculty;
import by.bntu.surveyofapplicants.soa.mapper.FacultyMapper;
import by.bntu.surveyofapplicants.soa.repository.FacultyRepository;
import by.bntu.surveyofapplicants.soa.service.FacultyService;
import by.bntu.surveyofapplicants.soa.util.IdentityChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {
    @Autowired
    FacultyRepository repository;
    @Autowired
    FacultyMapper mapper;
    @Autowired
    IdentityChecker identityChecker;

    public FacultyDto getFacultyById(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(NullPointerException::new));
    }

    public boolean saveFaculty(FacultyDto dto) {
        Faculty facultyFromPage = mapper.toEntity(dto);
        Faculty facultyFromDB = repository.findByName(facultyFromPage.getName());
        if(identityChecker.check(facultyFromDB,facultyFromPage)){
            repository.save(facultyFromPage);
            return true;
        }
        return false;
    }


    public List<FacultyDto> getAllFaculties() {
        List<Faculty> facultyList = repository.findAll();
        List<FacultyDto> facultyDtoList = new ArrayList<>();
        for (Faculty faculty : facultyList) {
            facultyDtoList.add(mapper.toDto(faculty));
        }
        return facultyDtoList;
    }

    public List<FacultyDto> facultiesSearch(String value) {
        List<Faculty> facultyList = repository.findAllByNameStartingWith(value);
        List<FacultyDto> facultyDtoList = new ArrayList<>();
        for (Faculty faculty : facultyList) {
            facultyDtoList.add(mapper.toDto(faculty));
        }
        return facultyDtoList;
    }

    public void deleteFaculty(Long id) {
        repository.deleteById(id);
    }
}
