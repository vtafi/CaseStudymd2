package controller;

import entity.Course;
import service.impl.CourseService;

import java.util.List;

public class CourseController {
    public CourseService courseService = new CourseService();
    public List<Course> getAll(){
        return courseService.getAll();
    }
    public List<Course> findByName(String name){
        return courseService.findByName(name);
    }
}
