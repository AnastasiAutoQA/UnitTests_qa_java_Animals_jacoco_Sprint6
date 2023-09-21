import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.List;

@RunWith(Parameterized.class)
public class TestLion {
    private final String sex;
    private final boolean expected;

    public TestLion(String sex, boolean expected) {
        this.sex = sex;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                {"Самец", true}, // грива есть
                {"Самка", false}, // гривы нет
        };
    }

    @Test
    public void testValidLionSex() throws Exception {
        Lion newLion = new Lion(sex);
        boolean actual = newLion.doesHaveMane();
        Assert.assertEquals(expected, actual);
        if (actual && expected) {
            System.out.println("Actual Result: " + sex + actual + " грива есть");
            System.out.println("Expected Result: " + sex + actual + " грива есть");
        } else {
            System.out.println("Actual Result: " + sex + actual + " гривы нет");
            System.out.println("Expected Result: " + sex + actual + " гривы нет");
        }
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
   }

    @Mock
    Feline mockedLion;

    @Test
    public void testLionKittens() throws Exception {
        Lion newLion = new Lion(mockedLion);
        Mockito.when(mockedLion.getKittens()).thenReturn(1);
        Assert.assertEquals(1, newLion.getKittens());
        System.out.println("Actual kittens: " + newLion.getKittens());
        System.out.println("Expected kittens: " + 1);
    }

    @Test
    public void testFelineEatMeat() throws Exception {
        Lion newLion = new Lion(mockedLion);
        Mockito.when(mockedLion.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expectedFood, newLion.getFood());
        System.out.println("Actual result: " + sex + " льва ест " + newLion.getFood());
        System.out.println("Expected result: " + sex + " льва ест " + expectedFood);
    }
}