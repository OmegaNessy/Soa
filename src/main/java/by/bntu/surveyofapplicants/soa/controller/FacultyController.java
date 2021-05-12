package by.bntu.surveyofapplicants.soa.controller;

import by.bntu.surveyofapplicants.soa.dto.FacultyDto;
import by.bntu.surveyofapplicants.soa.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FacultyController {
    @Autowired
    FacultyService service;

    @GetMapping("/faculty/all")
    public List<FacultyDto> getAll(){
        return service.getAllFaculties();
    }

    @GetMapping("/faculty/{id}")
    public FacultyDto getById(@PathVariable Long id){
        return service.getFacultyById(id);
    }

    @GetMapping("/faculty/search/{searchString}")
    public List<FacultyDto> getSpecialtiesBySearchString(@PathVariable String searchString){
        return service.facultiesSearch(searchString);
    }
}
