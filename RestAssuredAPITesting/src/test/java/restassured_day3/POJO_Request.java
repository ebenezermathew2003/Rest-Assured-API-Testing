package restassured_day3;

import java.util.List;
import java.util.Map;

public class POJO_Request {
    private String usn;
    private String name;
    private String gender;
    private int semester;
    private List<Map<String, Object>> courses;

    // Getters and Setters
    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public List<Map<String, Object>> getCourses() {
        return courses;
    }

    public void setCourses(List<Map<String, Object>> courses) {
        this.courses = courses;
    }
}
