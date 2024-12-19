package service.impl;

import entity.Student;
import respon.StudentRespon;
import service.IService;

import java.util.List;

public class StudentService implements IService {
    private static StudentRespon studentRespon = new StudentRespon();
    @Override
    public List<Student> getAll() {
        return studentRespon.findAll();
    }

    @Override
    public List save(Object o) {
        return List.of();
    }

    @Override
    public List remove() {
        return List.of();
    }

    @Override
    public Object update(int id, Object o) {
        return null;
    }

    @Override
    public Object findById(int id) {
        return null;
    }

    @Override
    public List findByName(String name) {
        return List.of();
    }
}
