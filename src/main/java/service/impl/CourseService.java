package service.impl;

import entity.Course;
import respon.ListCourse;
import service.ICourseService;

import java.util.List;

public class CourseService implements ICourseService {
    private static ListCourse listCourse = new ListCourse();
    public List<Course> getAll() {
        return listCourse.getCourses();
    }

    public List<Course> save(Course course) {
        return List.of();
    }

    @Override
    public void remove(int id) {

    }

    public List<Course> update(int id, Course course) {
        return null;
    }

    public Course findById(int id) {
        return null;
    }

    @Override
    public List<Course> findByName(String name) {
        return listCourse.findByName(name);
    }
}
