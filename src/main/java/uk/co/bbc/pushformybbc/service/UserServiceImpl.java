package uk.co.bbc.pushformybbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.bbc.pushformybbc.dto.User;
import uk.co.bbc.pushformybbc.repository.UserRepository;

import java.util.Date;
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

        user.setCreationTime(new Date());
        user.setNumOfNotificationsPushed(new Long(0));

        isSuccess = userRepository.addUser(user);

        return isSuccess;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.listAllUsers();
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
