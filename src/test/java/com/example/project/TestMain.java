package com.example.project;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestMain{

    @Test
    public void testInsertAfterI(){
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list,"this", "is", "not", "a", "trivial", "task", "right?");
        ArrayList<String> expected = new ArrayList<>();
        Collections.addAll(expected,"this", "bob","is","bob","not", "a", "trivial", "bob","task", "right?", "bob" );
        assertEquals(expected, Main.insertAfterI(list, "bob"));
    }
    @Test
    public void testRemove3(){
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("the", "not", "skim", "pat", "a", "rat", "cat", "sit", "truck", "par", "tar"));
        ArrayList<String> expected = new ArrayList<String>(Arrays.asList("skim","a","truck"));
        assertEquals(expected, Main.removeThree(list));
    }

    @Test
    public void testReverseArray(){
        int[] intList = {1, 2, 3, 4, 5, 6, 7};
        ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(7,6,5,4,3,2,1));
        assertEquals(expected, Main.reverseArray(intList));
    }

    @Test
    public void testSameFirstLast(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        assertEquals(false,Main.sameFirstLast(list));
        list.add(1);list.add(2);list.add(3);
        assertEquals(false,Main.sameFirstLast(list));
        list.add(1);
        assertEquals(true,Main.sameFirstLast(list));
        list.clear(); list.add(1);list.add(2);list.add(1);
        assertEquals(true,Main.sameFirstLast(list));
    }

    @Test
      // swapEnds([1, 2, 3, 4]) → [4, 2, 3, 1]
    // swapEnds([1, 2, 3]) → [3, 2, 1]
    // swapEnds([8, 6, 7, 9, 5]) → [5, 6, 7, 9, 8]
    // swapEnds([]->[])+
    public void testSwapEnds(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, 1,2,3,4);
        ArrayList<Integer> expected = new ArrayList<Integer>();
        Collections.addAll(expected,4,2,3,1);
        assertEquals(expected,Main.swapEnds(list));
        list.clear();
        Collections.addAll(list,8,6,7,9,5);
        expected.clear();
        Collections.addAll(expected,5,6,7,9,8);
        assertEquals(expected,Main.swapEnds(list));
        list.clear();expected.clear();
        assertEquals(expected,Main.swapEnds(list));
    }

    // zeroFront([1, 0, 0, 1]) → [0, 0, 1, 1]
    // zeroFront([0, 1, 1, 0, 1]) → [0, 0, 1, 1, 1]
    // zeroFront([1, 0]) → [0, 1]
    @Test
    public void testZeroFront(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list,1,0,0,1);
        ArrayList<Integer> expected = new ArrayList<>();
        Collections.addAll(expected,0,0,1,1);
        assertEquals(expected,Main.zeroFront(list));
        list.clear();expected.clear();

        Collections.addAll(list,0,1,1,0,1);
        Collections.addAll(expected,0,0,1,1,1);
        assertEquals(expected,Main.zeroFront(list));
        list.clear();expected.clear();

        Collections.addAll(list,1,0);
        Collections.addAll(expected,0,1);

        assertEquals(expected,Main.zeroFront(list));
 
    }

    // notAlone([1, 2, 3], 2) → [1, 3, 3]
    // notAlone([1, 2, 3, 2, 5, 2], 2) → [1, 3, 3, 5, 5, 2]
    // notAlone([3, 4], 3) → [3, 3]
    @Test
    public void testNotAlone(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list,1,2,3);
        ArrayList<Integer> expected = new ArrayList<>();
        Collections.addAll(expected,1,3,3);
        assertEquals(expected,Main.notAlone(list,2));

        list.clear();expected.clear();
        Collections.addAll(list, 1,2,3,2,5,2);
        Collections.addAll(expected,1,3,3,5,5,5);
     
        list.clear();expected.clear();
        Collections.addAll(list, 3,4);
        Collections.addAll(expected,4,4);
        assertEquals(expected,Main.notAlone(list,3));

        list.clear();expected.clear();
        Collections.addAll(list, 4,3,4,4);
        Collections.addAll(expected,3,3,4,4);
        assertEquals(expected,Main.notAlone(list,4));
    }

    // shiftLeft([6, 2, 5, 3]) → [2, 5, 3, 6]
    // shiftLeft([1, 2]) → [2, 1]
    // shiftLeft([1]) → [1]
    @Test
    public void TestShiftLeft(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list,6,2,5,3);
        ArrayList<Integer> expected = new ArrayList<>();
        Collections.addAll(expected,2,5,3,6);
        assertEquals(expected,Main.shiftLeft(list));
        list.clear();expected.clear();

        Collections.addAll(list,1,2);
        Collections.addAll(expected,2,1);
        assertEquals(expected,Main.shiftLeft(list));
        list.clear();expected.clear();

        Collections.addAll(list,1);
        Collections.addAll(expected,1);
        assertEquals(expected,Main.shiftLeft(list));
    }

    // fix34([1, 3, 1, 4]) → [1, 3, 4, 1]
    // fix34([1, 3, 1, 4, 4, 3, 1]) → [1, 3, 4, 1, 1, 3, 4]
    // fix34([3, 2, 2, 4]) → [3, 4, 2, 2]

    //@Test
    public void testFix34(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list,1,3,1,4);
        ArrayList<Integer> expected = new ArrayList<>();
        Collections.addAll(expected,1,3,4,1);
        assertEquals(expected,Main.fix34(list));
        list.clear();expected.clear();

        Collections.addAll(list,1, 3, 1, 4, 4, 3, 1);
        Collections.addAll(expected,1, 3, 4, 1, 1, 3, 4);
        assertEquals(expected,Main.fix34(list));
        list.clear();expected.clear();
    }

    
}