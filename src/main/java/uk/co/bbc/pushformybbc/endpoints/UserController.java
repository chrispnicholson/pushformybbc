package uk.co.bbc.pushformybbc.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uk.co.bbc.pushformybbc.dto.Note;
import uk.co.bbc.pushformybbc.dto.PushBulletNotification;
import uk.co.bbc.pushformybbc.dto.PushBulletResponse;
import uk.co.bbc.pushformybbc.dto.User;
import uk.co.bbc.pushformybbc.service.PushService;
import uk.co.bbc.pushformybbc.service.UserService;

import java.util.List;

/**
 * Created by Chris on 09-May-17.
 */

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PushService pushService;

    @RequestMapping(path = "v1/users", method = RequestMethod.POST)
    public @ResponseBody User registerUser(@RequestBody User user) {
        boolean isSuccess = userService.addUser(user);

        return user;
    }

    @RequestMapping(path = "v1/users", method = RequestMethod.GET)
    public List<User> retrieveListOfUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(path = "v1/push", method = RequestMethod.POST)
    public PushBulletResponse push(@RequestBody Note note) {
        PushBulletNotification pushBulletNotification = new PushBulletNotification();
        User user = userService.getUser(note.getUsername());
        pushBulletNotification.setType("note");
        pushBulletNotification.setBody(note.getNote());
        pushBulletNotification.setTitle(note.getNote());
        return pushService.push(pushBulletNotification, user);
    }
}
