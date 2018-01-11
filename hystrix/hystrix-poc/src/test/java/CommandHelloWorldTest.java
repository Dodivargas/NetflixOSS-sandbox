import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandHelloWorldTest {



@Test
public void withoutFallback(){
    assertEquals("Hello Dodivargas!", new CommandHelloWorld("Dodivargas", (long) 0).execute());
}

    @Test
    public void withFallback(){
        assertEquals("Isso é um fallback", new CommandHelloWorld("Dodivargas", (long) 2).execute());
    }

}
