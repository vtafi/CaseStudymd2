package entity;

public class Course {
                // Số thứ tự của từng đối tượng
    private String code;
    private String title;
    private String teacher;

    // Constructor
    public Course(String code, String title, String teacher) {
         // Tự động tăng STT
        this.code = code;
        this.title = title;
        this.teacher = teacher;
    }

    // Getter và Setter


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    // Override phương thức toString để định dạng kiểu bảng
    @Override
    public String toString() {
        return String.format(" %-10s | %-10s | %-10s", code, title, teacher);
    }
}
