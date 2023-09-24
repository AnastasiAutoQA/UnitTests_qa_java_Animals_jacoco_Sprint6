import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.List;

public class TestMockedLion {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    Feline mockedLion;

    @Test
    public void testLionKittens() throws Exception {
        Lion newLion = new Lion("Самец", mockedLion);
        Mockito.when(mockedLion.getKittens()).thenReturn(1);
        Assert.assertEquals(1, newLion.getKittens());
        System.out.println("Actual kittens: " + newLion.getKittens());
        System.out.println("Expected kittens: " + 1);
    }

    @Test
    public void testFelineEatMeat() throws Exception {
        Lion newLion = new Lion("Самка", mockedLion);
        Mockito.when(mockedLion.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expectedFood, newLion.getFood());
        System.out.println("Actual result: " + newLion.getFood());
        System.out.println("Expected result: " + expectedFood);
    }
}