package view;

import controller.StudentController;
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
                    System.out.println("hello");
                    break;
                case 3:
                    return;

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
            System.out.println("5. Tìm kiếm học sinh theo tên");
            System.out.println("6. Quay lại");
            System.out.print("Mời bạn nhập lựa chọn: ");
            List<Student> students;
            int choice = scanner.nextInt();
            switch (choice){
                case 1: break;
                case 2:
                    students = studentController.getAll();
                    System.out.println(students);
                    break;
                case 3: break;
                case 4: break;
                case 5: break;
                case 6: return;
            }
        }
    }
}
