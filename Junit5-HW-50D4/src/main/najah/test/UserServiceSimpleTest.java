package main.najah.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.Suite;
import org.junit.runners.Suite.SuiteClasses;

import main.najah.code.UserService;



@DisplayName("User Service Tests")	
class UserServiceSimpleTest {

	@BeforeAll
	public static void beforeAllMethods(){
		System.out.println("Before User Service  Class");
	}
	@AfterAll
	public static void atferAllMethods(){
		System.out.println("After User Service  Class ");
	}
	 @BeforeEach
	    public void beforeEachMethod(){
	        System.out.println("Before User Service Tests Method ");
	    }
	 @AfterEach
	    public void afterEachMethod(){
	        System.out.println("After User Service Tests Method");
	    }
	UserService User=new UserService();
	 @ParameterizedTest
	    @CsvSource({
	    	"elyas@hotmail.co,m",
	    	"e@h.c",
	    	"1@2.3",
	    	"saghidgsasadoadsasdasdawdujhawoi@asdwadwadwadaw.dwaadadwdawdawd"
	    })
	 
    @DisplayName("Test If The Email Is Valid ")
    @Timeout(value = 200,unit = TimeUnit.MILLISECONDS)
	void testValidEmail(String email) {
    
    	assertEquals(true,User.isValidEmail(email));

}
	 
	 
	 @ParameterizedTest
	    @CsvSource({
	    	"elyas@hotmailcom",
	    	"elyas.siksik",
	    	"ely,,as@hotmail.com",
	    	"1@23",
	    	"52.41",
	    	",",
	    	
	    })
 @DisplayName("Test If The Email Is Invalid ")
 
	void testInvalidEmail(String email) {
 
 	assertEquals(false,User.isValidEmail(email));

}
	 
	 
 @Test
 @DisplayName("Test If The Authenticate Is Valid")
 
	void testAuthenticateVaild() {
 
 	assertEquals(true,User.authenticate("admin","1234"));

	 }
 
 
 
 @ParameterizedTest
 
 @CsvSource({
 	"elyas,123",
 	"elyas,siksik",
 	"412,elyas",
 	",",
 	"1,12",
 	

 	
 })

 @DisplayName("Test If The Authenticate Is Invalid")
 
	void testAuthenticateInvaild(String username, String password) {
	 
 	assertEquals(false,User.authenticate(username,password));

	 
}

}


