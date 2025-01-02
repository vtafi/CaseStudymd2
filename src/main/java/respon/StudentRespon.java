package respon;

import entity.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRespon {
    public static final String STUDENT_CSV = "src/main/java/data/Student.csv";
    public List<Student> findAll(){
        File file = new File(STUDENT_CSV);
        List<Student> students = new ArrayList<>();
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            String[] temp;
            Student student;
            while ((line = bufferedReader.readLine()) != null){
                temp = line.split(",");
                student = new Student(Integer.parseInt(temp[0]),temp[1],Integer.parseInt(temp[2]),temp[3]);
                students.add(student);
            }
        }catch (FileNotFoundException  e){
            System.out.println("Loi kh tim thay file");
        }catch (IOException e){
            System.out.println("Loi doc file");
        }
        return students;
    }
    public void save(Student student) {
        File file = new File(STUDENT_CSV);
        try(FileWriter fileWriter = new FileWriter(file,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
            bufferedWriter.write(studentToString(student));
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.out.println("Loi ghi file");
        }
    }
    private String studentToString(Student student) {
        return student.getId()+","+student.getName()+","+student.getAge()+","+student.getIdCourse();
    }
    public Student findByID(int id){
        List<Student> students = findAll();
        for (Student student : students){
            if (student.getId() == id){
                return student;
            }
        }
        return null;
    }
    public List<Student> findByName(String name) {
        List<Student> students = findAll();
        List<Student> newstudent = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().contains(name)) {
                newstudent.add(student);
            }
        }
        return newstudent;
    }
//    public List<Student> update(int id){
//
//    }
    public void remove(int id){
        List<Student> students = findAll();
        students.removeIf(student -> student.getId() == id);
        writeFile(students,false);
    }
    public List<Student> update(int id, Student updatedStudent) {
        // Lấy toàn bộ danh sách sinh viên
        List<Student> students = findAll();
        boolean isUpdated = false;

        // Duyệt qua danh sách và tìm sinh viên cần cập nhật
        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(updatedStudent.getName());
                student.setAge(updatedStudent.getAge());
                student.setIdCourse(updatedStudent.getIdCourse());
                isUpdated = true;
                break;
            }
        }
        if (isUpdated) {
            writeFile(students, false);
            System.out.println("Đã cập nhật sinh viên với ID: " + id);
        } else {
            System.out.println("Không tìm thấy sinh viên với ID: " + id);
        }

        return students;
    }

    public void writeFile(List<Student> students,boolean t ) {
        File file = new File(STUDENT_CSV);
        try(FileWriter fileWriter = new FileWriter(file,t);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Student student : students){
                bufferedWriter.write(studentToString(student));
                bufferedWriter.newLine();
            }
        }catch (IOException e) {
            System.out.println("Loi ghi file");
        }
    }
}
