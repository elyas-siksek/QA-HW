package main.najah.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import main.najah.code.UserService;
@Execution(value = ExecutionMode.CONCURRENT)
//AFTER Without Execution 0.223       AFTER With Execution 0.157

class TestParallelExec {
	
	
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
