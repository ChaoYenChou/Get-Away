/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ca.sheridancollege.project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jiveshmalhotra
 */
public class PokerCardTest {
    
    public PokerCardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class PokerCard.
     */
    

    /**
     * Test of isValidSuit method, of class PokerCard.
     */
    @Test
    public void testIsValidSuitGood() {
        System.out.println("isValidSuit");
        String input = "HEARTS";
        boolean expResult = true;
        boolean result = PokerCard.isValidSuit(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testIsValidSuitBad() {
        System.out.println("isNotValidSuit");
        String input = "CLUBS";
        boolean expResult = false;
        boolean result = PokerCard.isValidSuit(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testIsValidSuitBoundary() {
        System.out.println("isNotValidSuit");
        String input = "";
        boolean expResult = false;
        boolean result = PokerCard.isValidSuit(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of isValidValue method, of class PokerCard.
     */
    @Test
    public void testIsValidValueGood() {
        System.out.println("isValidValue");
        String input = "TWO";
        boolean expResult = true;
        boolean result = PokerCard.isValidValue(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testIsValidValueBad() {
        System.out.println("isNotValidValue");
        String input = "FIVE";
        boolean expResult = false;
        boolean result = PokerCard.isValidValue(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testIsValidValueBounday() {
        System.out.println("isNotValidValue");
        String input = "";
        boolean expResult = false;
        boolean result = PokerCard.isValidValue(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
}
