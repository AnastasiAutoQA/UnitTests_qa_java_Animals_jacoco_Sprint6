import com.example.Lion;
import org.junit.Test;
import static org.junit.Assert.assertThrows;

public class TestNegativeLion {

    @Test
    public void testLionSexException(){
        Exception exception = assertThrows(Exception.class, () -> new Lion("Квир"));
        String message = exception.getMessage();
        System.out.println(message);
    }
}
