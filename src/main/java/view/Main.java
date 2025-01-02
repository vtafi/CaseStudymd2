package view;

import controller.CourseController;
import controller.StudentController;
import entity.Course;
import entity.Student;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("---------Chương trình quản lý học sinh------------");
            System.out.println("1. Quản lý học sinh");
            System.out.println("2. Thông tin khóa học");
            System.out.println("3. Thoát");
            System.out.print("Mời bạn nhập lựa chọn: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    menuStudent();
                    break;
                case 2:
                    menuCourse();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Nhap sai vui long nhap lai");
            }
        }
    }

    public static void menuStudent() {
        StudentController studentController = new StudentController();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("---------Chương trình quản lý học sinh------------");
            System.out.println("1. Thêm học sinh");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Sửa thông tin học sinh");
            System.out.println("4. Xóa học sinh");
            System.out.println("5. Tìm kiếm học sinh");
            System.out.println("6. Quay lại");
            System.out.print("Mời bạn nhập lựa chọn: ");
            List<Student> students ;
            Student student1;
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    addStudent();
                    break;
                case 2:
                    students = studentController.getAll();
                    printMenuStudent();
                    for (Student student : students) {
                        System.out.printf("%-5s | %-20s | %-5s | %-10s%n",
                                student.getId(),
                                student.getName(),
                                student.getAge(),
                                student.getIdCourse());
                    }
                    break;
                case 3:
                    System.out.println("Nhap vao id b muon cap nhat");
                    int codeUpdate = Integer.parseInt(scanner.nextLine());
                    Student existStudent = studentController.findById(codeUpdate);
                    if (existStudent == null){
                        System.out.println("Không tìm thấy sinh viên với ID: " + codeUpdate);
                        return;
                    }System.out.println("Nhập tên mới (hiện tại: " + existStudent.getName() + "):");
                    String newName = scanner.nextLine();
                    System.out.println("Nhập tuổi mới (hiện tại: " + existStudent.getAge() + "):");
                    int newAge = Integer.parseInt(scanner.nextLine());
                    System.out.println("Nhập mã khóa học mới (hiện tại: " + existStudent.getIdCourse() + "):");
                    String newCourseId = scanner.nextLine();
                    Student updatedStudent = new Student(codeUpdate, newName, newAge, newCourseId);
                    List<Student> result1 = studentController.update(codeUpdate, updatedStudent);
                    if (result1 != null) {
                        System.out.println("Cập nhật thành công!");
                    } else {
                        System.out.println("Cập nhật thất bại!");
                    }
                    break;
                case 4:
                    int id = Validation.validationCode1(scanner);
                    student1 = studentController.findById(id);
                    if (student1 == null){
                        System.out.println("Khong tim thay id muon xoa");
                    }else{
                        studentController.remove(id);
                        System.out.println("Xoa thanh cong");
                    }
                    break;
                case 5:
                    while (true){
                    System.out.println("---------Tim kiem---------");
                    System.out.println("1. Tim kiem theo ten");
                    System.out.println("2. Tim kien theo id");
                    System.out.println("Moi ban nhap lua chon: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            String name =Validation.validateName(scanner);
                            List<Student> result = studentController.findByName(name);
                            if (result.isEmpty()) {
                                System.out.println("Khong tim thay sinh vien nao co ten phu hop!");
                            } else {
                                System.out.println("Danh sach sinh vien tim thay:");
                                printMenuStudent();
                                for (Student student : result) {
                                    System.out.printf("%-5s | %-20s | %-5s | %-10s%n",
                                            student.getId(),
                                            student.getName(),
                                            student.getAge(),
                                            student.getIdCourse());
                                }
                            }
                            break;
                        case 2:
                            int idFind = Validation.validationCode1(scanner);
                            Student student = studentController.findById(idFind);
                            if (student.getId() == idFind) {
                                System.out.println("Danh sach sinh vien tim thay:");
                                printMenuStudent();
                                System.out.printf("%-5s | %-20s | %-5s | %-10s%n",
                                        student.getId(),
                                        student.getName(),
                                        student.getAge(),
                                        student.getIdCourse());
                            } else {
                                System.out.println("Khong tim thay");
                            }
                        case 3 : return;
                        default:
                            System.out.println("Nhap sai vui long nhap lai");
                    }
                    break;
                    }
                case 6: return;
                default:
                    System.out.println("Nhap sai vui long nhap lai");
            }
        }
    }
public static void addStudent() {
    CourseController courseController = new CourseController();
    StudentController studentController = new StudentController();
    List<Course> courses;
    Scanner scanner = new Scanner(System.in);
    int code = Validation.validateCode(scanner);
    String name = Validation.validateName(scanner);
    int age = Validation.validateAge(scanner);
    String choice1 = Validation.validateChoice(scanner);
    if (choice1.equals("y")){
        System.out.println("-------------------Danh sach khoa hoc-------------------");
        printMenuCourse();
        courses = courseController.getAll();
        for (Course course : courses) {
            System.out.printf(" %-10s | %-20s | %-10s%n",course.getCode(), course.getTitle(), course.getTeacher());
        }
        String course;
        List<String> validCourses = List.of("JV103", "JV104","JV105");
        do {
            System.out.println("Nhập khóa học muốn đăng ký : ");
            course = scanner.nextLine();
            if (!validCourses.contains(course)) {
                System.out.println("Khóa học không hợp lệ! Vui lòng nhập lại.");
            }
        } while (!validCourses.contains(course));
        Student student = new Student(code, name, age, course);
        studentController.save(student);
        System.out.println("Thêm mới thành công!");
    }else if (choice1.equals("n")){
        System.out.println("Them moi khong thanh cong");
        System.out.println("Ban bat buoc phai dang ky khoa hoc");
    }
}
public static void menuCourse(){
    CourseController courseController = new CourseController();
    Scanner scanner = new Scanner(System.in);
    while (true){
        System.out.println("-------------Thông tin khóa học-------------");
        System.out.println("1. Hiển thị khóa học");
        System.out.println("2. Tìm kiếm khóa học");
        System.out.println("3. Quay lại");
        System.out.println("Mời bạn nhập lựa chọn");
        List<Course> courses;
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                printMenuCourse();
                courses = courseController.getAll();
                for (Course course : courses) {
                    System.out.printf("%-10s | %-20s | %-10s%n", course.getCode(), course.getTitle(), course.getTeacher());
                }
                System.out.println("--------------------------------------------");
                break;
            case 2:
                System.out.println("Nhap vao ten muon tim: ");
                scanner.nextLine();
                String name = scanner.nextLine();
                List<Course> result = courseController.findByName(name);
                if (result.isEmpty()){
                    System.out.println("Khong tim thay khoa hoc");
                }else {
                    System.out.println("Tim thay khoa hoc");
                    printMenuCourse();
                    for (Course course : result) {
                        System.out.printf("%-10s | %-20s | %-10s%n", course.getCode(), course.getTitle(), course.getTeacher());
                    }
                    System.out.println("--------------------------------------------");
                }
                break;
            case 3: return;
        }
    }
}
    private static void printMenuCourse() {
        System.out.printf(" %-10s | %-20s | %-10s%n","Code", "Title", "Teacher");
        System.out.println("--------------------------------------------");
    }
    private static void printMenuStudent() {
        System.out.printf("%-5s | %-20s | %-5s | %-10s%n", "Code", "Name", "Age", "Course");
        System.out.println("-------------------------------------------");
    }
}


