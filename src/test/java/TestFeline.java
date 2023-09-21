import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestFeline {
    private Feline feline = new Feline();
    @Test
    public void testFelineFood() throws Exception {
        Feline newFeline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = newFeline.eatMeat();
        assertEquals(expectedFood, actualFood);
        System.out.println("Actual Result: " + actualFood);
        System.out.println("Expected Result: " + expectedFood);
    }
    @Test
    public void testFelineFamily() {
        Feline newFeline = new Feline();
        String expectedFamily = "Кошачьи";
        String actualFamily = newFeline.getFamily();
        assertEquals(expectedFamily, actualFamily);
        System.out.println("Actual Result: " + actualFamily);
        System.out.println("Expected Result: " + expectedFamily);
    }
    @Test
    public void testFelineKittens() {
        int actual = feline.getKittens();
        assertEquals(1, actual);
    }

    @Test
    public void testFelineKittensCount() {
        int expectedKittensCount = 8;
        int actualKittensCount = feline.getKittens(8);// фактический результат
        assertEquals(expectedKittensCount, actualKittensCount);
        System.out.println("Actual Result: " + actualKittensCount);
        System.out.println("Expected Result: " + expectedKittensCount);
    }
    @Spy
    private Feline felineMock = new Feline();
    @Test
    public void getFelineKittensInvokeTimes() {
       felineMock.getKittens();
       Mockito.verify(felineMock, Mockito.times(1)).getKittens();
    }

}