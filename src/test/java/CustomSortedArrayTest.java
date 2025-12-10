import com.google.gson.reflect.TypeToken;
import org.example.model.Inhabitant;
import org.example.utils.JSONmanipulation;
import org.example.utils.Sort;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomSortedArrayTest {
    public static List<Inhabitant> dataForTest;

    @BeforeAll
    public static void getTestData() {
        List<String> names = List.of("C", "A", "D", "B", "F", "E");
        List<String> types = List.of("dog", "cat", "snake", "dog", "cat", "snake");
        List<Inhabitant> inhabitants = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            Inhabitant inhabitant = new Inhabitant();
            inhabitant.setName(names.get(i));
            inhabitant.setType(types.get(i));
            inhabitants.add(inhabitant);
        }
        dataForTest = inhabitants;
    }

    @Test
    public void shouldReturnBubbleSortedArrayByNameAndAsc() {
        //Setup preconditions (Arrangements)
        List<String> expected = List.of("A", "B", "C", "D", "E", "F");
        String algorithm = "bubble";
        String sortByParameter = "name";
        boolean isAsc = true;

        //Actual method call (Act)
        List<Inhabitant> sortedArray = Sort.bubbleSortedArray(new ArrayList<>(dataForTest), isAsc, sortByParameter);

        //Verify results (Assert)
        List<String> result = new ArrayList<>();
        for (Inhabitant name : sortedArray) {
            result.add(name.getName());
        }
        assertEquals(expected, result);
    }

    @Test
    public void shouldThrowExeptionForBubbleWhenEmptyArray() {
        //Setup preconditions (Arrangements)
        String sortByParameter = "name";
        boolean isAsc = true;

        //Actual method call (Act)
        //************************

        //Verify results (Assert)
        Executable executable = new Executable() { //створюємо "інструкцію виклику для IllegalArgumentException exception
            @Override
            public void execute() throws Throwable {
                Sort.bubbleSortedArray(new ArrayList<>(), isAsc, sortByParameter);
            }
        };
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, executable);
        assertEquals("unsortedArray cannot be empty or null", exception.getMessage());
    }

    @Test
    public void shouldThrowExeptionForBubbleWhenIsAscFale() {
        //Setup preconditions (Arrangements)
        String sortByParameter = "name";
        boolean isAsc = false;

        //Actual method call (Act)
        //************************

        //Verify results (Assert)
        Executable executable = new Executable() { //створюємо "інструкцію виклику для IllegalArgumentException exception
            @Override
            public void execute() throws Throwable {
                Sort.bubbleSortedArray(new ArrayList<>(dataForTest), isAsc, sortByParameter);
            }
        };
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, executable);
        assertEquals("isAsk can`t be false. Currently, this methd only for asc order.", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionForBubbleWhenSortByParameterIsNotName() {
        //Setup preconditions (Arrangements)
        String sortByParameter = "type";
        boolean isAsc = true;

        //Actual method call (Act)
        //************************

        //Verify results (Assert)
        Executable executable = new Executable() { //створюємо "інструкцію виклику для IllegalArgumentException exception
            @Override
            public void execute() throws Throwable {
                Sort.bubbleSortedArray(new ArrayList<>(dataForTest), isAsc, sortByParameter);
            }
        };
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, executable);
        assertEquals("Currently, this method only for sorting by name.", exception.getMessage());
    }
}
