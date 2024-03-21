import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mps.deque.DoubleLinkedList;
import org.mps.deque.DoubleLinkedQueueException;

public class DoubleLinkedListTest {

    DoubleLinkedList<Integer> list;

    @BeforeEach
    void setup(){
        list = new DoubleLinkedList<>();
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

        Void expectedValue = null;
        int expectedSize = 0;

        assertEquals(expectedValue, list.last());
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


}
