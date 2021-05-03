package by.bntu.surveyofapplicants.soa.service;

import by.bntu.surveyofapplicants.soa.dto.SubjectDto;
import by.bntu.surveyofapplicants.soa.entity.Subject;
import by.bntu.surveyofapplicants.soa.mapper.SubjectMapper;
import by.bntu.surveyofapplicants.soa.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService {
    @Autowired
    SubjectMapper subjectMapper;
    @Autowired
    SubjectRepository repository;

    public List<SubjectDto> getAllSubjects (){
        List<Subject> subjects = repository.findAll();
        List<SubjectDto> subjectDtos = new ArrayList<>();
        for(Subject subject:subjects){
            subjectDtos.add(subjectMapper.toDto(subject));
        }
        return subjectDtos;
    }
}
