import org.junit.Test;

import java.net.UnknownHostException;

import static org.junit.Assert.*;

public class MongoRunnerTest
{
    @Test public void testSomeLibraryMethod() throws UnknownHostException {
        MongoRunner classUnderTest = new MongoRunner();
        assertTrue("run should return 'true'", classUnderTest.run());
    }
}
