import com.example.Feline;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertNotEquals;
public class TestNegativeFeline {
    private Feline feline = new Feline();
    @Test
    public void testFelineFood() throws Exception {
        Feline newFeline = new Feline();
        List<String> expectedFood = List.of("Молоко", "Животные", "Птицы", "Рыба");
        List<String> actualFood = newFeline.eatMeat();
        assertNotEquals(expectedFood, actualFood);
        System.out.println("Ошибка! Уберите " + expectedFood.get(0));
        System.out.println("Actual Result: " + actualFood);
        System.out.println("Expected Result: " + expectedFood);
    }
    @Test
    public void testFelineFamily() {
        Feline newFeline = new Feline();
        String expectedFamily = "Поросячьи";
        String actualFamily = newFeline.getFamily();
        assertNotEquals(expectedFamily, actualFamily);
        System.out.println("Ошибка - перепутали семью");
        System.out.println("Actual Result: " + actualFamily);
        System.out.println("Expected Result: " + expectedFamily);
    }

    @Test
    public void testFelineKittens() {
        int actual = feline.getKittens(-2);
        int expected = 1;
        assert actual < 0;
        //assertNotEquals(expected, actual);
        System.out.println("Ошибка - котята не могут быть отрицательным числом:");
        System.out.println("Actual Result: " + actual);
        System.out.println("Expected Result: " + expected);
    }
    @Test
    public void testFelineKittensCount() {
        int expectedKittensCount = 5;
        int actualKittensCount = feline.getKittens(8);// фактический результат
        assertNotEquals(expectedKittensCount, actualKittensCount);
        System.out.println("Ошибка в котятах: ");
        System.out.println("Actual Result: " + actualKittensCount);
        System.out.println("Expected Result: " + expectedKittensCount);
    }

}
