package com.nc.edu.ta.AlexandrNenashev.pr2.tests;

import com.nc.edu.ta.AlexandrNenashev.pr2.*;

import org.junit.*;
import static org.junit.Assert.*;

public class TaskTestPartial {

    @BeforeClass
    public static void testDescription() {
        System.out.println("--- description test ---");
        Task task = new Task("Inactive repeated", 10, 100, 5);
        System.out.println(task.toString());
        task = new Task("Active one-time", 50);
        task.setActive(true);
        System.out.println(task.toString());
        System.out.println("------------------------");
    }

    @Test
    public void testTitle() {
        Task task = new Task("test", 0);
        assertEquals("test", task.getTitle());
        task.setTitle("other");
        assertEquals("other", task.getTitle());
    }
    @Test
    public void testActive() {
        Task task = new Task("test", 0);
        assertFalse(task.isActive());
        task.setActive(true);
        assertTrue(task.isActive());
    }
    @Test/*HZ*/
    public void testConstructorNonrepeated() {
        Task task = new Task("test", 10);
        assertFalse("active", task.isActive());
        assertEquals("time", 10, task.getTime());
        assertEquals("start", 10, task.getStartTime());
        assertEquals("end", 10, task.getEndTime());
        assertFalse("repeated", task.isRepeated());
    }
    @Test
    public void testConstructorRepeated() {
        Task task = new Task("test", 10, 100, 5);
        assertFalse("active", task.isActive());
        assertEquals("time", 10, task.getTime());
        assertEquals("start", 10, task.getStartTime());
        assertEquals("end", 100, task.getEndTime());
        assertTrue("repeated", task.isRepeated());
        assertEquals("repeatInterval", 5, task.getRepeatInterval());
    }
    @Test
    public void testTimeNonRepeated() {
        Task task = new Task("test", 0, 100, 15);
        task.setTime(50);
        assertEquals("time", 50, task.getTime());
        assertEquals("start", 50, task.getStartTime());
        assertEquals("end", 50, task.getEndTime());
        assertFalse("repeated", task.isRepeated());
    }
    @Test
    public void testTimeRepeated() {
        Task task = new Task("test", 10);
        task.setTime(5, 20, 1);
        assertEquals("time", 5, task.getTime());
        assertEquals("start", 5, task.getStartTime());
        assertEquals("end", 20, task.getEndTime());
        assertTrue("repeated", task.isRepeated());
        assertEquals("repeatInterval", 1, task.getRepeatInterval());
    }
	
	/**Additional method*/
    @Test
    public void testToStringNonRepeative() {
        Task task = new Task("some", 10);
        task.setActive(false);
        assertEquals("Task \"some\" is inactive", task.toString());
		task.setActive(true);
        assertEquals("Task \"some\" at 10", task.toString());
    }
	
	/**Additional method*/
    @Test
    public void testToStringRepeative() {
        Task task = new Task("some", 10, 100, 20);
        task.setActive(false);
        assertEquals("Task \"some\" is inactive", task.toString());
		task.setActive(true);
        assertEquals("Task \"some\" from 10 to 100 every 20 seconds", task.toString());
    }
}










