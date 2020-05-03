package com.macrosoft.gestionboot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

//@SpringBootTest
public class HelloServiceMockTest {
	/*
	 https://blog.codecentric.de/en/2017/09/given-when-then-in-junit-tests/
	Preparation -> Given
	
	Execution -> When
	
	
	Verification -> Then
	*/

	/*
    @Mock
    private HelloRepository helloRepository;

    @InjectMocks // auto inject helloRepository
    private HelloService helloService = new HelloServiceImpl();

    @BeforeEach
    void setMockOutput() {
        when(helloRepository.get()).thenReturn("Hello Mockito From Repository");
    }

    @DisplayName("Test Mock helloService + helloRepository")
    @Test
    void testGet() {
        assertEquals("Hello Mockito From Repository", helloService.get());
    }
	
	*/
	
	
	/**
	  * If an item is loaded from the repository, the name of that item should 
	  * be transformed into uppercase.
	  */
	/*
	@Test
	public void shouldReturnItemNameInUpperCase() {
	 
	    //
	    // Given
	    //
	    Item mockedItem = new Item("it1", "Item 1", "This is item 1", 2000, true);
	    when(itemRepository.findById("it1")).thenReturn(mockedItem);
	 
	    //
	    // When
	    //
	    String result = itemService.getItemNameUpperCase("it1");
	 
	    //
	    // Then
	    //
	    verify(itemRepository, times(1)).findById("it1");
	    assertThat(result, is("ITEM 1"));
	}
	*/
}