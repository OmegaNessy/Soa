package by.bntu.surveyofapplicants.soa.controller;

import by.bntu.surveyofapplicants.soa.dto.SpecialtyDto;
import by.bntu.surveyofapplicants.soa.service.SpecialtyService;
import by.bntu.surveyofapplicants.soa.service.impl.SpecialtyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpecialtyController {
    @Autowired
    SpecialtyService service;

    @GetMapping("/specialty/all")
    public List<SpecialtyDto> getAll(){
        return service.getAll();
    }

    @GetMapping("/faculty/{id}/specialty")
    public List<SpecialtyDto> getSpecialty(@PathVariable Long id){
        return service.getSpecialtiesByParentId(id);
    }

    @GetMapping("/specialty/{id}")
    public SpecialtyDto getById(@PathVariable Long id){
        return service.getSpecialtyById(id);
    }

    @GetMapping("/specialty/search/{searchString}")
    public List<SpecialtyDto> getSpecialtiesBySearchString(@PathVariable String searchString){
        return service.specialtiesSearch(searchString);
    }
}
