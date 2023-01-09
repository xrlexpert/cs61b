import org.junit.Test;
import static org.junit.Assert.*;
public class TestHelloWorld {
    @Test
    public void TestSort()
    {
        String []expected={"helloworld"};
        String []actaul=new String[]{HelloWorld.hah()};
        assertArrayEquals(expected,actaul);

    }
}
