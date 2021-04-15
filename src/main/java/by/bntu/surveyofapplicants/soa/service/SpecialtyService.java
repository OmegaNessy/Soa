package by.bntu.surveyofapplicants.soa.service;

import by.bntu.surveyofapplicants.soa.dto.SpecialtyDto;
import by.bntu.surveyofapplicants.soa.entity.Specialty;
import by.bntu.surveyofapplicants.soa.mapper.SpecialtyMapper;
import by.bntu.surveyofapplicants.soa.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialtyService {
    @Autowired
    SpecialtyMapper mapper;

    @Autowired
    SpecialtyRepository specialtyRepository;

    public void addSpecialty(SpecialtyDto dto){
        specialtyRepository.save(mapper.toEntity(dto));
    }
}
