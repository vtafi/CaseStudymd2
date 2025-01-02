package view;

import controller.StudentController;
import entity.Student;
import java.util.List;
import java.util.Scanner;

public class Validation {
    static StudentController studentController = new StudentController();
    static List<Student> students = studentController.getAll();
    public static int validateCode(Scanner scanner){
        while (true){
            try {
                boolean check = true;
                System.out.println("Nhap ma sinh vien");
                int code = Integer.parseInt(scanner.nextLine());
                for (Student student : students){
                    if (student.getId() == code){
                        System.out.println("Ma sv da trung lap");
                        check = false;
                        break;
                    }
                }
                if (check && code > 0){
                    return code;
                } else if (check){
                    System.out.println("Ma sinh vien phai la so duong");
                }
            }catch (NumberFormatException e){
                System.out.println("Ma sinh vien khong hop le. Vui long nhap lai");
            }
        }
    }
    public static String validateName(Scanner scanner){
        while (true){
            System.out.println("Nhap vao ten sinh vien");
            String name = scanner.nextLine();
            if (name.isEmpty()){
                System.out.println("Ten khong dc de trong");
            }else if (!name.matches("^[a-zA-Z\\\\s]+$")){
                System.out.println("Ten khong dc co ky tu dac biet");
            }else {
                return name;
            }
        }
    }
    public static int validateAge(Scanner scanner){
        while (true){
            try {
                System.out.println("Nhap tuoi sinh vien");
                int age = Integer.parseInt(scanner.nextLine());
                if (age >= 17 && age <=60){
                    return age;
                }else {
                    System.out.println("Do tuoi khong hop le.");
                }
            }catch (NumberFormatException e){
                System.out.println("Du lieu dau vao phai la so nguyen.");
            }
        }
    }
    public static String validateChoice(Scanner scanner){
        while (true){
            List<String> choice = List.of("y","n");
            System.out.println("Ban co muon dang ky khoa hoc khong(y/n):");
            String choice1 = scanner.nextLine();
            if (choice.contains(choice1)){
                return choice1;
            }else {
                System.out.println("Ban bat buoc phai chon y/n");
            }
        }
    }
    public static int validationCode1(Scanner scanner){
        while (true){
            try {
                System.out.println("Nhap ma sinh vien");
                int code = Integer.parseInt(scanner.nextLine());
                if (code > 0){
                    return code;
                } else
                    System.out.println("Ma sinh vien phai la so duong");
            }catch (NumberFormatException e){
                System.out.println("Ma sinh vien khong hop le. Vui long nhap lai");
            }
        }
    }
}
