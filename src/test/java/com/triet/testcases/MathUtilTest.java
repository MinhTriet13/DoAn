package com.triet.testcases;

import com.dev.triet.ultilities.MathUtil;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class MathUtilTest {
    MathUtil mathUtil =  new MathUtil();

    @Test
    void test1(){
        assertEquals(mathUtil.sum(1,1), 2);
    }

    @Test
    void test2(){
        assertEquals(mathUtil.sum(1,1), 3);
    }

    @Test
    void test3(){
        assertEquals(mathUtil.sum(1,2), 3);
    }
}
