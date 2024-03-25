package org.mps.deque;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LinkedNodeTest {

    @Test
    @DisplayName("Testing constructor")
    void test_Constructor_CorrectValues(){
        Integer item = 10;
        LinkedNode<Integer> previous = new LinkedNode<>(5, null, null);
        LinkedNode<Integer> next = new LinkedNode<>(15, null, null);

        LinkedNode<Integer> node = new LinkedNode<>(item, previous, next);

        assertEquals(item, node.getItem());
        assertEquals(previous, node.getPrevious());
        assertEquals(next, node.getNext());
    }

    @Nested
    @DisplayName("Testing getters and setters")
    class GettersSettersTest{
        @Test
        @DisplayName("Testing getItem")
        void test_getItem_ItemValue(){
            Integer item = 10;
            LinkedNode<Integer> previous = new LinkedNode<>(5, null, null);
            LinkedNode<Integer> next = new LinkedNode<>(15, null, null);
            LinkedNode<Integer> node = new LinkedNode<>(item, previous, next);
            int expectedItem = 10;
            
            int actualItem = node.getItem();
    
            assertEquals(expectedItem, actualItem);
        }
    
        @Test
        @DisplayName("Testing setItem")
        void test_setItem_ItemValue(){
            Integer item = 10;
            LinkedNode<Integer> previous = new LinkedNode<>(5, null, null);
            LinkedNode<Integer> next = new LinkedNode<>(15, null, null);
            LinkedNode<Integer> node = new LinkedNode<>(item, previous, next);
            int expectedItem = 30;
            
            node.setItem(30);
            int actualItem = node.getItem();
            
    
            assertEquals(expectedItem, actualItem);
        }
    
        @Test
        @DisplayName("Testing getPrevious")
        void test_getPrevious_NextNode(){
            Integer item = 10;
            LinkedNode<Integer> previous = new LinkedNode<>(5, null, null);
            LinkedNode<Integer> next = new LinkedNode<>(15, null, null);
            LinkedNode<Integer> node = new LinkedNode<>(item, previous, next);
            LinkedNode<Integer> expectedNext = next;
    
            LinkedNode<Integer> actualNext = node.getNext();
    
            assertEquals(expectedNext, actualNext);
        }
    
        @Test
        @DisplayName("Testing setPrevious")
        void test_setPrevious_NextNode(){
            Integer item = 10;
            LinkedNode<Integer> previous = new LinkedNode<>(5, null, null);
            LinkedNode<Integer> next = new LinkedNode<>(15, null, null);
            LinkedNode<Integer> node = new LinkedNode<>(item, previous, next);
            LinkedNode<Integer> expectedNext = new LinkedNode<>(30, null, null);
    
            node.setPrevious(expectedNext);
            LinkedNode<Integer> actualPrevious = node.getPrevious();
    
            assertEquals(expectedNext, actualPrevious);
        }

        @Test
        @DisplayName("Testing getNext")
        void test_getNext_NextNode(){
            Integer item = 10;
            LinkedNode<Integer> previous = new LinkedNode<>(5, null, null);
            LinkedNode<Integer> next = new LinkedNode<>(15, null, null);
            LinkedNode<Integer> node = new LinkedNode<>(item, previous, next);
            
            LinkedNode<Integer> expectedNext = next;
            LinkedNode<Integer> actualNext = node.getNext();
    
            assertEquals(expectedNext, actualNext);
        }

        @Test
        @DisplayName("Testing setNext")
        void test_setNext_NextNode(){
            Integer item = 10;
            LinkedNode<Integer> previous = new LinkedNode<>(5, null, null);
            LinkedNode<Integer> next = new LinkedNode<>(15, null, null);
            LinkedNode<Integer> node = new LinkedNode<>(item, previous, next);
            LinkedNode<Integer> expectedNext = new LinkedNode<>(30, null, null);
    
            node.setNext(expectedNext);
            LinkedNode<Integer> actualNext = node.getNext();
    
            assertEquals(expectedNext, actualNext);
        }
    }

    @Nested
    @DisplayName("Testing terminal nodes")
    class test_TerminalNodes{
        @Test
        @DisplayName("Testing isFirstNode")
        void test_isFirstNode_ReturnTrue(){
            Integer item = 10;
            LinkedNode<Integer> previous = null;
            LinkedNode<Integer> next = new LinkedNode<>(15, null, null);
            LinkedNode<Integer> node = new LinkedNode<>(item, previous, next);
    
            boolean expected = true;
            boolean actual = node.isFirstNode();
    
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Testing isLastNode")
        void test_isLastNode_ReturnTrue(){
            Integer item = 10;
            LinkedNode<Integer> previous = new LinkedNode<>(5, null, null);
            LinkedNode<Integer> next = null;
            LinkedNode<Integer> node = new LinkedNode<>(item, previous, next);
    
            boolean expected = true;
            boolean actual = node.isLastNode();
    
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Testing isNotATerminalNode")
        void test_isNotATerminalNode_ReturnTrue(){
            Integer item = 10;
            LinkedNode<Integer> previous = new LinkedNode<>(5, null, null);
            LinkedNode<Integer> next = new LinkedNode<>(15, null, null);
            LinkedNode<Integer> node = new LinkedNode<>(item, previous, next);
    
            boolean expected = true;
            boolean actual = node.isNotATerminalNode();
    
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Testing isNotATerminalNode")
        void test_isNotATerminalNode_ReturnFalse(){
            Integer item = 10;
            LinkedNode<Integer> previous = null;
            LinkedNode<Integer> next = null;
            LinkedNode<Integer> node = new LinkedNode<>(item, previous, next);
    
            boolean expected = false;
            boolean actual = node.isNotATerminalNode();
    
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Testing isNotATerminalNode")
        void test_isNotATerminalNode_ReturnFalse2(){
            Integer item = 10;
            LinkedNode<Integer> previous = new LinkedNode<>(5, null, null);
            LinkedNode<Integer> next = null;
            LinkedNode<Integer> node = new LinkedNode<>(item, previous, next);
    
            boolean expected = false;
            boolean actual = node.isNotATerminalNode();
    
            assertEquals(expected, actual);
        }
    }
}
