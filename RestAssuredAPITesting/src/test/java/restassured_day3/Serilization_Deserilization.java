package restassured_day3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Serilization_Deserilization {
    
    @Test(priority=0)
    void convertPojotoJson() throws JsonProcessingException {
        // Creating an instance of POJO_Request
        POJO_Request data = new POJO_Request();
        data.setUsn("4AL21CS037");
        data.setName("Deepak");
        data.setGender("Male");
        data.setSemester(8);

        // Creating a list of courses
        ArrayList<Map<String, Object>> courses = new ArrayList<Map<String, Object>>();

        // Creating a course entry
        Map<String, Object> course1 = new HashMap<String, Object>();
        course1.put("course_no", "CS101");
        course1.put("course_name", "Database");
        course1.put("duration", "3 months");
        course1.put("fees", 5800);

        // Adding the course to the list
        courses.add(course1);

        // Setting the courses in POJO
        data.setCourses(courses);

        // Convert Java Object to JSON String using Jackson
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonData = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
        System.out.println(jsonData);
    }
    //Convert Json to Pojo
    @Test(priority = 1)
    void convertJsontoPojo() throws JsonProcessingException {
    	String jsondata = "{"
    		    + "\"usn\": \"4AL21CS037\","
    		    + "\"name\": \"Deepak\","
    		    + "\"gender\": \"Male\","
    		    + "\"semester\": 8,"
    		    + "\"courses\": [ {"
    		    + "\"duration\": \"3 months\","
    		    + "\"fees\": 5800,"
    		    + "\"course_name\": \"Database\","
    		    + "\"course_no\": \"CS101\""
    		    + "} ]"
    		    + "}";
    	
//Converting Json Object to Pojo
    	ObjectMapper stuobj=new ObjectMapper();
    	POJO_Request stu=stuobj.readValue(jsondata,POJO_Request.class);//Convert JSON to POJO
    	System.out.println(stu.getName());
    	System.out.println(stu.getUsn());
    	System.out.println(stu.getSemester());
    	

    }

    	}
    

