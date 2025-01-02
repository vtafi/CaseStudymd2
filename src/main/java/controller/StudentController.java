package controller;

import entity.Student;
import service.impl.StudentService;

import java.util.List;

public class StudentController {
    public StudentService studentService = new StudentService();
    public List<Student> getAll(){
        return studentService.getAll();
    }
    public void save(Student student){
        studentService.save(student);
    }
    public Student findById(int id){
        return studentService.findById(id);
    }
    public List<Student> findByName(String name){
        return studentService.findByName(name);
    }
    public List<Student> update(int id, Student student){
        return studentService.update(id,student);
    }
    public void remove(int id){
        studentService.remove(id);
    }
}
