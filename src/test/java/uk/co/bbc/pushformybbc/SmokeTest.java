package uk.co.bbc.pushformybbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import uk.co.bbc.pushformybbc.endpoints.UserController;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Chris on 13-May-17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {

    @Autowired
    private UserController userController;

    @Test
    public void contextLoads() {
        assertNotNull(userController);
    }
}
