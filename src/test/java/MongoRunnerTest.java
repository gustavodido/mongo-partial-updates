import model.AllocationCC;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.mongodb.core.query.Query;

import java.net.UnknownHostException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.data.mongodb.core.query.Criteria.where;

public class MongoRunnerTest
{
    private MongoRunner mongoRunner;

    @Before
    public void setUp() { mongoRunner = new MongoRunner(); }

    @Test public void shouldSuccessfullyConnectToDatabase() throws UnknownHostException {
        assertTrue("connectionTest should return 'true'", mongoRunner.connectionTest());
    }

    @Test public void shouldSuccessfullyGetCC() throws UnknownHostException {
        Query query = new Query();
        query.addCriteria(where("ccNumber").is("851470006"));

        AllocationCC cc = mongoRunner.getTemplate().findOne(query, AllocationCC.class);
        assertNotNull(cc);
    }
}
