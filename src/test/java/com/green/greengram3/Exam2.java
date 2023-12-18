package com.green.greengram3;

import org.junit.jupiter.api.*;

public class Exam2 {
    @AfterAll
    public static void afterAll(){
        System.out.println("afterAll");
    }
    @BeforeAll
    public static void beforeAll(){
        System.out.println("beforeAll");
    }
    @AfterEach
    public void afterEach(){
        System.out.println("afterEach");
    }
    @BeforeEach
    public void beforeEach(){
        System.out.println("beforeEach");
    }
    @Test
    public void test1(){
        Assertions.assertEquals(1,1);
        System.out.println("test1");
    }
    @Test
    public void test2(){
        System.out.println("test2");
    }
}
