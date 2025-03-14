package restassured_day2;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
/*
 Different Ways to create POSt request body
 1)Post request body using HsahMap
 2)Post request body creation using Org.JSON
 3)Post request body creation using POJO class
 4)Post request using external json file data 
 */

public class WaysToCreatePostRequest {
	String id;
	//1)By using HashMap Post Request
	//@Test(priority=0)
	public void postusinghashmap()
	{
		Map<String, Object> studentData = new HashMap<String, Object>();
        studentData.put("USN", "4AL21CS005");
        studentData.put("name", "Ebenezer Mathew");
        studentData.put("gender", "Male");
        studentData.put("semester", 8); 

        // Creating a list of courses
        List<Map<String, Object>> courses = new ArrayList<Map<String, Object>>();

        Map<String, Object> course1 = new HashMap<String, Object>();
        course1.put("course_no", "CS101");
        course1.put("course_name", "Database");
        course1.put("duration", "3 months");
        course1.put("fees", 5800); 

        courses.add(course1);

        // Adding courses to student data
        studentData.put("courses", courses);

       
        given()
            .contentType("application/json")
            .body(studentData.toString())
        .when()
            .post("http://localhost:3000/students")
        .then()
            .statusCode(201)
            .body("name", equalTo("Ebenezer Mathew"))
            .body("semester", equalTo(8))
            .log().all();
    }
	//@Test(priority=1)
	void deleteuser()
	{
		given()
		
		.when()
			.delete("http://localhost:3000/students/393b")
		.then()
			.statusCode(200);
			
	}
	//2)Post request body creation using Org.JSON
	//@Test(priority = 0)
	public void postusingJSONLibrary()
	{
		JSONObject studentData = new JSONObject();
        studentData.put("USN", "4AL21CS005");
        studentData.put("name", "Ebenezer Mathew");
        studentData.put("gender", "Male");
        studentData.put("semester", 8); 

        // Creating a list of courses
        List<Map<String, Object>> courses = new ArrayList<Map<String, Object>>();

        Map<String, Object> course1 = new HashMap<String, Object>();
        course1.put("course_no", "CS101");
        course1.put("course_name", "Database");
        course1.put("duration", "3 months");
        course1.put("fees", 5800); 

        courses.add(course1);

        // Adding courses to student data
        studentData.put("courses", courses);
        given()
        
        .when()
        	.post("http://localhost:3000/students")
        	
        .then()
        	.statusCode(201)
        	.contentType("application/json")
        	.log().all();
	}
	@Test
	void deletejsonuser()
	{
		given()
		
		.when()
			.delete("http://localhost:3000/students/aed4")
		.then()
			.statusCode(200);
			
	}
	
	//POJO request body using POJO Class;
	//@Test(priority = 1)
	void testPOJO()
	{
		POJO_Request data=new POJO_Request();
		data.setUsn("4AL21CS037");
		data.setName("Deepak");
		data.setGender("Male");
		data.setSemester(8);
        ArrayList<Map<String, Object>> courses = new ArrayList<Map<String, Object>>();

        Map<String, Object> course1 = new HashMap<String, Object>();
        course1.put("course_no", "CS101");
        course1.put("course_name", "Database");
        course1.put("duration", "3 months");
        course1.put("fees", 5800); 
        
        courses.add(course1);
        data.setCourses(courses);
        
		
       
        given()
            .contentType("application/json")
            .body(data)
        .when()
            .post("http://localhost:3000/students")
        .then()
            .statusCode(201)
            .body("name", equalTo("Ebenezer Mathew"))
            .body("semester", equalTo(8))
            .log().all();
    }
	//@Test
	void deletepojouser()
	{
		given()
		
		.when()
			.delete("http://localhost:3000/students/d822")
		.then()
			.statusCode(200);
			
	}
	@Test(priority=0)
	//Post request body with External JSON File
	void testpostusingexternalfile() throws FileNotFoundException
	{

        File f=new File(".\\body.json");
        
        FileReader fr=new FileReader(f);
        
        JSONTokener jt=new JSONTokener(fr);
        JSONObject data=new JSONObject(jt);
		
       
        given()
            .contentType("application/json")
            .body(data.toString())
        .when()
            .post("http://localhost:3000/students")
        .then()
            .statusCode(201)
            .body("name", equalTo("Ebenezer Mathew"))
            .body("semester", equalTo(8))
            .log().all();
    }
	
	
	}

