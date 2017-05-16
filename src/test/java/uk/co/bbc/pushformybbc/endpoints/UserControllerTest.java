package uk.co.bbc.pushformybbc.endpoints;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import uk.co.bbc.pushformybbc.dto.Note;
import uk.co.bbc.pushformybbc.dto.PushBulletResponse;
import uk.co.bbc.pushformybbc.dto.User;

import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Chris on 13-May-17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Value("${test.access-token}")
    private String accessToken;

    @Autowired
    private UserController userController;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        userController = null;
    }

    @Test
    public void registerUser() throws Exception {
        User toRegister = new User();
        toRegister.setUsername("bbcUser1");
        toRegister.setAccessToken(accessToken);
        User result = userController.registerUser(toRegister);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss");
        assertNotNull(result);
        assertEquals(simpleDateFormat.format(System.currentTimeMillis()), result.getCreationTime());
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
        toRegister.setAccessToken(accessToken);
        User result = userController.registerUser(toRegister);
        assertEquals(new Long(0), result.getNumOfNotificationsPushed());
        Note note = new Note();
        note.setUsername(username);
        note.setNote("Remember to get milk");

        PushBulletResponse response = userController.push(note);
        assertTrue(response.isActive());
        assertEquals(new Long(1), toRegister.getNumOfNotificationsPushed());
    }

    @Test
    public void retrieveListOfUsers() throws Exception {
        User user1 = new User();
        user1.setUsername("User1");
        user1.setAccessToken(accessToken);
        User user2 = new User();
        user2.setUsername("User2");
        user2.setAccessToken(accessToken);

        userController.registerUser(user1);
        userController.registerUser(user2);

        List<User> listOfUsers = userController.retrieveListOfUsers();
        assertEquals(3, listOfUsers.size());
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
        User result = userController.registerUser(blankUser);

    }

    @Test
    public void contextLoads() throws Exception {
        assertNotNull(userController);
    }
}