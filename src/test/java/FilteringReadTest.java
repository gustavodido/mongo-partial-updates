import model.AllocationCC;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.mongodb.core.query.Query;

import java.net.UnknownHostException;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.springframework.data.mongodb.core.query.Criteria.where;

public class FilteringReadTest {
    private static final int LIMIT = 100;

    private MongoRunner mongoRunner;

    @Before
    public void setUp() { mongoRunner = new MongoRunner(); }

    @Test public void shouldSuccessfullyGetCC() throws UnknownHostException {
        Query query = new Query();
        query.addCriteria(where("brandId").is("1"));
        query.fields().include("ccNumber");
        query.limit(LIMIT);

        List<AllocationCC> ccs = mongoRunner.getTemplate().find(query, AllocationCC.class);
        assertThat(ccs.size(), is(LIMIT));
    }
}
