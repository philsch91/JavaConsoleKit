/*
 * The MIT License
 *
 * Copyright 2019 Philipp Schunker.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.schunker.java;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author Philipp Schunker
 */
public class MenuTest {
    
    public MenuTest() {
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
     * Test of getTitle method, of class Menu.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        Menu instance = new Menu();
        instance.setTitle("MenuTitle");
        String expResult = "MenuTitle";
        String result = instance.getTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setTitle method, of class Menu.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "MenuTitle";
        Menu instance = new Menu();
        instance.setTitle(title);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getEntries method, of class Menu.
     */
    @Test
    public void testGetEntries() {
        System.out.println("getEntries");
        Menu instance = new Menu();
        instance.insert("entry1");
        instance.insert("entry2");
        ArrayList<String> expResult = new ArrayList<String>(Arrays.asList("entry1","entry2"));
        ArrayList<String> result = instance.getEntries();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setEntries method, of class Menu.
     */
    @Test
    public void testSetEntries() {
        System.out.println("setEntries");
        ArrayList<String> entries = new ArrayList<String>(Arrays.asList("entry1","entry2"));
        Menu instance = new Menu();
        instance.setEntries(entries);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class Menu.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        String text = "entry1";
        Menu instance = new Menu();
        int expResult = 1;
        int result = instance.insert(text);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class Menu.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        int index = 0;
        Menu instance = new Menu();
        instance.setEntries(new ArrayList<String>(Arrays.asList("entry1","entry2")));
        int expResult = 1;
        int result = instance.remove(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of show method, of class Menu.
     */
    @Test
    public void testShow() {
        System.out.println("show");
        Menu instance = new Menu();
        instance.setTitle("Title");
        instance.setEntries(new ArrayList<String>(Arrays.asList("Stocks","Depot")));
        
        InputStream testInput = new ByteArrayInputStream("2".getBytes());
        InputStream initInput = System.in;
        
        int result;
        
        try{
            System.setIn(testInput);
            result = instance.show();
        } finally {
            System.setIn(initInput);
        }
        
        int expResult = 2;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
