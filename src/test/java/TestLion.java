import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

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

}