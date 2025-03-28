package main.najah.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import main.najah.code.Product;

@DisplayName("Product Tests")
public class ProductTest {
    Product p;
    

    @BeforeAll
	public static void beforeAllMethods(){
		System.out.println("Before Product Tests Class ");
	}
	@AfterAll
	public static void atferAllMethods(){
		System.out.println("After Product Tests Class ");
	}
	 @BeforeEach
	    public void beforeEachMethod(){
	        System.out.println("Before Product Tests Method ");
	    }
	 @AfterEach
	    public void afterEachMethod(){
	        System.out.println("After Product Tests Method");
	    }

    Product p1=new Product("Milk", 10);
    @Test
    @DisplayName("Test The Product Constructor With Positive Price ")
    
	void testProductConstructor() {
    	
    	assertEquals(10,p1.getPrice());
    	assertEquals("Milk",p1.getName());
   		
}
			    

@Test
@DisplayName("Test The Product Constructor With Negative Price ")
void testProductConstructorWithNegativePrice() {
	
	
   		assertThrows(IllegalArgumentException.class, ()->new Product("Milk", -10));
   		}
   
	

    
    @ParameterizedTest
    @ValueSource(doubles= {25,20.5})
    @DisplayName("Test The Product Discount With Valid Discount")
    @Timeout(value = 200,unit = TimeUnit.MILLISECONDS)
    void testApplyDiscountValidDiscount(double discount)	{
    	
    		p1.applyDiscount(discount);
    	 	assertEquals(discount,p1.getDiscount());
    
	}
    @ParameterizedTest
    @ValueSource(doubles= {-40,60})
    @DisplayName("Test The Product Discount With Invalid Discount")
    void testApplyDiscountInvalidDiscount(double discount)	{
    	
   		 assertThrows(IllegalArgumentException.class,()->p1.applyDiscount(discount));
      
	}

    @Test
    @DisplayName("Test The Product Final Price")
    void testFinalPrice()	{
    	p1.applyDiscount(25);
    	assertEquals(7.5,p1.getFinalPrice());
      
	}
    
    @Test
    @DisplayName("Test The Product Constructor With Invalid Input ")
    @Timeout(value = 200,unit = TimeUnit.MILLISECONDS)
    @Disabled
	void testProductConstructorInvalid() {
    	Product p2=new Product(123, "Invalid");//We should put the string first and the integer in second
    	assertEquals("Invalid",p2.getPrice());
    	assertEquals(123,p2.getName());
   		
}
    
    
    
    @ParameterizedTest
    @ValueSource(doubles= {"Invalid",""})//We should put the string first and the integer in second
    @DisplayName("Test The Product Discount With Invalid Input")
    @Disabled
    void testApplyDiscountInValidInput(double discount)	{
    	
    		p1.applyDiscount(discount);
    	 	assertEquals(discount,p1.getDiscount());
    
	}

    @Test
    @DisplayName("Test The Product With Invalid Final Price")
    @Disabled
    void testFinalPriceInValidInput()	{
    	p1.applyDiscount("Ivalid");//We should put integer in parameter
    	assertEquals(7.5,p1.getFinalPrice());
      
	}
}









