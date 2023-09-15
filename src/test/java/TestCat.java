import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestCat {
    @Mock
    Feline mockedFeline;

    @Test
    public void testCatSound() {
        Cat newCat = new Cat(mockedFeline);
        String actualSound = newCat.getSound();
        String expectedSound = "Мяу";
        Assert.assertEquals(expectedSound, actualSound);
        System.out.println("Actual Result: " + actualSound);
        System.out.println("Expected Result: " + expectedSound);
    }

    @Test
    public void testCatFood() throws Exception {
        Cat newCat = new Cat(mockedFeline);
        Mockito.when(mockedFeline.eatMeat()).thenReturn(List.of("Звери", "ВсеКтоНеВеган")); //замокали фактический результат
        List<String> expectedList = List.of("Звери", "ВсеКтоНеВеган"); // ожидаемый результат
        Assert.assertEquals(expectedList, newCat.getFood());
        System.out.println("Actual Result: " + mockedFeline.eatMeat());
        System.out.println("Expected Result: " + expectedList);
    }
}