package entity;

public class Student {
    private int id;
    private String name;
    private int age;
    private String idCourse;

    public Student(int id, String name, int age, String idCourse) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.idCourse = idCourse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(String idCourse) {
        this.idCourse = idCourse;
    }

    @Override
    public String toString() {
        return String.format("%-5s | %-10s | %-20s | %-10s", id, name, age, idCourse);
    }
}