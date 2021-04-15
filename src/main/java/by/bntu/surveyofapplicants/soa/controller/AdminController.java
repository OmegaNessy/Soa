package by.bntu.surveyofapplicants.soa.controller;

import by.bntu.surveyofapplicants.soa.dto.SpecialtyDto;
import by.bntu.surveyofapplicants.soa.entity.Specialty;
import by.bntu.surveyofapplicants.soa.repository.FacultyRepository;
import by.bntu.surveyofapplicants.soa.repository.SpecialtyRepository;
import by.bntu.surveyofapplicants.soa.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    FacultyRepository facultyRepository;
    @Autowired
    SpecialtyRepository specialtyRepository;
    @Autowired
    SpecialtyService specialtyService;

    @GetMapping("/main")
    public String index(){
        return "index";
    }

    @GetMapping("/facultyList")
    public String getAllFaculties(Model model){
        model.addAttribute("facultyList",facultyRepository.findAll());
        return "facultyPage";
    }

    @GetMapping("/specialtyList")
    public String getAllSpecialties(Model model){
        model.addAttribute("specialtyList",specialtyRepository.findAll());
        return "specialtyPage";
    }

    @GetMapping("/deleteFaculty/{id}")
    public String deleteFaculty(@PathVariable Long id, Model model) {
        facultyRepository.deleteById(id);
        return getAllFaculties(model);
    }

    @GetMapping("/deleteSpecialty/{id}")
    public String deleteSpecialty(@PathVariable String id, Model model) {
        specialtyRepository.deleteById(Long.valueOf(id));
        return "redirect:/admin/specialtyList";
    }

    @GetMapping("/specialty/add")
    public String openSpecialtyEditor(Model model){
        return "addSpecialtyPage";
    }

    @PostMapping("/specialty/add")
    public String addSpecialty(@ModelAttribute SpecialtyDto specialtyDto){
        specialtyService.addSpecialty(specialtyDto);
        return "redirect:/admin/specialtyList";
    }
}
