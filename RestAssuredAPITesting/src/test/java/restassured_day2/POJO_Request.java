package restassured_day2;

import java.util.ArrayList;
import java.util.Map;

public class POJO_Request {
	String usn;
	String name;
	String gender;
	int semester;
	String courses[][];
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
	public String[][] getCourses() {
		return courses;
	}
	public void setCourses(String[][] courses) {
		this.courses = courses;
	}
	public void setCourses(ArrayList<Map<String, Object>> courses2) {
		// TODO Auto-generated method stub
		
	}
	

}
