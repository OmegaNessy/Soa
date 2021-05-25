package by.bntu.surveyofapplicants.soa.service;

import by.bntu.surveyofapplicants.soa.dto.FacultyDto;

import java.util.List;

public interface FacultyService {
    void deleteFaculty(Long id);
    List<FacultyDto> facultiesSearch(String value);
    List<FacultyDto> getAllFaculties();
    FacultyDto getFacultyById(Long id);
    boolean saveFaculty(FacultyDto dto);

}
