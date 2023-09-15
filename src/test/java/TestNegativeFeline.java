import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestNegativeFeline {
    @Test
    public void testFelineFood() throws Exception {
        Feline newFeline = new Feline();
        List<String> expectedFood = List.of("Молоко", "Животные", "Птицы", "Рыба");
        List<String> actualFood = newFeline.eatMeat();
        if (expectedFood != actualFood) {
            System.out.println("Ошибка! Уберите " + expectedFood.get(0));
        } else {
            System.out.println("Всё нормик");
        }
        System.out.println("Actual Result: " + actualFood);
        System.out.println("Expected Result: " + expectedFood);
    }

    @Test
    public void testFelineFamily() {
        Feline newFeline = new Feline();
        String expectedFamily = "Поросячьи";
        String actualFamily = newFeline.getFamily();
        if(!expectedFamily.equals(actualFamily)){
            System.out.println("Ошибка - перепутали семью");
        } else {
            System.out.println("Всё нормик");
        }
        System.out.println("Actual Result: " + actualFamily);
        System.out.println("Expected Result: " + expectedFamily);
    }

    @Spy
    private Feline feline = new Feline();

    @Test
    public void testFelineKittens() {
        int actual = feline.getKittens(-2);
        int expected = 1;
        if(expected != actual && actual < 0){
            System.out.println("Ошибка - котята не могут быть отрицательным числом:");
        } else {
            System.out.println("Всё нормик");
        }
        System.out.println("Actual Result: " + actual);
        System.out.println("Expected Result: " + expected);
    }

    @Test
    public void testFelineKittensCount() {
        int expectedKittensCount = 5;
        int actualKittensCount = feline.getKittens(8);// фактический результат
        if(expectedKittensCount != actualKittensCount){
            System.out.println("Ошибка в котятах: ");
        } else {
            System.out.println("Всё нормик");
        }
        System.out.println("Actual Result: " + actualKittensCount);
        System.out.println("Expected Result: " + expectedKittensCount);
    }

}
