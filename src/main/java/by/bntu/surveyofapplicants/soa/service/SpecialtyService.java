package by.bntu.surveyofapplicants.soa.service;

import by.bntu.surveyofapplicants.soa.dto.SpecialtyDto;
import by.bntu.surveyofapplicants.soa.entity.Specialty;
import by.bntu.surveyofapplicants.soa.mapper.SpecialtyMapper;
import by.bntu.surveyofapplicants.soa.repository.SpecialtyRepository;
import by.bntu.surveyofapplicants.soa.util.IdentityChecker;
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
    @Autowired
    IdentityChecker identityChecker;

    public boolean addSpecialty(SpecialtyDto dto){
        Specialty specialtyFromPage = mapper.toEntity(dto);
        Specialty specialtyFromDB = specialtyRepository.findByName(dto.getName());
        if(identityChecker.check(specialtyFromDB,specialtyFromPage)){
            specialtyRepository.save(specialtyFromPage);
            return true;
        }
        return false;
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

    public List<SpecialtyDto> getSpecialtiesByParentId(Long id){
        List<Specialty> specialtyList = specialtyRepository.findSpecialtiesByParentId(id);
        List<SpecialtyDto> dtoList = new ArrayList<>();
        for(Specialty specialty:specialtyList){
            dtoList.add(mapper.toDto(specialty));
        }
        return dtoList;
    }

    public List<SpecialtyDto> specialtiesSearch(String value){
        List<Specialty> specialtyList = specialtyRepository.findAllByNameStartingWith(value);
        List<SpecialtyDto> dtoList = new ArrayList<>();
        for(Specialty specialty:specialtyList){
            dtoList.add(mapper.toDto(specialty));
        }
        return dtoList;
    }

    public void deleteSpecialty(Long id){
        specialtyRepository.deleteById(id);
    }
}
