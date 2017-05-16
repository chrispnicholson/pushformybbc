package uk.co.bbc.pushformybbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.bbc.pushformybbc.dto.User;
import uk.co.bbc.pushformybbc.repository.UserRepository;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Chris on 16-May-17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean addUser(User user) {
        boolean isSuccess = false;
        // check if username and access token exist
//        if (user.getUsername() == null || user.getAccessToken() == null) {
//            throw new IllegalArgumentException("User needs username and access token");
//        }

        System.out.println("User " + user.getUsername() + " added to repository with access token " + user.getAccessToken());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss");

        user.setCreationTime(simpleDateFormat.format(System.currentTimeMillis()));
        user.setNumOfNotificationsPushed(new Long(0));

        isSuccess = userRepository.addUser(user);

        return isSuccess;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.listAllUsers();
    }

    @Override
    public User getUser(String username) {
        return userRepository.retrieveUser(username);
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
