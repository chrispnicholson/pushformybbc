package uk.co.bbc.pushformybbc.endpoints;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import uk.co.bbc.pushformybbc.dto.Note;
import uk.co.bbc.pushformybbc.dto.PushBulletResponse;
import uk.co.bbc.pushformybbc.dto.User;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Chris on 13-May-17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRegistrationControllerTest {

    @Autowired
    private UserRegistrationController userRegistrationController;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        userRegistrationController = null;
    }

    @Test
    public void registerUser() throws Exception {
        User toRegister = new User();
        toRegister.setUsername("bbcUser1");
        toRegister.setAccessToken("o.JbP7sUcMBxQSR2ZsVfvCizG5xF3dP2cZ");
        User result = userRegistrationController.registerUser(toRegister);
        assertNotNull(result);
        assertEquals(new Date(), result.getCreationTime());
        assertEquals(new Long(0), result.getNumOfNotificationsPushed());
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(result));
    }

    // strictly speaking an integration test, not a unit test
    @Test
    public void push() throws Exception {
        String username = "bbcUser1";
        User toRegister = new User();
        toRegister.setUsername(username);
        toRegister.setAccessToken("o.JbP7sUcMBxQSR2ZsVfvCizG5xF3dP2cZ");
        User result = userRegistrationController.registerUser(toRegister);
        assertEquals(new Long(0), result.getNumOfNotificationsPushed());
        Note note = new Note();
        note.setNote("Remember to get milk");

        PushBulletResponse response = userRegistrationController.push(note, username);
        assertTrue(response.isActive());
        assertEquals(new Long(1), toRegister.getNumOfNotificationsPushed());
    }

    @Test
    public void retrieveListOfUsers() throws Exception {
        User user1 = new User();
        String accessToken = "o.JbP7sUcMBxQSR2ZsVfvCizG5xF3dP2cZ";
        user1.setUsername("User1");
        user1.setAccessToken(accessToken);
        User user2 = new User();
        user2.setUsername("User2");
        user2.setAccessToken(accessToken);

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(user1));
        System.out.println(mapper.writeValueAsString(user2));

        userRegistrationController.registerUser(user1);
        userRegistrationController.registerUser(user2);

        List<User> listOfUsers = userRegistrationController.retrieveListOfUsers();
        assertEquals(3, listOfUsers.size());
        System.out.println(mapper.writeValueAsString(listOfUsers));
    }

    @Test
    public void testRegisterUserWithNoUsername() {
        // bad request 400
    }

    @Test
    public void testRegisterUserWithNoAccessToken() {
        // bad request 400
    }

    @Test
    public void testRegisterBlankUser() {
        // bad request 400
        User blankUser = new User();
        User result = userRegistrationController.registerUser(blankUser);

    }

    @Test
    public void contextLoads() throws Exception {
        assertNotNull(userRegistrationController);
    }
}