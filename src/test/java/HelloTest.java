import facade.Hello;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloTest {

    Hello hello;
    @BeforeEach
    void setUp() {
        hello = new Hello();

    }

    @AfterEach
    void tearDown() {
    }

    String name = "Helge";

    @Test
    public void testHello(){
        System.out.println("Method to say hello");
        String actual = hello.sayHello(name);
        String expected = "Hello, " + name+".";
        assertEquals(expected,actual);

    }

    @Test
    public void testHelloNull(){
        System.out.println("Method to test for null");
        String actual = hello.sayHello(null);
        String expected = "Hello, my friend." ;
        assertEquals(expected,actual);
    }

    @Test
    public void testHelloShouting(){
        System.out.println("Method to handle shouting");
        String actual = hello.sayHello(name.toUpperCase());
        String expected = "Hello, " + name.toUpperCase()+"!"; ;
        assertEquals(expected,actual);
    }

    @Test
    public void testHelloArray(){
        System.out.println("Method to handle array of two names");
        String[] arr = {"Jill","Jane"};
        String actual = hello.sayHello(arr);
        String expected = "Hello, Jill and Jane." ;
        assertEquals(expected,actual);
    }
    @Test
    public void testHelloArbArray(){
        System.out.println("Method to handle array of any number of names");
        String[] arr = {"Jill","Jane", "Jack", "Julie"};
        String actual = hello.sayHello(arr);
        String expected = "Hello, Jill, Jane, Jack, and Julie." ;
        assertEquals(expected,actual);
    }

    @Test
    public void testHelloMixedArray(){
        System.out.println("Method to handle array of any number of names some With upperCase");
        String[] arr = {"Amy", "BRIAN", "Charlotte"};
        String actual = hello.sayHello(arr);
        String expected = "Hello, Amy and Charlotte. AND HELLO BRIAN!" ;
        assertEquals(expected,actual);
    }

    @Test
    public void testHelloStringWithComma(){
        System.out.println("Method to handle a string with multiple names and commas in string");
        String[] name = {"Amy", "BRIAN,Charlotte"};
        String actual = hello.sayHello(name);
        String expected = "Hello, Amy and Charlotte. AND HELLO BRIAN!" ;
        assertEquals(expected,actual);
    }

    @Test
    public void testHelloStringWithIntentionalComma(){
        System.out.println("Method to handle a string with multiple names and intentional commas in string");
        String[] name = {"Bob", "\"Charlie, Dianne\""};
        String actual = hello.sayHello(name);
        String expected = "Hello, Bob and Charlie, Dianne." ;
        assertEquals(expected,actual);
    }


}
