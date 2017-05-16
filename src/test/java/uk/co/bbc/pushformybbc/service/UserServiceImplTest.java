package uk.co.bbc.pushformybbc.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import uk.co.bbc.pushformybbc.dto.User;
import uk.co.bbc.pushformybbc.repository.UserRepository;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Created by Chris on 16-May-17.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    List<User> mockList;

    @InjectMocks
    private UserService userService = new UserServiceImpl();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(userService);
    }

    @Test
    public void addUser() throws Exception {
        User testUser = new User();
        testUser.setUsername("testUser");
        when(userRepository.addUser(testUser)).thenReturn(true);

        assertTrue(userService.addUser(testUser));
    }

    @Test
    public void getAllUsers() throws Exception {
        when(userRepository.listAllUsers()).thenReturn(mockList);
        when(mockList.size()).thenReturn(new Integer(3));

        assertEquals(3, userService.getAllUsers().size());
    }

    @Test
    public void getUser() throws Exception {
        String username = "testUser";
        User mockUser = new User();
        mockUser.setUsername(username);
        mockUser.setAccessToken("o.JbP7sUcMBxQSR2ZsVfvCizG5xF3dP2cZ");
        mockUser.setCreationTime(new Date());
        mockUser.setNumOfNotificationsPushed(new Long(0));
        when(userRepository.retrieveUser(username)).thenReturn(mockUser);
        assertEquals(new Long(0), mockUser.getNumOfNotificationsPushed());
    }
}