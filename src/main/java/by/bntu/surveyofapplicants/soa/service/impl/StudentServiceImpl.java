package by.bntu.surveyofapplicants.soa.service.impl;

import by.bntu.surveyofapplicants.soa.entity.Student;
import by.bntu.surveyofapplicants.soa.entity.TestResult;
import by.bntu.surveyofapplicants.soa.repository.StudentRepository;
import by.bntu.surveyofapplicants.soa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public Map<Long,Student> getAllStudentsOfResults(List<TestResult> results){
        List<Long> ids = results.stream().map(TestResult::getStudentId).collect(Collectors.toList());
        List<Student> studentList = studentRepository.findByIdIn(ids);
        return studentList.stream().collect(Collectors.toMap(Student::getId, v->v));
    }
}
