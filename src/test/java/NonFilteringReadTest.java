import model.AllocationCC;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.mongodb.core.query.Query;

import java.net.UnknownHostException;

import static org.junit.Assert.assertNotNull;
import static org.springframework.data.mongodb.core.query.Criteria.where;

public class NonFilteringReadTest {
    private MongoRunner mongoRunner;

    @Before
    public void setUp() { mongoRunner = new MongoRunner(); }

    @Test public void shouldSuccessfullyGetCC() throws UnknownHostException {
        Query query = new Query();
        query.addCriteria(where("ccNumber").is("851470006"));

        for(int i = 0; i < 100; i++) {
            AllocationCC cc = mongoRunner.getTemplate().findOne(query, AllocationCC.class);
            assertNotNull(cc);
        }
    }
}
