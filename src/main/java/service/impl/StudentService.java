package service.impl;

import entity.Student;
import respon.StudentRespon;
import service.IStudentService;

import java.util.List;

public class StudentService implements IStudentService {
    private static StudentRespon studentRespon = new StudentRespon();
    @Override
    public List<Student> getAll() {
        return studentRespon.findAll();
    }

    @Override
    public List<Student> save(Student student) {
        studentRespon.save(student);
        return studentRespon.findAll();
    }

    @Override
    public void remove(int id) {
        studentRespon.remove(id);
    }

    @Override
    public List<Student> update(int id, Student student) {
        return studentRespon.update(id,student) ;
    }

    @Override
    public Student findById(int id) {
        return studentRespon.findByID(id);
    }

    @Override
    public List<Student> findByName(String name) {
        return studentRespon.findByName(name);
    }
}
