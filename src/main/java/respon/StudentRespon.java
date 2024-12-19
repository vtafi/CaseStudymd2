package respon;

import entity.Course;
import entity.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRespon {
    public static final String STUDENT_CSV = "src/main/java/data/Student.csv";
    private static List<Student> students = new ArrayList<>();
    public List<Student> findAll(){
        File file = new File(STUDENT_CSV);
        List<Student> teachers = new ArrayList<>();
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            String[] temp;
            Student student;
            while ((line = bufferedReader.readLine()) != null){
                temp = line.split(",");
                student = new Student(temp[0],temp[1],Integer.parseInt(temp[2]),temp[3]);
                teachers.add(student);
            }
        }catch (FileNotFoundException  e){
            System.out.println("Loi kh tim thay file");
        }catch (IOException e){
            System.out.println("Loi doc file");
        }
        return teachers;
    }

}
