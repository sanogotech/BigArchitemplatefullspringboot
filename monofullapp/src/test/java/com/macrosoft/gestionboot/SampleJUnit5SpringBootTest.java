package com.macrosoft.gestionboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.macrosoft.gestionboot.service.customer.CustomerService;

@DisplayName("Junit Sample ")
@SpringBootTest
public class SampleJUnit5SpringBootTest {
	
	@Autowired
	CustomerService customerService;
	
	//0
	 @Test
     @DisplayName("Should be true")
     public void shouldBeTrue() {
          assertTrue(true);
      }
	 
	 //2
	 @DisplayName("Test Spring @Autowired Integration")
	    @Test
	    void testGet() {
	        assertTrue(customerService.findByName("ZASSSSBS").isEmpty());
	    }
	
	//3
	@Nested
    @DisplayName("When boolean is true")
    class WhenBooleanIsTrue {
 
        @Test
        @DisplayName("Should be true")
        void shouldBeTrue() {
            assertTrue(true);
        }
    }
	
	
	//4
    @Nested
    @DisplayName("When two objects are equal")
    class WhenTwoObjectsAreEqual {
 
        @Nested
        @DisplayName("When objects are integers")
        class WhenObjectsAreIntegers {
 
            private final Integer ACTUAL = 9;
            private final Integer EXPECTED = 9;
 
            @Test
            @DisplayName("Should be equal")
            void shouldBeEqual() {
                assertEquals(EXPECTED, ACTUAL);
            }
        }
    }

}
