import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mps.deque.*;

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
    @DisplayName("Testing deleteFirst with one element")
    void test_DeleteFirstOneElement_ReturnSize0(){
        list.append(1);  
        list.deleteFirst();
        
        int size = list.size();
        
        assertEquals(0, size);
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
     @DisplayName("Testing deleteFirst with two elements")
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
        @DisplayName("Testing size")
        void test_Size_Return1(){
            list.append(1);
            
            int size = list.size();
            
            assertEquals(1, size);
        }
    }
}
