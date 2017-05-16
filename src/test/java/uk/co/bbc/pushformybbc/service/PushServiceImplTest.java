package uk.co.bbc.pushformybbc.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import uk.co.bbc.pushformybbc.dto.PushBulletNotification;
import uk.co.bbc.pushformybbc.dto.PushBulletResponse;
import uk.co.bbc.pushformybbc.dto.User;

import java.util.Date;

import static org.junit.Assert.assertTrue;

/**
 * Created by Chris on 16-May-17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class PushServiceImplTest {

    @Autowired
    private PushService pushService;

    @Test
    public void pushBulletNotification() {
        User user = new User();
        user.setUsername("chris.nicholson@gmail.com");
        user.setAccessToken("o.JbP7sUcMBxQSR2ZsVfvCizG5xF3dP2cZ");
        user.setCreationTime(new Date());
        user.setNumOfNotificationsPushed(new Long(0));
        PushBulletNotification pushBulletNotification = new PushBulletNotification();
        pushBulletNotification.setTitle("Doctor Who");
        pushBulletNotification.setBody("BBC website that's about Doctor Who");
        pushBulletNotification.setType("link");
        pushBulletNotification.setUrl("http://www.bbc.co.uk/doctorwho");
        PushBulletResponse response = pushService.push(pushBulletNotification, user);
        assertTrue(response.isActive());
    }
}
