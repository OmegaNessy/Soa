package by.bntu.surveyofapplicants.soa.service;

import by.bntu.surveyofapplicants.soa.dto.SpecialtyDto;

import java.util.List;

public interface SpecialtyService {
    boolean addSpecialty(SpecialtyDto dto);
    List<SpecialtyDto> getAll();
    void deleteSpecialty(Long id);
    List<SpecialtyDto> getSpecialtiesByParentId(Long id);
    SpecialtyDto getSpecialtyById(Long id);
    List<SpecialtyDto> specialtiesSearch(String value);
}
