package respon;

import entity.Course;
import entity.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListCourse {
    public static final String COURSE_CSV = "src/main/java/data/Course.csv";
    public List<Course> getCourses(){
        File file = new File(COURSE_CSV);
        List<Course> courses = new ArrayList<>();
        try (FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            String[] temp;
            Course course;
            while ((line = bufferedReader.readLine()) != null){
                temp = line.split(",");
                course = new Course(temp[0],temp[1],temp[2]);
                courses.add(course);
            }
        }catch (FileNotFoundException e){
            System.out.println("Loi kh tim thay file");
        }catch (IOException e){
            System.out.println("Loi doc file");
        }
        return courses;
    }
    public List<Course> findByName(String name){
        List<Course> courses = getCourses();
        List<Course> newCourse = new ArrayList<>();
        for (Course course : courses){
            if (course.getTitle().contains(name)){
                newCourse.add(course);
            }
        }
        return newCourse;
    }
    }
