package controller;

import entity.Student;
import service.impl.StudentService;

import java.util.List;

public class StudentController {
    public StudentService studentService = new StudentService();
    public List<Student> getAll(){
        return studentService.getAll();
    }
}
