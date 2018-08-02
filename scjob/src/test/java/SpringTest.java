import com.JobApplication;
import com.mq.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author szh
 * @create 2018-08-03 0:23
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JobApplication.class)
public class SpringTest {
    @Autowired
    Sender sender;

    @Test
    public void hello() throws Exception {
        this.sender.send();
    }
}
