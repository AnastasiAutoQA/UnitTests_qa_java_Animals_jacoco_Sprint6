import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.fail;

public class TestNegativeAnimal {
    private List<String> expectedFood;

    public TestNegativeAnimal() {

    }

    @Test(expected = Exception.class)
    public void testUnknownAnimal() throws Exception {
        Animal newAnimal = new Animal();
        List<String> actualFood = newAnimal.getFood("ЧертЗнаетКто");
        Assert.assertEquals(expectedFood, actualFood);
    }

    @Test
    public void testExceptionMessage() {
        try {
            Animal newAnimal = new Animal();
            List<String> actualFood = newAnimal.getFood("КандиБобер");
            fail("Ожидалось исключение");
        } catch (Exception e) {
            String expectedMessage = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
            Assert.assertEquals(expectedMessage, e.getMessage());
            System.out.println("Actual Result: " + e.getMessage());
            System.out.println("Expected Result: " + expectedMessage);
        }
    }

}
