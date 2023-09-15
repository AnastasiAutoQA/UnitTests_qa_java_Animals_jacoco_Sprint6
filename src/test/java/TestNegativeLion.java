import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.fail;

public class TestNegativeLion {
    private boolean expected;

    public TestNegativeLion() {
    }

    @Test(expected = Exception.class)
    public void testInvalidLionSex() throws Exception {
        Lion newLion = new Lion("ГендерноНеопределившийся");
        boolean actual = newLion.doesHaveMane();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSexExceptionMessage() {
        try {
            Lion newLion = new Lion("Транс");
            boolean actual = newLion.doesHaveMane();
            Assert.assertEquals(expected, actual);
            fail("Ожидалось исключение");
        } catch (Exception e) {
            String expectedMessage = "Используйте допустимые значения пола животного - Самец или Самка";
            Assert.assertEquals(expectedMessage, e.getMessage());
            System.out.println("Actual Result: " + e.getMessage());
            System.out.println("Expected Result: " + expectedMessage);
        }
    }

}
