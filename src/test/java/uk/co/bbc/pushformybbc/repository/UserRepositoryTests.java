package uk.co.bbc.pushformybbc.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import uk.co.bbc.pushformybbc.dto.User;

import static org.junit.Assert.assertEquals;

/**
 * Created by Chris on 13-May-17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    UserRepository inMemoryUserRepository;

    @Before
    public void setUp() {
        inMemoryUserRepository = new InMemoryUserRepository();
    }

    @After
    public void tearDown() {
        inMemoryUserRepository = null;
    }

    @Test
    public void listAllUsers() {
        User user1 = new User();
        user1.setUsername("User1");
        User user2 = new User();
        user2.setUsername("User2");
        User user3 = new User();
        user3.setUsername("User3");
        inMemoryUserRepository.addUser(user1);
        inMemoryUserRepository.addUser(user2);
        inMemoryUserRepository.addUser(user3);

        assertEquals(3, inMemoryUserRepository.listAllUsers().size());
    }
}
