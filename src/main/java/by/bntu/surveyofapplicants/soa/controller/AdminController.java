package by.bntu.surveyofapplicants.soa.controller;

import by.bntu.surveyofapplicants.soa.dto.*;
import by.bntu.surveyofapplicants.soa.entity.Faculty;
import by.bntu.surveyofapplicants.soa.entity.Question;
import by.bntu.surveyofapplicants.soa.entity.Test;
import by.bntu.surveyofapplicants.soa.repository.FacultyRepository;
import by.bntu.surveyofapplicants.soa.repository.SpecialtyRepository;
import by.bntu.surveyofapplicants.soa.repository.TestRepository;
import by.bntu.surveyofapplicants.soa.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    FacultyRepository facultyRepository;
    @Autowired
    SpecialtyRepository specialtyRepository;
    @Autowired
    TestRepository testRepository;
    @Autowired
    SpecialtyService specialtyService;
    @Autowired
    UserService userService;
    @Autowired
    TestService testService;
    @Autowired
    QuestionService questionService;
    @Autowired
    AnswerService answerService;
    @Autowired
    FacultyService facultyService;
    @Autowired
    QuestionTypeService questionTypeService;
    @Autowired
    SubjectService subjectService;

    @GetMapping("/main")
    public String adminPanel(){
        return "adminPanel";
    }

    @GetMapping("/facultyList")
    public String getAllFaculties(Model model){
        model.addAttribute("facultyList",facultyRepository.findAll());
        return "facultyPage";
    }

    @GetMapping("/deleteFaculty/{id}")
    public String deleteFaculty(@PathVariable Long id, Model model) {
        facultyRepository.deleteById(id);
        return getAllFaculties(model);
    }
    @GetMapping("/faculty/edit/{id}")
    public String editFaculty(@PathVariable Long id, Model model){
        model.addAttribute("faculty",facultyService.getFacultyById(id));
        return "editFaculty";
    }

    @GetMapping("/faculty/edit")
    public String editFaculty(Model model){
        model.addAttribute("faculty", new FacultyDto());
        return "editFaculty";
    }

    @PostMapping("/faculty/edit")
    public String addFaculty(@ModelAttribute("faculty") @Valid FacultyDto dto, BindingResult result){
        if (result.hasErrors()){
            return "editFaculty";
        }
        facultyService.saveFaculty(dto);
        return "redirect:/admin/facultyList";
    }

    @GetMapping("/specialtyList")
    public String getAllSpecialties(Model model){
        model.addAttribute("specialtyList",specialtyService.getAll());
        return "specialtyPage";
    }

    @GetMapping("/deleteSpecialty/{id}")
    public String deleteSpecialty(@PathVariable String id) {
        specialtyRepository.deleteById(Long.valueOf(id));
        return "redirect:/admin/specialtyList";
    }

    @GetMapping("/specialty/add")
    public String openSpecialtyEditor(Model model){
        model.addAttribute("specialty",new SpecialtyDto());
        model.addAttribute("facultyList",facultyService.getAllFaculties());
        model.addAttribute("subjectList",subjectService.getAllSubjects());
        return "addSpecialtyPage";
    }

    @GetMapping("/specialty/add/{id}")
    public String openSpecialtyEditor(@PathVariable Long id, Model model){
        model.addAttribute("specialty",specialtyService.getSpecialtyById(id));
        model.addAttribute("facultyList",facultyService.getAllFaculties());
        model.addAttribute("subjectList",subjectService.getAllSubjects());
        return "addSpecialtyPage";
    }

    @PostMapping("/specialty/add")
    public String addSpecialty(@ModelAttribute("specialty") @Valid SpecialtyDto specialtyDto, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("facultyList",facultyService.getAllFaculties());
            model.addAttribute("subjectList",subjectService.getAllSubjects());
            return "addSpecialtyPage";
        }
        specialtyService.addSpecialty(specialtyDto);
        return "redirect:/admin/specialtyList";
    }

    @GetMapping("/users")
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.allUsers());
        return "usersAndRoles";
    }

    @PostMapping("/users/delete")
    public String  deleteUser(@RequestParam(required = true, defaultValue = "" ) Long userId,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model) {
        if (action.equals("delete")){
            userService.deleteUser(userId);
        }
        return "redirect:/admin/users";
    }

    @GetMapping("/test")
    public String getTestList(Model model){
        model.addAttribute("test", new TestDto());
        model.addAttribute("testList", testService.getAllTests());
        model.addAttribute("faculties", facultyService.getAllFaculties());
        return "testsList";
    }

    @GetMapping("/deleteTest/{id}")
    public String deleteTest(@PathVariable Long id, Model model) {
        testRepository.deleteById(id);
        return "redirect:/admin/test";
    }

    @PostMapping("/test/add")
    public String addTest(@ModelAttribute("test") @Valid TestDto testDto, BindingResult result,Model model){
        if(result.hasErrors()){
            model.addAttribute("testList", testService.getAllTests());
            model.addAttribute("faculties", facultyService.getAllFaculties());
            return "testsList";
        }
        if(!testService.saveTest(testDto)){
            model.addAttribute("errorMessage", "Общий тест уже присутствует");
            model.addAttribute("testList", testService.getAllTests());
            model.addAttribute("faculties", facultyService.getAllFaculties());
            return "testsList";
        }
        return "redirect:/admin/test";
    }

    @PostMapping("/test/edit")
    public String editTest(@ModelAttribute("test") @Valid TestDto testDto, BindingResult result,Model model){
        if(result.hasErrors()){
            model.addAttribute("testList", testService.getAllTests());
            model.addAttribute("faculties", facultyService.getAllFaculties());
            return "editTest";
        }
        if(!testService.saveTest(testDto)){
            model.addAttribute("errorMessage", "Общий тест уже присутствует");
            model.addAttribute("testList", testService.getAllTests());
            model.addAttribute("faculties", facultyService.getAllFaculties());
            return "editTest";
        }
        return "redirect:/admin/test";
    }

    @GetMapping("/test/edit/{id}")
    public String editTest(@PathVariable Long id, Model model){
        model.addAttribute("test",testService.getTestById(id));
        model.addAttribute("faculties", facultyService.getAllFaculties());
        return "editTest";
    }

    @GetMapping("/test/{id}/question")
    public String getQuestionList(@PathVariable Long id, Model model){
        model.addAttribute("questionList", questionService.getAllQuestionsByTestId(id));
        model.addAttribute("test",testService.getTestById(id));
        model.addAttribute("question",new QuestionDto());
        model.addAttribute("questionTypes",questionTypeService.getAllQuestionTypes());
        return "questionsList";
    }

    @PostMapping("/test/question/add")
    public String addTest(@ModelAttribute("question") @Valid QuestionDto dto, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("questionList", questionService.getAllQuestionsByTestId(dto.getTestId()));
            model.addAttribute("test",testService.getTestById(dto.getTestId()));
            model.addAttribute("questionTypes",questionTypeService.getAllQuestionTypes());
            return "questionsList";
        }
        questionService.saveQuestion(dto);
        return "redirect:/admin/test/"+dto.getTestId()+"/question";
    }

    @PostMapping("/test/question/edit")
    public String editTest(@ModelAttribute("question") @Valid QuestionDto dto, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("questionList", questionService.getAllQuestionsByTestId(dto.getTestId()));
            model.addAttribute("test",testService.getTestById(dto.getTestId()));
            model.addAttribute("questionTypes",questionTypeService.getAllQuestionTypes());
            return "editQuestion";
        }
        questionService.saveQuestion(dto);
        return "redirect:/admin/test/"+dto.getTestId()+"/question";
    }

    @GetMapping("/test/{testId}/deleteQuestion/{id}")
    public String deleteQuestion(@PathVariable Long id,@PathVariable Long testId) {
        questionService.deleteById(id);
        return "redirect:/admin/test/"+testId+"/question";
    }

    @GetMapping("/question/edit/{id}")
    public String editQuestion(@PathVariable Long id, Model model){
        model.addAttribute("question",questionService.getQuestionById(id));
        model.addAttribute("questionTypes",questionTypeService.getAllQuestionTypes());
        return "editQuestion";
    }

    @GetMapping("/test/question/{id}/answer")
    public String getAnswerList(@PathVariable Long id, Model model){
        model.addAttribute("answersList", answerService.getAllAnswersByQuestionId(id) );
        model.addAttribute("question",questionService.getQuestionById(id));
        model.addAttribute("answer",new AnswerDto());
        model.addAttribute("faculties",facultyService.getAllFaculties());
        return "answersList";
    }
    @PostMapping("/test/question/answer/add")
    public String addAnswer(@ModelAttribute("answer") @Valid AnswerDto dto, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("answersList", answerService.getAllAnswersByQuestionId(dto.getQuestionId()) );
            model.addAttribute("question",questionService.getQuestionById(dto.getQuestionId()));
            model.addAttribute("faculties",facultyService.getAllFaculties());
            return "answersList";
        }
        answerService.saveAnswer(dto);
        return "redirect:/admin/test/question/"+dto.getQuestionId()+"/answer";
    }
    @PostMapping("/test/question/answer/edit")
    public String editAnswer(@ModelAttribute("answer") @Valid AnswerDto dto, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("answersList", answerService.getAllAnswersByQuestionId(dto.getQuestionId()) );
            model.addAttribute("question",questionService.getQuestionById(dto.getQuestionId()));
            model.addAttribute("faculties",facultyService.getAllFaculties());
            return "editAnswer";
        }
        answerService.saveAnswer(dto);
        return "redirect:/admin/test/question/"+dto.getQuestionId()+"/answer";
    }

    @GetMapping("/test/question/{questionId}/deleteAnswer/{id}")
    public String deleteAnswer(@PathVariable Long id,@PathVariable Long questionId) {
        answerService.deleteById(id);
        return "redirect:/admin/test/question/"+questionId+"/answer";
    }
    @GetMapping("/test/question/answer/edit/{id}")
    public String editAnswer(@PathVariable Long id, Model model) {
        model.addAttribute("answer", answerService.getAnswerById(id));
        model.addAttribute("faculties",facultyService.getAllFaculties());
        return "editAnswer";
    }
//    @PostMapping("/test/edit")
//    public String editTest(@ModelAttribute TestDto testDto){
//        testService.saveTest(testDto);
//        return "redirect:/admin/test";
//    }
}
