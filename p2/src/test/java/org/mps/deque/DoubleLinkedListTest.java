package org.mps.deque;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class DoubleLinkedListTest {
    DoubleLinkedList<Integer> list;

    @BeforeEach
    void setUp(){
        list = new DoubleLinkedList<>();
    }

    @Test
    @DisplayName("Testing constructor")
    void test_Constructor_ReturnSize0(){
        DoubleLinkedList<Integer> listConst = new DoubleLinkedList<>();
        
        int size = listConst.size();
        
        assertEquals(0, size);
    }

   @Nested
   @DisplayName("testing adding elements")
   class AddElementsTest{
    
    @Test
    @DisplayName("Testing prepend first node")
    void test_PrependEmpty_ReturnSize1_FirstValue(){
        list.prepend(1);
        
        int size = list.size();
        int first = list.first();
        
        assertEquals(1, size);
        assertEquals(1, first);
    }

    @Test
    @DisplayName("Testing prepend other values")
    void test_PrependOther_ReturnSize2_LastValue(){
        list.prepend(1);
        list.prepend(2);
        
        int size = list.size();
        int first = list.first();
        
        assertEquals(2, size);
        assertEquals(2, first);
    }

    @Test
    @DisplayName("Testing adding one element in the back")
    void test_AppendEmpty_Returnsize1_LastValue() {
        list.append(1);

        int expectedValue = 1;
        int expectedSize = 1;

        assertEquals(expectedValue, list.last());
        assertEquals(expectedSize, list.size());
    }

    @Test
    @DisplayName("Testing adding two elements in the back")
    void test_AppendWithElements_Returnsize1_LastValue() {
        list.append(1);
        list.append(2);

        int expectedValue = 2;
        int expectedSize = 2;

        assertEquals(expectedValue, list.last());
        assertEquals(expectedSize, list.size());
    }
   }

   @Nested
   @DisplayName("testing deleting elements")
    class DeleteElementsTest{
     
     @Test
     @DisplayName("Testing deleteFirst with two elements")
     void test_DeleteFirstTwoElements_ReturnSize1_FirstValue(){
          list.append(1);
          list.append(2);
          list.deleteFirst();
          
          int size = list.size();
          int first = list.first();
          
          assertEquals(1, size);
          assertEquals(2, first);
     }

     @Test
     @DisplayName("Testing deleteFirst with one elements")
        void test_DeleteFirstOneElement_ReturnSize0(){
            list.append(1);
            list.deleteFirst();
            
            int size = list.size();
            
            assertEquals(0, size);
        }

        @Test
        @DisplayName("Testing deleteFirst with no elements")
        void test_DeleteFirstNoElements_ThrowsDoubleLinkedQueueException(){
            assertThrows(DoubleLinkedQueueException.class, () -> list.deleteFirst());
        }  
        
        @Test
        @DisplayName("Testing deleting last on an empty list")
        void test_DeleteLastEmpty_ReturnException() {

            assertThrows(DoubleLinkedQueueException.class, () -> {
                list.deleteLast();
            });
        }

        @Test
        @DisplayName("Testing deleting last on an one element list")
        void test_DeleteLastWithOneElement_Returnsize0_LastValueNull() {
            list.append(1);
            list.deleteLast();

            int expectedSize = 0;

            assertEquals(expectedSize, list.size());
        }

        @Test
        @DisplayName("Testing deleting last on a more than one element list")
        void test_DeleteLastWithMoreElementa_Returnsize1_LastValue() {
            list.append(1);
            list.append(2);
            list.deleteLast();

            int expectedValue = 1;
            int expectedSize = 1;

            assertEquals(expectedValue, list.last());
            assertEquals(expectedSize, list.size());
        }
    }

    @Nested
    @DisplayName("testing getting elements")
    class GetElementsTest{
     
     @Test
     @DisplayName("Testing first with one element")
     void test_FirstOneElement_ReturnFirstValue(){
          list.append(1);
          
          int first = list.first();
          
          assertEquals(1, first);
     }

        @Test
        @DisplayName("Testing first with no elements")
        void test_FirstNoElements_ThrowsDoubleLinkedQueueException(){
            assertThrows(DoubleLinkedQueueException.class, () -> list.first());
        }   

        @Test
        @DisplayName("Testing last element of an empty list")
        void test_LastEmpty_ReturnException() {

            assertThrows(DoubleLinkedQueueException.class, () -> {
                list.last();
            });
        }

        @Test
        @DisplayName("Testing last on a list")
        void test_Last_LastValue() {
            list.append(1);

            int expectedValue = 1;

            assertEquals(expectedValue, list.last());
        }

        @Test
        @DisplayName("Testing size")
        void test_Size_Return1(){
            list.append(1);
            
            int size = list.size();
            
            assertEquals(1, size);
        }
    }
}
