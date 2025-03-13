package restassured_day4;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class Faker_Library {
	@Test
	void genereatefakedate()
	{
		Faker fake=new Faker();
		String FullName=fake.name().fullName();
		String First_name=fake.name().firstName();
		String password=fake.internet().password();
		String email=fake.internet().safeEmailAddress();
		String phonenumber=fake.phoneNumber().cellPhone();
		String username=fake.name().username();
		
		System.out.println("Full Name :"+FullName);
		System.out.println("First Name :"+First_name);
		System.out.println("password "+password);
		System.out.println("Email "+email);
		System.out.println("phone "+phonenumber);
		System.out.println("username "+username);
		
		
	}

}
