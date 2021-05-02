package by.bntu.surveyofapplicants.soa.service;

import by.bntu.surveyofapplicants.soa.dto.SpecialtyDto;
import by.bntu.surveyofapplicants.soa.entity.Specialty;
import by.bntu.surveyofapplicants.soa.mapper.SpecialtyMapper;
import by.bntu.surveyofapplicants.soa.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpecialtyService {
    @Autowired
    SpecialtyMapper mapper;

    @Autowired
    SpecialtyRepository specialtyRepository;

    public void addSpecialty(SpecialtyDto dto){
        specialtyRepository.save(mapper.toEntity(dto));
    }

    public List<SpecialtyDto> getAll(){
        List<Specialty> specialtyList = specialtyRepository.findAll();
        List<SpecialtyDto> dtoList = new ArrayList<>();
        for(Specialty specialty:specialtyList){
            dtoList.add(mapper.toDto(specialty));
        }
        return dtoList;
    }

    public SpecialtyDto getSpecialtyById(Long id){
        return mapper.toDto(specialtyRepository.findById(id).orElseThrow(NullPointerException::new));
    }
}
