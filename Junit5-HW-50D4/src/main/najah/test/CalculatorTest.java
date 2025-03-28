package main.najah.test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import main.najah.code.Calculator;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Calculator Tests")
public class CalculatorTest {
	
	
    Calculator calc=new Calculator();
    @Order(1)
    @ParameterizedTest
    @CsvSource({
    	"1,2,3",
    	"-2,-4,-6",
    	"5,-1,4",
    	"-8,1,-7",
    	"1,-1,0",
    	"0,0,0",
    	
    })

    @DisplayName("Test The Add Method In Calculator With Valid Input")
    @Timeout(value = 200,unit = TimeUnit.MILLISECONDS)
    void testAddMehtoodValid (int a, int b,int expected) {
  
    	assertEquals(expected,calc.add(a,b));
    } 
    
    
    
    
    @Order(2)
    @ParameterizedTest
    @CsvSource({
    	"1.5,2,3.5",
    	"-2.6,-4,-6.6",
    	"10000000000,1,10000000001",
    	",,",
    	"sad,dsa,fasd"
    })
    
    @DisplayName("Test The Add Method In Calculator With Invalid Input")
    @Disabled
    void testAddMehtodInvalid (int a, int b,int expected) {
    	
    	assertEquals(expected,calc.add(a,b));
    } 
    
    
    
    
    
    @Order(3)
    @ParameterizedTest
    @CsvSource({
    	"4,2,2",
    	"2,2,1",
    	"-10,-2,5",
    	"-8,8,-1",
    	"0,-1,0",
    	
    	
    })
    
    @DisplayName("Test The Divide Method In Calculator With Valid Input")
    void testDivideMethodValid (int a, int b,int expected) {	
    	 
           
            	assertEquals(expected,calc.divide(a,b));
    
    }
    @Order(4)
    @Test
    @DisplayName("Test The Divide Method In Calculator With Division By Zero")
    void testDivideMethodWithZero () {	
   	 
        
    	assertThrows(ArithmeticException.class, () -> calc.divide(2,0));
        

}
    
    @Order(5)
    @ParameterizedTest
    @CsvSource({
    	"3.5,1,3.5",
    	"-10,2.5,-4",
   	    "-9.5,-3.5,3",
   	      ",,",
   	   "10000000000,1,10000000000",
   	   "sad,dsa,fasd"
    })
   
   @DisplayName("Test The Divide Method In Calculator With Invalid Input")
    @Disabled
    void testDivideMehtodInvalid (int a, int b,int expected) {
    	
    	assertEquals(expected,calc.divide(a,b));
    } 
 
    
    
    
    
    
    @Order(6)
    @ParameterizedTest
    @CsvSource({
    	"4,24",
    	"6,720",
    	"1,1",
    	"0,1",
    	
    })

    @DisplayName("Test The Factorial Method In Calculator With Valid Input")
    void testFactorialMehtodValid (int a,int expected) {
    	
    	assertEquals(expected,calc.factorial(a));
    } 
    
    
    @Order(7)
    @Test
    @DisplayName("Test The Factorial Method In Calculator With Nigatvie Input")
    void testFactorialMehtodValid () {
    	
    	assertThrows(IllegalArgumentException.class, ()->calc.factorial(-10));
    } 
    
     
		
    @Order(8)
    @ParameterizedTest
    @CsvSource({
    	
    	"4.5,24",
    	"20,2432902008176640000",
    	"sad,dsa"
    })

    @DisplayName("Test The Factorial Method In Calculator With Invalid Input")
    @Disabled
    void testFactorialMehtodInvalid (int a,int expected) {
  
    	assertEquals(expected,calc.factorial(a));
    	
    } 
    
    
    
 

	

}
