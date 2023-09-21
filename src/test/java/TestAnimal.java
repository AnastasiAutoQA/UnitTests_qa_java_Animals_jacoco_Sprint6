import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;

@RunWith(Parameterized.class)
public class TestAnimal {
    private final String animalKind;
    private final List<String> expectedFood;

    public TestAnimal(String animalKind, List<String> expectedFood) {
        this.animalKind = animalKind;
        this.expectedFood = expectedFood;
    }

    @Parameterized.Parameters
    public static Object[][] getAnimalData() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Test
    public void testValidAnimal() throws Exception {
        Animal newAnimal = new Animal();
        List<String> actualFood = newAnimal.getFood(animalKind);
        Assert.assertEquals(expectedFood, actualFood);
        System.out.println("Actual Result: " + actualFood + " для " + animalKind);
        System.out.println("Expected Result: " + expectedFood + " для " + animalKind);
    }
    @Test
    public void testAnimalFamily() {
        Animal newAnimal = new Animal();
        String actualFamily = newAnimal.getFamily();
        String expectedFamily = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        Assert.assertEquals(expectedFamily, actualFamily);
        System.out.println("Actual result: " + actualFamily);
        System.out.println("Expected result: " + expectedFamily);
    }
}